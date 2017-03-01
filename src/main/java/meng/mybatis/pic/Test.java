package meng.mybatis.pic;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	public static void main(String[] args) {
		PictureDao dao = new PictureDao();
		Picture p = dao
				.getPicByName("70fbebf6-2345-46b5-9c6a-7294226f5d86.png");
		System.out.println(p.getPicname());
		InputStream in = p.getImg();

		try {
			OutputStream os = new FileOutputStream("D://1.jpg");
			int bytesRead = 0;
			byte[] buffer = new byte[1024];
			while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
