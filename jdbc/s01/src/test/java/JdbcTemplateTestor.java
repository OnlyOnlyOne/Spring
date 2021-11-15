import com.imooc.spring.jdbc.dao.EmployeeDao;
import com.imooc.spring.jdbc.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)//把JUnit4的控制权给Spring
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JdbcTemplateTestor {
    @Resource
    private EmployeeDao employeeDao;

    @Test
    public void testFindById() {
        Employee employee = employeeDao.findById(3308);
        System.out.println(employee);
    }

    @Test
    public void testFindByDname() {
        System.out.println(employeeDao.findByDnames(""));

    }
    @Test
    public void testFindMapByDname() {
        System.out.println(employeeDao.findMapByDname("研发部"));

    }

    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setEno(8888);
        employee.setEname("赵六");
        employee.setSalary(6666f);
        employee.setDname("研发部");
        employee.setHiredate(new Date());
        employeeDao.insert(employee);
    }
}
