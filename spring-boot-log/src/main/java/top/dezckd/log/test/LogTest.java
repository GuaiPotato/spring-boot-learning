package top.dezckd.log.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author DEZ
 * @Date 2024/4/1
 * @Description LogTest
 */
@Slf4j
public class LogTest {
    // Slf4j 是日志门面
    public static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
//        LOGGER.trace("Trace 日志...");
//        LOGGER.debug("Debug 日志...");
//        LOGGER.info("Info 日志...");
//        LOGGER.warn("Warn 日志...");
//        LOGGER.error("Error 日志...");

//        Logger myLogger = LoggerFactory.getLogger("myLogger");
//        myLogger.info("Hello World");

        log.debug("debug 日志");
    }
}
