# Mybatis 学习笔记三 搭配pageHelper分页插件使用

基于《Mybatis 学习笔记二 与spring搭配》

## maven依赖

```
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.1.6</version>
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

    <!-- MyBatis配置 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="configLocation" value="classpath:conf.xml"/>
        <property name="mapperLocations" value="classpath:mapper/**/*Mapper.xml"/>
        <property name="plugins">
            <array>
                <bean class="com.github.pagehelper.PageInterceptor">
                    <property name="properties">
                        <value>
                            helperDialect=mysql
                        </value>
                    </property>
                </bean>
            </array>
        </property>
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
public interface UserMapper {
    List<User> findUsers();

    User findUserByUserid(int id);
}
```


## 测试

```
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserMapper userMapper = context.getBean(UserMapper.class);

        // 第三页 每页5条
        PageHelper.startPage(3, 5);

        // 从下标为3的开始 每页5条
        //PageHelper.offsetPage(3, 5);

        PageInfo pageInfo = new PageInfo(userMapper.findUsers());
        System.out.println(pageInfo);
```
## 源码
[github地址](https://github.com/mengzhang6/mybatis-demo/tree/mybatis-spring)