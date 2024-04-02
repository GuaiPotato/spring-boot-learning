package top.dezckd.springbootmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.dezckd.springbootmp.entity.UserDO;

/**
 * @Author DEZ
 * @Date 2024/4/1
 * @Description UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
