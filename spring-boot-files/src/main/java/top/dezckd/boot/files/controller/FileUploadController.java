package top.dezckd.boot.files.controller;

import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.errors.*;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.dezckd.boot.files.utils.MinioTemplate;
import top.dezckd.boot.files.utils.OssTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author DEZ
 * @Date 2024/4/15
 * @Description FileUploadController
 */
@RestController
@RequestMapping(value = "/file")
public class FileUploadController {

    @Resource
    private MinioTemplate minioTemplate;

    @Resource
    private OssTemplate ossTemplate;

    @Value("${file.upload-path}")
    private String uploadPath;

    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    /**
     * 本地上传
     * @param file 文件对象
     * @param request 请求对象
     * @return 文件上传后所在位置
     */
    @PostMapping("/native")
    public String uploadFile(MultipartFile file, HttpServletRequest request) {
        if(file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        String today = dateFormat.format(new Date());
        // 创建子目录
        File folder = new File(uploadPath + "/" + today);
        if (!folder.exists()) {
            boolean flag = folder.mkdirs();
            System.out.println(flag);
        }
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String suffixName = originalFilename.substring(index);
        System.out.println(suffixName);
        String newFileName = UUID.randomUUID() + suffixName;
        System.out.println(newFileName);
        // 文件上传
        try {
            file.transferTo(new File(folder, newFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 拼接访问地址
        return request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort()
                + "/" + today + "/" + newFileName;
    }

    /**
     * minio 文件上传
     * @param file 文件对象
     * @param request 请求对象
     * @return 文件上传后所在位置
     */
    @PostMapping("/minio")
    public String uploadMinio(MultipartFile file, HttpServletRequest request) {
        int index = file.getOriginalFilename().lastIndexOf(".");
        String suffixName = file.getOriginalFilename().substring(index, file.getOriginalFilename().length());
        String newFileName = UUID.randomUUID() + suffixName;
        String filePath = "img/" + newFileName;

        ObjectWriteResponse owr;
        try {
            owr = minioTemplate.putObject("dezckd", filePath, file.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return minioTemplate.getEndPoint() + "/" + owr.object();
    }

    /**
     * oss 文件上传
     * @param file 文件对象
     * @param request 请求对象
     * @return 文件上传后所在位置
     */
    @PostMapping("/oss")
    public String uploadOss(MultipartFile file, HttpServletRequest request) {
        return ossTemplate.ossUpload(file);
    }

    /**
     * oss 文件下载
     * @param path 文件路径
     * @param request 文件对象
     * @return 下载成功为 true，否则为 false
     */
    public String downloadFile(String path, HttpServletRequest request) {
        // TODO: 完成 阿里云OSS 文件下载
        return null;
    }


}
