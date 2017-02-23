package meng.mybatis.test2;

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

	/**
	 * 首先加载factory
	 */
	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 添加
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		// SqlSession session = factory.openSession();
		// int num = session.insert("userMapper2.addUser", user);
		// session.commit();
		// System.out.println(num);
		// session.close();

		// 或者
		SqlSession session = factory.openSession(true);
		int num = session.insert("userMapper2.addUser", user);
		System.out.println(num);
		session.close();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteUser(int id) {
		SqlSession session = factory.openSession(true);
		int num = session.delete("userMapper2.deleteUser", id);
		System.out.println(num);
		session.close();
	}

	/**
	 * 修改
	 * 
	 * @param user
	 */
	public void updateUser(User user) {
		SqlSession session = factory.openSession(true);
		int num = session.update("userMapper2.updateUser", user);
		System.out.println(num);
		session.close();
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(int id) {
		SqlSession session = factory.openSession(true);
		User user = session.selectOne("userMapper2.findUserByUserid", id);
		session.close();
		return user;
	}

	/**
	 * 获取所有
	 * 
	 * @return
	 */
	public List<User> getAllUser() {
		SqlSession session = factory.openSession(true);
		List<User> users = new ArrayList<User>();
		users = session.selectList("userMapper2.findAllUser");
		return users;

	}

	/**
	 * 模糊查询
	 * 
	 * @param name
	 * @return
	 */
	public List<User> getUsersLikeName(String name) {
		SqlSession session = factory.openSession(true);
		List<User> users = new ArrayList<User>();
		users = session.selectList("userMapper2.findUsersLikeName", "%" + name
				+ "%");
		return users;
	}

}
