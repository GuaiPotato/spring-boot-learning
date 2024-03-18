package top.dezckd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DEZ
 * @DATE 2024/3/18
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.dezckd.mapper"})
public class DataBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataBaseApplication.class, args);
    }
}
