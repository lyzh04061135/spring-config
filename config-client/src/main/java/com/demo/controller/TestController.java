package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestController {
    @Value("${demo.config.server.name:test}")
    String name;

    @RequestMapping(value = "/test")
    public String test() {
        log.info(String.format("test: %s", name));
        return String.format("test: %s", name);
    }
}
