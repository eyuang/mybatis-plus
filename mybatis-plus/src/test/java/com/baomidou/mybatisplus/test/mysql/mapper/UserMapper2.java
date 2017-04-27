
package com.baomidou.mybatisplus.test.mysql.mapper;


import com.baomidou.mybatisplus.test.mysql.MyBaseMapper;
import com.baomidou.mybatisplus.test.mysql.entityplus.User2;

import java.util.List;

public interface UserMapper2 extends MyBaseMapper<User2> {

    List<User2> selectAll();

}
