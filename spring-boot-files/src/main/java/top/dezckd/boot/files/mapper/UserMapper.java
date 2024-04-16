package top.dezckd.boot.files.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.dezckd.boot.files.entity.dto.User;

/**
 * @Author DEZ
 * @Date 2024/4/15
 * @Description FileMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
