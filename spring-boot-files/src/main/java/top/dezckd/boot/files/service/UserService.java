package top.dezckd.boot.files.service;

import org.springframework.web.multipart.MultipartFile;
import top.dezckd.boot.files.entity.dto.User;

import java.io.Serializable;

/**
 * @Author DEZ
 * @Date 2024/4/15
 * @Description UserService
 */
public interface UserService {
    boolean addUser(User user);
    boolean login(User user);
    User getUserById(Serializable id);
    User getUserByUsername(String username);
    boolean updateUser(User user);
    boolean deleteUserById(Serializable id);
    boolean updateUserAvatarByUsername(User user, MultipartFile file);
}
