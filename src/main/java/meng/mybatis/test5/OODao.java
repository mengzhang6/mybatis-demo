package meng.mybatis.test5;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OODao {
	
	private static SqlSessionFactory factory = null;

	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public Classes getClassForId3(int id){
		SqlSession session = factory.openSession(true);
		Classes c = session.selectOne("userMapper5.getClassForId3",id);
		session.close();
		return c;
	}
	
	public Classes getClassForId4(int id){
		SqlSession session = factory.openSession(true);
		Classes c = session.selectOne("userMapper5.getClassForId4",id);
		session.close();
		return c;
	}

}
