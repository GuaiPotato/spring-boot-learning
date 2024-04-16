package top.dezckd.boot.files.entity.vo;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

/**
 * @Author DEZ
 * @Date 2024/4/16
 * @Description LoginInfo
 */
@Data
@Builder
@Setter
public class LoginInfo {
    private String username;
    private String token;
}
