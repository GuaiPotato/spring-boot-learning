package top.dezckd.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



/**
 * @author DEZ
 * @DATE 2024/2/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reader implements Serializable {

    private String name;

    private Integer age;
}
