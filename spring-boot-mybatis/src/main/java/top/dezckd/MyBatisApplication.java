package top.dezckd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author DEZ
 * @Date 2024/3/25
 * @Description MyBatisApplication
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.dezckd.mapper"})
@EnableTransactionManagement
public class MyBatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class, args);
    }
}
