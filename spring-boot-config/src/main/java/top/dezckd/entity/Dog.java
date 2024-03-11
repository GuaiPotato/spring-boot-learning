package top.dezckd.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author DEZ
 * @DATE 2024/3/11
 */
@Data
@Component
public class Dog {

    @Value("${person.dog.name}")
    private String name;

    @Value("${person.dog.age}")
    private Integer age;
}
