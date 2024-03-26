package top.dezckd.mapper;

import top.dezckd.entity.Course;

import java.util.List;

/**
 * @Author DEZ
 * @Date 2024/3/26
 * @Description CourseMapper
 */
public interface CourseMapper {
    /**
     * 查询所有课程（关联查询出每门课程的选课学生）
     * @return List<Course>
     */
    List<Course> selectAll();
}
