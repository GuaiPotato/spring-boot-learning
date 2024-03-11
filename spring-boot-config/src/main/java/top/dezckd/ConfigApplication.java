package top.dezckd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DEZ
 * @DATE 2024/3/11
 */
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConfigApplication.class);
        app.run(args);
    }
}
