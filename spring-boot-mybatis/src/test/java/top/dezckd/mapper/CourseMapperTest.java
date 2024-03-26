package top.dezckd.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.dezckd.entity.Course;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author DEZ
 * @Date 2024/3/26
 * @Description CourseMapperTest
 */
@SpringBootTest
@Slf4j
class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

    @Test
    void selectAll() {
        List<Course> courses = courseMapper.selectAll();
        courses.forEach(course -> log.info(String.valueOf(course)));
    }
}