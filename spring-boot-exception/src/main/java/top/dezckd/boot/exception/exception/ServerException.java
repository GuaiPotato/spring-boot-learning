package top.dezckd.boot.exception.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import top.dezckd.boot.exception.enums.ErrorCode;

/**
 * @Author DEZ
 * @Date 2024/4/8
 * @Description ServerException
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
public class ServerException extends RuntimeException{
    private final int code;
    private final String msg;

    public ServerException(String msg) {
        this.code = ErrorCode.INTERNAL_SERVICE_ERROR.getCode();
        this.msg = msg;
    }

    public ServerException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
}
