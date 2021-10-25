package com.dddinjava.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaoxin
 */
@MapperScan(basePackages = "com.dddinjava.app.*.mapper")
@SpringBootApplication
public class SpringBootDataJdbcMybatisIntegratedApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDataJdbcMybatisIntegratedApplication.class, args);
  }
}
