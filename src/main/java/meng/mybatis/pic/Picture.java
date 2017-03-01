package meng.mybatis.pic;

import java.io.InputStream;

public class Picture {
	private String idpic;
	private String picname;
	private InputStream img;
	private String version;
	private String proname;

	public String getIdpic() {
		return idpic;
	}

	public void setIdpic(String idpic) {
		this.idpic = idpic;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public InputStream getImg() {
		return img;
	}

	public void setImg(InputStream img) {
		this.img = img;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

}
