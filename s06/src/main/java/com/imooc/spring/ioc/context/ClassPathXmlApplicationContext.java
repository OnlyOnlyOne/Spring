package com.imooc.spring.ioc.context;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private Map iocContainer = new HashMap();
    public ClassPathXmlApplicationContext() {
        try {
            String filePath = this.getClass().getResource("/applicationContext.xml").getPath();
            filePath = new URLDecoder().decode(filePath,"UTF-8");
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(filePath));
            List<Node> nodes = document.getRootElement().selectNodes("bean");
            for (Node node : nodes) {
                Element ele = (Element) node;
                String id = ele.attributeValue("id");
                String className = ele.attributeValue("class");
                /*
                * 反射技术，只需要把对应的className加入到Class.forName(className),就能得到只能的类的对象
                * */
                Class c = Class.forName(className);
                Object obj = c.newInstance();
                List<Node> properties = ele.selectNodes("property");
                for (Node p : properties) {
                    Element property = (Element) p;
                    String propName = property.attributeValue("name");
                    String propValue = property.attributeValue("value");

                    String setMethodName = "set" + propName.substring(0, 1).toUpperCase() + propName.substring(1);
                    System.out.println(setMethodName + "准备执行");
                    //反射技术
                    Method setMethod = c.getMethod(setMethodName, String.class);
                    setMethod.invoke(obj,propValue);//通过setter方法注入数据

                }
                iocContainer.put(id, obj);
            }
            System.out.println(iocContainer);
            System.out.println("IOC容器初始化完毕");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanId) {
        return iocContainer.get(beanId);

    }
}
