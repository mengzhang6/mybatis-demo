package meng.mybatis.test5;


public class TestDemo {
	public static void main(String[] args) {
		OODao dao = new OODao();
		Classes c = dao.getClassForId3(1);
		System.out.println(c);
		
		c = dao.getClassForId4(1);
		System.out.println(c);
	}
}
