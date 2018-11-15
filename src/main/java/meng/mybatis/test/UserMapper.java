package meng.mybatis.test;

import java.util.List;

public interface UserMapper {
    List<User> findUsers();

    User findUserByUserid(int id);
}
