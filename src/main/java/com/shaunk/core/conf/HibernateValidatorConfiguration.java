package com.shaunk.core.conf;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @Project sheep
 * @Package com.shaunk.core.conf
 * @Name HibernateValidatorConfiguration
 * @Version 1.0
 * @Data: 2019/6/29 2:10 PM
 * @User: shaunk
 * @Description: HibernateValidator
 */
@Configuration
public class HibernateValidatorConfiguration {

    @Bean
    public static Validator validator() {
        return Validation
                .byProvider(HibernateValidator.class)
                .configure()
                //快速返回模式，有一个验证失败立即返回错误信息
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
    }
}
