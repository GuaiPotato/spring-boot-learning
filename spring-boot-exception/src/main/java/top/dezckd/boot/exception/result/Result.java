package top.dezckd.boot.exception.result;

import lombok.Getter;
import lombok.Setter;
import top.dezckd.boot.exception.enums.ErrorCode;

/**
 * @Author DEZ
 * @Date 2024/4/8
 * @Description Result
 */
@Getter
@Setter
public class Result<T> {
    private int code = 0;
    private  String msg = "success";
    private T data;

    public static <T> Result<T> ok(T data) {
        Result<T> rs = new Result<>();
        rs.setData(data);
        return rs;
    }
    public static <T> Result<T> ok() {
        return new Result<>();
    }
    public static <T> Result<T> error(String msg) {
        Result<T> rs = new Result<>();
        rs.setMsg(msg);
        return rs;
    }
    public static <T> Result<T> error(int code, String msg) {
        Result<T> rs = new Result<>();
        rs.setCode(code);
        rs.setMsg(msg);
        return rs;
    }

    public static <T> Result<T> error() {
        Result<T> rs = new Result<>();
        rs.setMsg(ErrorCode.INTERNAL_SERVICE_ERROR.getMsg());
        return rs;
    }

}
