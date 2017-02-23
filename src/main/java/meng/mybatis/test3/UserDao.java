package meng.mybatis.test3;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDao {

	private static SqlSessionFactory factory = null;

	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addUser(User user) {
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.insertUser(user);
		session.close();
	}

	public void deleteUser(int id) {
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.deleteUser(id);
		session.close();
	}

	public void updateUser(User user) {
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.updateUser(user);
		session.close();
	}

	public User getUserById(int id) {
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.getUserById(id);
		session.close();
		return user;
	}

	public List<User> getAllUser() {
		SqlSession session = factory.openSession(true);
		List<User> users = new ArrayList<User>();
		UserMapper mapper = session.getMapper(UserMapper.class);
		users = mapper.getAllUser();
		return users;

	}

}
