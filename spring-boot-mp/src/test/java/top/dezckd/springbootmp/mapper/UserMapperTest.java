package top.dezckd.springbootmp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.dezckd.springbootmp.entity.UserDO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author DEZ
 * @Date 2024/4/1
 * @Description UserMapperTest
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    @Order(1)
    void insert() {
        UserDO user = new UserDO()
                .setUsername("李" + ((int)(Math.random() * 90) + 10))
                .setPhone(String.valueOf(1000000000000L + Math.round(900000000000L)))
                .setGender(Math.random() == 0
                        ? "男"
                        : "女"
                );
        userMapper.insert(user);
    }

    @Test
    @Order(4)
    void delete() {
//        根据 id 删除
        userMapper.deleteById(12);

//        userMapper.delete(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, "李46"));
    }

    @Test
    @Order(2)
    void update() {
        userMapper.update(new UserDO().setUsername("test用户名"), new LambdaQueryWrapper<UserDO>().eq(UserDO::getPhone, "10002"));


//        userMapper.update(null, new LambdaUpdateWrapper<UserDO>()
//                .set(UserDO::getCreateTime, LocalDateTime.now())
//                .eq(UserDO::getId, 5));
    }

    @Test
    @Order(3)
    void Select() {
//        UserDO user = userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getPhone, "10001"));

        userMapper.selectList(new LambdaQueryWrapper<UserDO>().like(UserDO::getUsername, "王"));

//        userMapper.selectList(new LambdaQueryWrapper<UserDO>());
    }

    @Test
    @Order(5)
    void orderBy() {
        userMapper.selectList(Wrappers.<UserDO>query().orderByAsc("phone"));

//        userMapper.selectList(Wrappers.<UserDO>query().orderByAsc(Lists.newArrayList("create_time", "phone")));

//        userMapper.selectList(new LambdaQueryWrapper<UserDO>().orderByAsc(UserDO::getUsername).orderByDesc(UserDO::getCreateTime));
    }

    @Test
    @Order(6)
    void groupBy() {
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.select("gender, count(*) as total").groupBy("gender");
        List<Map<String, Object>> mapList = userMapper.selectMaps(wrapper);
        System.out.println(mapList);
    }

    @Test
    @Order(7)
    void testSelectMaxId() {
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.select("max(id) as id");
        UserDO userDO = userMapper.selectOne(wrapper);
        System.out.println(userDO);
    }

    @Test
    @Order(8)
    void selectPage() {
        Page<UserDO> page = new Page<>(2, 4);
        Page<UserDO> userPage = userMapper.selectPage(page, null);
        System.out.println(userPage);
    }
}