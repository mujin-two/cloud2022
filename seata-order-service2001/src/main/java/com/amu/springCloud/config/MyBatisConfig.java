package com.amu.springCloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.amu.springCloud.dao"})
public class MyBatisConfig {
}
