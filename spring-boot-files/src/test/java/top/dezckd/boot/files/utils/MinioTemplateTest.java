package top.dezckd.boot.files.utils;

import io.minio.ObjectWriteResponse;
import io.minio.errors.*;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author DEZ
 * @Date 2024/4/15
 * @Description MinioTemplateTest
 */
@SpringBootTest
class MinioTemplateTest {

    @Resource
    private MinioTemplate minioTemplate;

    @Test
    void bucketExists() throws Exception {
        boolean flag = minioTemplate.bucketExists("dezckd");
        System.out.println(flag);
    }

    @Test
    void makeBucket() throws Exception {
        minioTemplate.makeBucket("dezckd");
    }

    @Test
    void putObject() throws Exception {
        File file = new File("D:\\Media\\Sticker\\EveOneCat\\twitter_Everyday One Cat(@motions_cat)_20200727-012200_1287558825105448961_gif.gif");

        ObjectWriteResponse owr = minioTemplate.putObject("dezckd", "img/" + UUID.randomUUID() + ".gif", new FileInputStream(file));
        System.out.println(minioTemplate.getEndPoint() + "/" + owr.object());
    }
}