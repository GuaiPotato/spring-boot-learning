package top.dezckd.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author DEZ
 * @DATE 2024/3/11
 */
@Data
@Component
@ConfigurationProperties(prefix = "employee")
@PropertySource(value = {"classpath:employee.properties"})
public class Employee {

    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;

    @Value("#{'${employee.names}'.split(',')[0]}")
    private String firstEmployeeNames;

    @Value("#{'${employee.ages}'}")
    private Map<String, Integer> employeeAges;

    @Value("#{'${employee.age}'.split(',')}")
    private Integer firstAge;

    @Value("#{systemEnvironment['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['user.home']}")
    private String userHome;
}
