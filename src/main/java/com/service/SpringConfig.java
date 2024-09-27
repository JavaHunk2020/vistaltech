package com.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/////<context:component-scan base-package="com.service" />
@Configuration
@ComponentScan({"com.p2","com.p1","com.pizza"})
public class SpringConfig {
  
}
