package top.dezckd.boot.files.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import top.dezckd.boot.files.enums.ErrorCode;

/**
 * @Author DEZ
 * @Date 2024/4/15
 * @Description ApiResponse
 */
@Getter
@Setter
public class RestResponse<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> RestResponse<T> ok(T data) {
        RestResponse<T> rs = new RestResponse<>();
        rs.setData(data);
        rs.setCode(200);
        rs.setMsg("Success");
        return rs;
    }

    public static <T> RestResponse<T> ok() {
        RestResponse<T> rs = new RestResponse<>();
        rs.setCode(200);
        rs.setMsg("Success");
        return rs;
    }

    public static <T> RestResponse<T> error(ErrorCode errorCode) {
        RestResponse<T> rs = new RestResponse<>();
        rs.setCode(errorCode.getCode());
        rs.setMsg(errorCode.getMsg());
        return rs;
    }

    public static <T> RestResponse<T> error(String msg) {
        RestResponse<T> rs = new RestResponse<>();
        rs.setMsg(msg);
        return rs;
    }

    public static <T> RestResponse<T> error(int code, String msg) {
        RestResponse<T> rs = new RestResponse<>();
        rs.setCode(code);
        rs.setMsg(msg);
        return rs;
    }

    public static <T> RestResponse<T> error() {
        RestResponse<T> rs = new RestResponse<>();
        rs.setMsg(ErrorCode.INTERNAL_SERVICE_ERROR.getMsg());
        return rs;
    }

}
