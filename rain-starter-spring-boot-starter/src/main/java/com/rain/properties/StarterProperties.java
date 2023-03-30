package com.rain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *  属性实体类：从配置中获取属性值
 * @author Rain
 */
@Data
@Component
@ConfigurationProperties(prefix = "rain.starter")
public class StarterProperties {

    private String rainProperty;

}
