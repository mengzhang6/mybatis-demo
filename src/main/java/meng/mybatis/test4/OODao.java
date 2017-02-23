package meng.mybatis.test4;

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
	
	public Classes getClassForId(int id){
		SqlSession session = factory.openSession(true);
		Classes c = session.selectOne("userMapper4.getClassForId",id);
		session.close();
		return c;
	}
	
	public Classes getClassForId2(int id){
		SqlSession session = factory.openSession(true);
		Classes c = session.selectOne("userMapper4.getClassForId2",id);
		session.close();
		return c;
	}

}
