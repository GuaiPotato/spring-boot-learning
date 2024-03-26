package top.dezckd.mapper;

import org.apache.ibatis.annotations.Param;
import top.dezckd.entity.Student;

import java.util.List;

/**
 * @Author DEZ
 * @Date 2024/3/25
 * @Description StudentMapper
 */
public interface StudentMapper {
    int insert(Student student);

    Student findStudentById(int studentId);

    int updateById(Student student);

    int deleteById(int studentId);

    /**
     * 批量插入学生信息
     * @param students 学生列表
     * @return 影响的行数
     */
    int batchInsert(@Param("students")List<Student> students);

    /**
     * 批量删除
     * @param ids 学生id列表
     * @return 影响的行数
     */
    int batchDelete(@Param("idList")List<Integer> ids);

    /**
     * 批量更新学生信息
     * @param students 学生信息列表
     * @return 影响的行数
     */
    int batchUpdate(@Param("students")List<Student> students);

    /**
     * 动态查询学生信息
     * @param student 要查询的学生的部分信息
     * @return 包含查询信息的学生的集合
     */
    List<Student> selectByDynamicSql(Student student);

    /**
     * 根据学生id查询（关联查询所属班级信息）
     *
     * @param studentId 学生id
     * @return 学生信息
     */
    Student getStudentManyToOne(int studentId);

    /**
     * 根据学生id查询（关联查询出所属班级信息，所选课程信息）
     *
     * @param studentId 学生id
     * @return 学生对象
     */
    Student getStudent(int studentId);
}
