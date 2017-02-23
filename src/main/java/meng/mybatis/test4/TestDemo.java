package meng.mybatis.test4;


public class TestDemo {
	public static void main(String[] args) {
		OODao dao = new OODao();
		Classes c = dao.getClassForId(1);
		System.out.println(c);
		
		c = dao.getClassForId2(1);
		System.out.println(c);
	}
}
