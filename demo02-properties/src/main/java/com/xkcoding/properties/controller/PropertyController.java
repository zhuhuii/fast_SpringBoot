package com.xkcoding.properties.controller;

import cn.hutool.core.lang.Dict;
import com.xkcoding.properties.property.ApplicationProperty;
import com.xkcoding.properties.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-09-29 10:49
 */
@RestController
public class PropertyController {

    /**
     * 创建对象的方法无法获取值，必须使用@Autowired注解。
     */
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/property")
    public Dict index() {
        return Dict.create().set("applicationProperty", applicationProperty).set("developerProperty", developerProperty);
    }
}
