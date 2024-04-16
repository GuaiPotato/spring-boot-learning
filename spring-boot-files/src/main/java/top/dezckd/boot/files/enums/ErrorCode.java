package top.dezckd.boot.files.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author DEZ
 * @Date 2024/4/16
 * @Description ErrorCode
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    UNAUTHORIZED(401, "登录失败，请重新登录"),
    FORBIDDEN(403, "没有权限访问该资源"),
    NOT_FOUND(404, "资源未找到"),
    METHOD_NOT_ALLOWED(405, "请求方法不被允许"),
    INTERNAL_SERVICE_ERROR(500, "服务器异常，请稍后再试"),
    BAD_GATEWAY(502, "网关错误"),
    SERVICE_UNAVAILABLE(503, "服务暂不可用，请稍后再试"),
    GATEWAY_TIMEOUT(504, "网关超时"),
    UNKNOWN_ERROR(999, "未知错误");

    private final int code;
    private final String msg;
}
