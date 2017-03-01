package meng.mybatis.pic;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class PictureDao {

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

	public Picture getPicByName(String picname) {
		SqlSession session = factory.openSession(true);
		Picture c = session.selectOne("picmapper.getPicByName", picname);
		session.close();
		return c;
	}


}
