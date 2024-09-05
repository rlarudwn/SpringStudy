package com.sist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// 프레임워크는 기본 틀에 맞게 소스 코딩
@Configuration
@ComponentScan(basePackages = {"com.sist.*"})
public class MusicConfig {

}
