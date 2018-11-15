package meng.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 参考资料：https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
 */
public class Test {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserMapper userMapper = context.getBean(UserMapper.class);

        // 第三页 每页5条
        PageHelper.startPage(3, 5);

        // 从下标为3的开始 每页5条
        //PageHelper.offsetPage(3, 5);

        PageInfo pageInfo = new PageInfo(userMapper.findUsers());
        System.out.println(pageInfo);
    }

    public static void printer(List<User> list) {
        System.out.println("->->->->->->-->->->->->->-->->->->->->->->");
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
