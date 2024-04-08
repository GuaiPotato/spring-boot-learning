package top.dezckd.boot.exception.annotation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @Author DEZ
 * @Date 2024/4/8
 * @Description PhoneValidator
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    // 手机号正则表达式
    private static final String REGEX_PHONE = "1[3456789]\\d{9}";

    @Override
    public void initialize(Phone phone) {
    }

    @Override
    public boolean isValid(String val, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(val)) {
            return true;
        }
        return Pattern.matches(REGEX_PHONE, val);
    }
}
