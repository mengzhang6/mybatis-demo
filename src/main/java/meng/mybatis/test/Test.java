package meng.mybatis.test;

import com.baomidou.ant.meng.mapper.EmployeeMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * 参考资料：https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
 */
public class Test {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

//        EmployeeMapper employeeMapper = context.getBean(EmployeeMapper.class);
//        printList(employeeMapper.selectList(null));

        UserMapper userMapper = context.getBean(UserMapper.class);
        User user =   userMapper.selectById(1);
        System.out.println("args = [" + user + "]");
    }

    public static void printList(List list) {
        System.out.println("->->->->->->-->->->->->->-->->->->->->->->");
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
