package com.xkcoding.properties.controller;

import cn.hutool.core.lang.Dict;
import com.xkcoding.properties.property.ApplicationProperty;
import com.xkcoding.properties.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * <p>
 * springboot-静态注入变量
 * 1、set() 方法注入
 * 2、@PostConstruct 注解注入
 * </p>
 *
 * @author zhuhui
 * @date Created in 2021-05-30 14:45
 */
@RestController
public class StaticPropertyController {

    /**
     * 注入静态变量
     */
    private static ApplicationProperty staticApp;
    private static DeveloperProperty staticDev;

    /**
     * @PostConstruct 注解注入
     */
    @Autowired
    private  ApplicationProperty applicationProperty;

    @PostConstruct
    public void init() {
        StaticPropertyController.staticApp = applicationProperty;
        // 这里也可以直接从Spring容器里获取...
    }

    /**
     * set 方法注入静态变量
     */
    @Autowired
    public void setStaticDeveloperProperty(DeveloperProperty developerProperty) {
        StaticPropertyController.staticDev = developerProperty;
    }


    @GetMapping("/staticProperty")
    public Dict index() {
        return Dict.create().set("applicationProperty", staticApp).set("developerProperty", staticDev);
    }
}
