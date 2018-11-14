
# maven依赖

```
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.3.1</version>
    </dependency>
```

# mybatis基础配置

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
 ...
</configuration>
```

# mapper配置

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- 命名空间 -->
<mapper namespace="userMapper">
 ...
</mapper>
```


## test1:基础

## test2:XML文件配置方式

## test3:注解方式

## test4:一对一

## test5;一对多