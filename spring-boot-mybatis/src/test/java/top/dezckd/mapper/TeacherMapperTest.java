package top.dezckd.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.dezckd.entity.Teacher;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author DEZ
 * @Date 2024/3/26
 * @Description TeacherMapperTest
 */
@SpringBootTest
@Slf4j
class TeacherMapperTest {

    @Resource
    private TeacherMapper teacherMapper;

    @Test
    void selectOneByOne() {
        Teacher teacher = teacherMapper.selectOneByOne(1);
        log.info(teacher.getTeacherName() + "," + teacher.getClazz().getClazzName());
    }
}