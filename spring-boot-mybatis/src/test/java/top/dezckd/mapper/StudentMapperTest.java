package top.dezckd.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.internal.matchers.Or;
import org.springframework.boot.test.context.SpringBootTest;
import top.dezckd.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author DEZ
 * @Date 2024/3/25
 * @Description StudentMapperTest
 */
@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    @Order(1)
    void insert() {
        Student student = Student.builder().clazzId(1).studentName("测试学生").hometown("江苏南京").birthday(LocalDate.now()).build();
        int n = studentMapper.insert(student);
        assertEquals(1, n);
    }

    @Test
    @Order(2)
    void findStudentById() {
        Student student = studentMapper.findStudentById(1001);
        assertEquals("王大锤", student.getStudentName());
    }

    @Test
    @Order(3)
    void updateById() {
        Student student = Student.builder().studentId(1001).studentName("新的名字").build();
        int n = studentMapper.updateById(student);
        assertEquals(1, n);
    }

    @Test
    @Order(4)
    void deleteById() {
        int res = studentMapper.deleteById(1007);
        assertEquals(1, res);
    }

    @Test
    @Order(5)
    void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .studentId(8000 + i)
                    .clazzId(1)
                    .studentName("测试学生" + i)
                    .hometown("江苏南京")
                    .birthday(LocalDate.now())
                    .build();
            students.add(student);
        }
        int n = studentMapper.batchInsert(students);
        assertEquals(10, n);
    }

    @Test
    @Order(8)
    void batchDelete() {
        List<Integer> idList = List.of(8000, 8001, 8002);
        int n = studentMapper.batchDelete(idList);
        assertEquals(3, n);
    }

    @Test
    @Order(7)
    void batchUpdate() {
        List<Student> list = new ArrayList<>();
        for (int i = 3; i < 7; i++) {
            list.add(Student.builder().studentId(1000 + i).birthday(LocalDate.now()).build());
        }
        int n = studentMapper.batchUpdate(list);
        // 只能验证最后一次查询的操作结果
        assertEquals(1, n);
    }

    @Test
    @Order(6)
    void selectByDynamicSql() {
        Student student = Student.builder().hometown("州").build();
        List<Student> students = studentMapper.selectByDynamicSql(student);
        students.forEach(System.out::println);
    }

    @Test
    @Order(9)
    void getStudentManyToOne() {
        Student student = studentMapper.getStudentManyToOne(1001);
        log.info(String.valueOf(student));
    }

    @Test
    @Order(10)
    void getStudent() {
        Student student = studentMapper.getStudent(1001);
        log.info(String.valueOf(student));
    }
}