package top.dezckd.springbootmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dezckd.springbootmp.entity.UserDO;
import top.dezckd.springbootmp.mapper.UserMapper;
import top.dezckd.springbootmp.service.UserService;

/**
 * @Author DEZ
 * @Date 2024/4/1
 * @Description UserServiceImpl
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
}
