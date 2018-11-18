# Mybatis 学习笔记四 MyBatis-Plus插件


## maven依赖

```
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus</artifactId>
            <version>3.0.5</version>
        </dependency>

        <dependency>
            <groupId>org.apache.velocity</groupId>
            <artifactId>velocity-engine-core</artifactId>
            <version>2.0</version>
        </dependency>

        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>2.3.28</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.4</version>
            <scope>provided</scope>
        </dependency>

```

## 配置

### mybatis配置
conf.xml
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

</configuration>
```

注意：保持基本配置即可；


### spring配置
applicationContext.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.2.xsd">

    <!--
    driver=com.mysql.jdbc.Driver
    url=jdbc:mysql://127.0.0.1:3306/mybatis
    username=root
    password=root
    -->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://127.0.0.1:3306/mybatis"/>
        <property name="username" value="root"/>
        <property name="password" value="root"/>
    </bean>

    <!-- MyBatis配置 org.mybatis.spring.SqlSessionFactoryBean-->
    <bean id="sqlSessionFactory" class="com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="configLocation" value="classpath:conf.xml"/>
        <property name="mapperLocations" value="classpath:mapper/**/*Mapper.xml"/>
        <property name="typeAliasesPackage" value="meng.mybatis.test"/>
    </bean>

    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--UserMapper接口所在位置-->
        <property name="basePackage" value="meng.mybatis.test"/>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    </bean>
</beans>
```


### mapper配置
userMapper.xml
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- 命名空间 -->
<mapper namespace="meng.mybatis.test.UserMapper">
    <!-- resultType可以定义简称 -->
    <select id="findUserByUserid" parameterType="int" resultType="meng.mybatis.test.User">
		select * from users where id = #{id}
	</select>

    <select id="findUsers" resultType="meng.mybatis.test.User">
		select * from users
	</select>
</mapper>
```

meng.mybatis.test.UserMapper类
```
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> findUsers();

    User findUserByUserid(int id);
}
```


### 实体类
User.java
```
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
```



## 测试

```
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        User user =  userMapper.selectById(1);
        System.out.println(user]");
```
## 源码
[github地址](https://github.com/mengzhang6/mybatis-demo/tree/mybatis-plus)