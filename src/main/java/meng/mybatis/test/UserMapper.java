package meng.mybatis.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> findUsers();

    User findUserByUserid(int id);
}
