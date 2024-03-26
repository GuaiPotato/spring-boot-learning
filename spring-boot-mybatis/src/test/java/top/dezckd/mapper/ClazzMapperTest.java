package top.dezckd.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.dezckd.entity.Clazz;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author DEZ
 * @Date 2024/3/26
 * @Description ClazzMapperTest
 */
@SpringBootTest
@Slf4j
class ClazzMapperTest {
    @Resource
    private ClazzMapper clazzMapper;

    @Test
    void getClazzOneToMany() {
        Clazz clazz = clazzMapper.getClazzOneToMany(1);
        log.info(String.valueOf(clazz.getClazzId()));
        log.info(clazz.getClazzName());
        clazz.getStudents().forEach(student -> log.info(String.valueOf(student)));
    }

    @Test
    void getClazz() {
        Clazz clazz = clazzMapper.getClazz(1);
        log.info(clazz.getClazzName());
        log.info(clazz.getTeacher().getTeacherName());
        clazz.getStudents().forEach(student -> log.info(student.getStudentName()+ " - " + student.getHometown()));
    }
}