package meng.mybatis.test3;

import java.util.List;

import org.junit.Test;

public class TestDemo {

	private UserDao dao = new UserDao();

	@Test
	public void addUserTest() {
		User user = new User(-1, "Juny", 18);
		dao.addUser(user);
	}

	@Test
	public void updateUserTest() {
		User user = new User(1, "Kang", 17);
		dao.updateUser(user);
	}

	@Test
	public void deleteUserTest() {
		dao.deleteUser(3);
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
}
