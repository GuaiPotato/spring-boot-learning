package top.dezckd.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class QuickStartApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(QuickStartApplication.class);
        Environment env = app.run(args).getEnvironment();
        String port = env.getProperty("server.port") == null ? "8080" : env.getProperty("server.port");
        log.info("启动成功 http://localhost:{}", port);
    }

}
