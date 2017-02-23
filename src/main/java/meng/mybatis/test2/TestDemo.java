package meng.mybatis.test2;

import java.util.List;

import org.junit.Test;

public class TestDemo {

	private UserDao dao = new UserDao();

	@Test
	public void addUserTest() {
		User user = new User(-1, "Tom", 18);
		dao.addUser(user);
	}

	@Test
	public void updateUserTest() {
		User user = new User(4, "Tom", 16);
		dao.updateUser(user);
	}

	@Test
	public void deleteUserTest() {
		dao.deleteUser(5);
	}

	@Test
	public void findUserTest() {
		User user = dao.getUserById(1);
		System.out.println(user);
	}

	@Test
	public void findAllUserTest() {
		List<User> users = dao.getAllUser();
		for (User user : users)
			System.out.println(user);
	}

	@Test
	public void getUsersLikeNameTest() {
		List<User> users = dao.getUsersLikeName("t");
		for (User user : users)
			System.out.println(user);
	}
}
