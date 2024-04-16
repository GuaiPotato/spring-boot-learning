package top.dezckd.boot.files.utils;

import io.minio.*;
import io.minio.errors.*;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.springframework.cglib.core.CollectionUtils.bucket;

/**
 * @Author DEZ
 * @Date 2024/4/15
 * @Description MinioTemplate
 */
@Component
@Configuration
@Getter
public class MinioTemplate {

    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    private MinioClient client;

    @PostConstruct
    public void init() {
        client = MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    /**
     * 判断是否存在
     *
     * @param bucketName 数据桶名
     * @return 存在为 true，否则为 false
     */
    public boolean bucketExists(String bucketName) throws Exception {
        return client.bucketExists(BucketExistsArgs.builder()
                .bucket(bucketName)
                .build());
    }

    /**
     * 根据数据桶名创建数据桶
     *
     * @param bucketName 数据桶名
     * @throws Exception 全部异常简单处理
     */
    public void makeBucket(String bucketName) throws Exception {
        boolean flag = bucketExists(bucketName);
        if (!flag) {
            client.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        }
    }

    /**
     * 向指定数据桶上传文件
     * @param bucketName  数据桶名
     * @param objectName  对象名
     * @param inputStream 数据字节流
     * @return 返回写入对象
     */
    public ObjectWriteResponse putObject(String bucketName, String objectName, InputStream inputStream) throws Exception {
        return client.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(inputStream, -1, 1048784784)
                .build());
    }
}
