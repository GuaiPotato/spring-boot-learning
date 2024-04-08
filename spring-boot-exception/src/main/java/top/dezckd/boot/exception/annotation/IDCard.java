package top.dezckd.boot.exception.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author DEZ
 * @Date 2024/4/8
 * @Description IDcard
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IDCardValidator.class)
public @interface IDCard {
    String message() default "非法身份证号";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
