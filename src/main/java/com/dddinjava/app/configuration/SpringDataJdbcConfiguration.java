package com.dddinjava.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;

/**
 * @author zhaoxin
 */
@Configuration
@EnableJdbcRepositories(basePackages = "com.dddinjava.app.*.repo")
@Import(MyBatisJdbcConfiguration.class)
public class SpringDataJdbcConfiguration {

}
