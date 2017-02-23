package meng.mybatis.test5;

import java.util.List;

/**
 * 班级类
 * 
 * @author mengzhang6
 *
 */
public class Classes {
	private int cid;
	private String cname;
	private Teacher teacher;
	// 学生集合的引用
	private List<Student> students;

	public Classes() {
		super();
	}

	public Classes(int cid, String cname, Teacher teacher) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.teacher = teacher;
	}

	public Classes(int cid, String cname, Teacher teacher,
			List<Student> students) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.teacher = teacher;
		this.students = students;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classes [cid=" + cid + ", cname=" + cname + ", teacher="
				+ teacher + ", students=" + students + "]";
	}

}
