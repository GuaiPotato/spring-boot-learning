package top.dezckd.boot.files.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.dezckd.boot.files.entity.dto.User;
import top.dezckd.boot.files.mapper.UserMapper;
import top.dezckd.boot.files.service.UserService;
import top.dezckd.boot.files.utils.OssTemplate;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * @Author DEZ
 * @Date 2024/4/15
 * @Description UserImplement
 */
@Service
public class UserImplement extends ServiceImpl<UserMapper, User> implements UserService, Serializable {

    @Resource
    private UserMapper userMapper;

    @Resource
    private OssTemplate ossTemplate;

    /**
     * 创建用户
     *
     * @param user 用户对象
     * @return 创建成功为 true，否则为 false
     */
    public boolean addUser(User user) {
        return userMapper.insert(user) > 0;
    }

    /**
     * 用户登录
     *
     * @param user 用户对象
     * @return 登录成功为 true，否则为 false
     */
    public boolean login(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", user.getUsername());
        qw.eq("password", user.getPassword());
        return userMapper.selectCount(qw) > 0;
    }

    /**
     * 根据 主键 查询用户
     *
     * @param id 用户主键
     * @return 查询成功为 true，否则为 false
     */
    public User getUserById(Serializable id) {
        return userMapper.selectById(id);
    }

    public User getUserByUsername(String username) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = user.getBirthday().format(formatter);
        user.setBirthday(LocalDate.parse(formattedDate));
        return user;
    }

    /**
     * 根据 主键 更新用户
     *
     * @param user 用户对象
     * @return 更新成功为 true，否则为 false
     */
    public boolean updateUser(User user) {
        return userMapper.update(user, new QueryWrapper<User>().eq("username", user.getUsername())) > 0;
    }

    /**
     * 根据 主键 删除用户
     *
     * @param id 用户主键
     * @return 删除成功为 true，否则为 false
     */
    public boolean deleteUserById(Serializable id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateUserAvatarByUsername(User user, MultipartFile file) {
        boolean res = uploadAvatar(user, file);
        if(res) {
            return updateUser(user);
        }

        return false;
    }

    @Override
    public boolean uploadAvatar(User user, MultipartFile file) {
        if (user.getUsername() != null && file != null) {
            User fullUser = getUserByUsername(user.getUsername());
            if (fullUser.getAvatar() != null) {
                ossTemplate.ossDeleteFile(fullUser.getAvatar(), Objects.requireNonNull(file.getOriginalFilename()));
                String res = ossTemplate.ossUpload(file);
                user.setAvatar(res);
                return true;
            }
        }
        return false;
    }
}
