package top.dezckd.boot.files.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author DEZ
 * @Date 2024/4/15
 * @Description OssConfig
 */
@Configuration
@PropertySource("classpath:aliyun-oss.properties")
@ConfigurationProperties(prefix = "aliyun-oss")
@Data
public class OssConfig {
    private String endpoint;
    private String bucket;
    private String dir;
    private String host;
    @Value("${aliyun-oss.accesskey}")
    private String ak;
    @Value("${aliyun-oss.secretkey}")
    private String secret;
}
