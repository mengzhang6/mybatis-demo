## maven依赖

```
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.3.1</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.38</version>
        </dependency>
```

## 配置

mybatis配置文件

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<!-- 注册db的配置文件 -->
	<properties resource="db.propterties" />
	

	<!-- 数据库信息 -->
	<environments default="development">
		<environment id="development">
			<transactionManager type="JDBC" />
			<dataSource type="POOLED">
				<property name="driver" value="${driver}" />
				<property name="url" value="${url}" />
				<property name="username" value="${username}" />
				<property name="password" value="${password}" />
			</dataSource>
		</environment>
	</environments>
	
	<!-- mapper注册 -->
	<mappers>
		<mapper resource="mapper/userMapper.xml" />
	</mappers>
</configuration>
```

注意，configuration配置下各个配置项的顺序：
```
    properties?, settings?, 
    typeAliases?, typeHandlers?, 
    objectFactory?,objectWrapperFactory?, 
    plugins?, 
    environments?, databaseIdProvider?, mappers?
```

mapper配置

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- 命名空间 -->
<mapper namespace="userMapper">
	<!-- resultType可以定义简称 -->
	<select id="findUserByUserid" parameterType="int" resultType="meng.mybatis.test.User">
		select * from users where id = #{id}
	</select>
</mapper>
```


## 测试

```
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(reader);
		SqlSession sqlSession = factory.openSession();

		String statement = "userMapper.findUserByUserid";
		User user = sqlSession.selectOne(statement, 1);
		System.out.println(user);
```

## 源码
[github地址](https://github.com/mengzhang6/mybatis-demo/tree/mybatis-base)