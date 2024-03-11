package top.dezckd.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DEZ
 * @DATE 2024/3/11
 */
@SpringBootTest
class EmployeeTest {
    @Resource
    private Employee employee;

    @Test
    public void testEmployee(){
//        List<String> employeeNames = employee.getEmployeeNames();
//        employeeNames.forEach(System.out::println);

        Map<String, Integer> employeeAges = employee.getEmployeeAges();
        System.out.println(employeeAges);
    }
}