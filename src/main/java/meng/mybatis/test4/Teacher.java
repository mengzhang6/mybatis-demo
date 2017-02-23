package meng.mybatis.test4;

/**
 * 老师类
 * 
 * @author mengzhang6
 *
 */
public class Teacher {
	private int tid;
	private String tname;

	public Teacher() {
		super();
	}

	public Teacher(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + "]";
	}

}
