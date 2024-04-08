package top.dezckd.boot.exception.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dezckd.boot.exception.entity.User;
import top.dezckd.boot.exception.result.Result;

/**
 * @Author DEZ
 * @Date 2024/4/8
 * @Description UserController
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @PostMapping("/user/add")
    public Result<?> addUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        // 校验未通过
        if(bindingResult.hasErrors()) {
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return Result.ok(user);
    }
}
