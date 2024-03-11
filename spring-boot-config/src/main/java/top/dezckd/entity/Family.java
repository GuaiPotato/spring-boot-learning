package top.dezckd.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author DEZ
 * @DATE 2024/3/11
 */
@Data
@Component
@Validated
@ConfigurationProperties(prefix = "family")
@PropertySource(value={"classpath:family.properties"})
public class Family {
//    @Value("${family-name}")
    private String familyName;

//    @Value("${father}")
    @Length(min = 1, max = 20, message = "名称非法")
    private String father;

//    @Value("${mother}")
    private String mother;

//    @Value("${child}")
    private String child;

    @Value("${family.years}")
    @Range(min = 3, message = "家庭年限至少30年以上")
    private Integer years;
}


