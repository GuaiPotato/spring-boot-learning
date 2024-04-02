package top.dezckd.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author DEZ
 * @Date 2024/4/1
 * @Description LogTest
 */
@Slf4j
@RestController
public class LogController {

    @GetMapping("/log")
    public void testLog() {
        log.debug("debug 日志");
    }
}
