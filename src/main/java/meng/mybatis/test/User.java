package meng.mybatis.test;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户类
 * 
 * @author mengzhang6
 *
 */
@TableName("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	private int id;
	private String name;
	private int age;

	@TableField(value = "stu_id")
	private String stuId;
}
