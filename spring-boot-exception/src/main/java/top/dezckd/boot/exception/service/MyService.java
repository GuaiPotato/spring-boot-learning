package top.dezckd.boot.exception.service;

import org.springframework.stereotype.Service;
import top.dezckd.boot.exception.enums.ErrorCode;
import top.dezckd.boot.exception.exception.ServerException;

/**
 * @Author DEZ
 * @Date 2024/4/8
 * @Description MyService
 */
@Service
public class MyService {

    /**
     * 模拟未登录异常
     */
    public void unAuthorizedError() {
        throw new ServerException(ErrorCode.UNAUTHORIZED);
    }

    /**
     * 模拟系统异常
     */
    public void serverError() {
        throw new ServerException(ErrorCode.INTERNAL_SERVICE_ERROR);
    }
}
