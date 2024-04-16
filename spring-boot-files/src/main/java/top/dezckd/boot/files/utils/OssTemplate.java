package top.dezckd.boot.files.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.dezckd.boot.files.config.OssConfig;
import top.dezckd.boot.files.entity.dto.User;
import top.dezckd.boot.files.service.UserService;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author DEZ
 * @Date 2024/4/15
 * @Description OssTemplate
 */
@Component
public class OssTemplate {

    @Resource
    private OssConfig ossConfig;

    /**
     * 初始化 OSS
     */
    public static void init() {
        // TODO: 使用静态方式提前初始化
    }

    /**
     * 上传文件
     * @param file 文件参数
     * @return 上传后的 url
     */
    public String ossUpload(MultipartFile file) {
        String endpoint = ossConfig.getEndpoint();
        String bucket = ossConfig.getBucket();
        String dir = ossConfig.getDir();
        String host = ossConfig.getHost();
        String ak = ossConfig.getAk();
        String secret = ossConfig.getSecret();

        // 创建 OSSClient 实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, ak, secret);
        // 上传文件存放的路径
        String uploadPath = dir + file.getOriginalFilename();
        // 获取文件的字节输入流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 调用 SDK 上传文件
        ossClient.putObject(bucket, uploadPath, inputStream);
        // 关闭 ossClient
        ossClient.shutdown();
        // 返回上传文件的 url
        return host + "/" + uploadPath;
    }

    public void ossDeleteFile(String originPath, String fileName) {
        String endpoint = ossConfig.getEndpoint();
        String bucket = ossConfig.getBucket();
        String dir = ossConfig.getDir();
        String host = ossConfig.getHost();
        String ak = ossConfig.getAk();
        String secret = ossConfig.getSecret();

        // 判断是否与源头像相同
        String newFilePath = host + "/" + dir + "/" + fileName;
        if(originPath.equals(newFilePath)) {
            return;
        }


        OSS ossClient = new OSSClientBuilder().build(endpoint, ak, secret);

        try {
            // 删除文件
            ossClient.deleteObject(bucket, newFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete file from OSS.", e);
        } finally {
            // 关闭OSSClient
            ossClient.shutdown();
        }
    }

}
