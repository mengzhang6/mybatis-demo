package meng.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder()
                .build(reader);
        SqlSession sqlSession = factory.openSession();

        String method = "userMapper.findUsers";
//        List<User> userList = sqlSession.selectList(method);
//        printer(userList);

        List<User> userList2 = sqlSession.selectList(method, null, new RowBounds(3, 5));
        printer(userList2);
    }

    public static void printer(List<User> list) {
        System.out.println("->->->->->->-->->->->->->-->->->->->->->->");
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
