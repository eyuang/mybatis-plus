package com.baomidou.mybatisplus.test.mysql;

import com.baomidou.mybatisplus.MybatisSessionFactoryBuilder;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.test.mysql.entityplus.UserPlus;
import com.baomidou.mybatisplus.test.mysql.mapper.UserMapperPlus;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Simon Huang
 */
public class UserMapperPlusTest extends TestCase {

    private SqlSessionFactory factory;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        InputStream in = UserMapperPlusTest.class.getClassLoader().getResourceAsStream("mysql-config-plus.xml");

        MybatisSessionFactoryBuilder mf = new MybatisSessionFactoryBuilder();

        GlobalConfiguration gc = new GlobalConfiguration(new MySqlInjector());
        gc.setMetaObjectHandler(new MyMetaObjectHandler());
        gc.setDbColumnUnderline(true);
        mf.setGlobalConfig(gc);

        factory = mf.build(in);
    }

    public void testCreate() {

        SqlSession session = factory.openSession();
        UserMapperPlus userMapper = session.getMapper(UserMapperPlus.class);

        UserPlus userA = new UserPlus();
        userA.setId(IdWorker.getId());
        userA.setUserName("junyu_shi");
        userA.setAge(1);
        userA.setTestType(1);

        userMapper.insert(userA);
        UserPlus whereUser = userMapper.selectOne(userA);
        print(whereUser);

        List<UserPlus> ul = new ArrayList<>();

        ul.add(new UserPlus(11L, "1", 1, 0));
        ul.add(new UserPlus(12L, "2", 2, 1));
        ul.add(new UserPlus(13L, "3", 3, 1));
        ul.add(new UserPlus(14L, "delname", 4, 0));
        ul.add(new UserPlus(15L, "5", 5, 1));
        ul.add(new UserPlus(16L, "6", 6, 0));

        ul.add(new UserPlus(17L, 7));
        ul.add(new UserPlus(18L, 8));
        ul.add(new UserPlus(19L, 9));
        ul.add(new UserPlus(7));
        ul.add(new UserPlus(20L, "deleteByMap", 7, 0));

        ul.add(new UserPlus("8", 8, 1));
        ul.add(new UserPlus("9", 9, 1));
        for (UserPlus u : ul) {
            userMapper.insert(u);
        }
        session.commit();
    }

    public void testSelectPage() {

        SqlSession session = factory.openSession();
        UserMapperPlus userMapper = session.getMapper(UserMapperPlus.class);

        EntityWrapper<UserPlus> ew = new EntityWrapper<>();

        ew.setSqlSelect("age, user_name");

        ew.where("user_name like {0}", "%junyu%").and("age={0}", 1).orderBy("age, user_name", true);

        Page<UserPlus> page = new Page<>(1, 2);

        List<UserPlus> pageList = userMapper.selectPage(page, ew);
        page.setRecords(pageList);
        for (int i = 0; i < page.getRecords().size(); i++) {
            print(page.getRecords().get(i));
        }
        System.err.println(" 翻页：" + page.toString());


        ew = new EntityWrapper<>();
        ew.setSqlSelect("age, user_name");
        ew.where("1 = 1").and().like("user_name", "junyu")
                .and("age={0}", 1).orderBy("age, user_name", true);

        page = new Page<>(1, 3);

        pageList = userMapper.selectPage(page, ew);
        page.setRecords(pageList);
        for (int i = 0; i < page.getRecords().size(); i++) {
            print(page.getRecords().get(i));
        }
        System.err.println(" 翻页：" + page.toString());
    }

    public void testSelectList() {

        SqlSession session = factory.openSession();
        UserMapperPlus userMapper = session.getMapper(UserMapperPlus.class);

        com.github.pagehelper.Page page = PageHelper.startPage(1, 5);

        EntityWrapper<UserPlus> ew = new EntityWrapper<>();
        ew.setSqlSelect("*");
        ew.isNotNull("user_name").isNull("phone").le("age", 9);
//        ew.where("1 = 1").and().isNotNull("user_name").like("phone", "abc").eq("age", 33);

        userMapper.selectList(ew);

        PageInfo pageInfo = new PageInfo(page);

        System.err.println(" 共有 " + pageInfo.getSize() + " 条数据。");

    }

    public void testSelectAll() {
        SqlSession session = factory.openSession();
        UserMapperPlus userMapper = session.getMapper(UserMapperPlus.class);

        PageHelper.startPage(1, 10);
        List<UserPlus> result = userMapper.selectAll();
        for (UserPlus user : result) {
            print(user);
        }
        System.err.println(" 共有 " + result.size() + " 条数据。");
    }

    /*
     * 打印测试信息
     */
    private static void print(UserPlus user) {
        if (user != null) {
            System.out.println("\n user: id=" + user.getId() + ", user_name=" + user.getUserName() + ", age=" + user.getAge()
                    + ", testType=" + user.getTestType());
        } else {
            System.out.println("\n user is null.");
        }
    }

}
