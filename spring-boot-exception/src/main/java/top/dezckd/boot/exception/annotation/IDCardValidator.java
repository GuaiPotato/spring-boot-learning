package top.dezckd.boot.exception.annotation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;
import java.util.regex.Pattern;

/**
 * @Author DEZ
 * @Date 2024/4/8
 * @Description IDcardValidator
 */
public class IDCardValidator implements ConstraintValidator<IDCard, String> {

    // 身份证号正则表达式
    private static final String REGEX_PHONE = "\\d{17}[\\dxX]";
    @Override
    public void initialize(IDCard constraintAnnotation) {
    }

    @Override
    public boolean isValid(String val, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(val)) {
            return true;
        }
        return Pattern.matches(REGEX_PHONE, val);
    }
}
