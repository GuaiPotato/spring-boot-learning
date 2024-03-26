package top.dezckd.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author DEZ
 * @Date 2024/3/26
 * @Description Teacher
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private Integer clazzId;
    private Clazz clazz;
}
