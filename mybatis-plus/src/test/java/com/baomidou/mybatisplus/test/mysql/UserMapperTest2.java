
package com.baomidou.mybatisplus.test.mysql;

import com.baomidou.mybatisplus.MybatisSessionFactoryBuilder;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.test.mysql.entityplus.User2;
import com.baomidou.mybatisplus.test.mysql.mapper.UserMapper2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserMapperTest2 {

    @Test
    public void testSelectAll() {

        /*
            before run this, comment

        rlt = userMapper.deleteAll();
        System.err.println("清空测试数据！ rlt=" + rlt);

            in UserMapperTest.java and run its main() function to add users first.
         */

        InputStream in = UserMapperTest2.class.getClassLoader().getResourceAsStream("mysql-config2.xml");

        MybatisSessionFactoryBuilder mf = new MybatisSessionFactoryBuilder();

        GlobalConfiguration gc = new GlobalConfiguration(new MySqlInjector());
        gc.setMetaObjectHandler(new MyMetaObjectHandler());
        gc.setDbColumnUnderline(true);
        mf.setGlobalConfig(gc);

        SqlSessionFactory sessionFactory = mf.build(in);
        SqlSession session = sessionFactory.openSession();
        UserMapper2 userMapper = session.getMapper(UserMapper2.class);

        List<User2> result = userMapper.selectAll();
        for (User2 user : result) {
            print(user);
        }
        System.err.println(" 共有 " + result.size() + " 条数据。");
    }

    private static void print(User2 user) {
        if (user != null) {
            System.out.println("\n user: id=" + user.getId() + ", name=" + user.getName() + ", age=" + user.getAge()
                    + ", testType=" + user.getTestType());
        } else {
            System.out.println("\n user is null.");
        }
    }
}
