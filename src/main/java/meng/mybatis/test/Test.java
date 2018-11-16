package meng.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(reader);
		SqlSession sqlSession = factory.openSession();

		String statement = "userMapper.findUserByUserid";
		User user = sqlSession.selectOne(statement, 1);
		System.out.println(user);
	}
}
