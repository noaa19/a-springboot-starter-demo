package com.rain.configuration;


import com.rain.properties.StarterProperties;
import com.rain.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 修饰配置类
 * proxyBeanMethods，默认值为true.
 * true时，为Full模式，表示当前组件（这个配置类）交给Spring容器代理，可以解决组件依赖的问题：
 *        调用组件的时候先检查组件是否在容器中存在，如果不存在就创建一个新的，如果存在则直接调用。
 * false时，为lite模式，表示当前组件（这个配置类）不交给Spring容器代理，每次调用组件时，
 *         直接创建，无须检查该组件是否存在于容器中。
 * 二者的使用，取决于是否有组件依赖。
 */
@Configuration(proxyBeanMethods = true)

/**
 * 导入我们自定义的配置类
 */
@EnableConfigurationProperties(StarterProperties.class)

/**
 *  配置生效条件：rain.starter.type=rain,如果属性不存在就略过这个条件，正常加载
 */
@ConditionalOnProperty(prefix="rain.starter",name="type",havingValue = "rain",matchIfMissing = true)

/**
 * 自动配置类
 * @author Rain
 */
public class StarterAutoConfiguration {

    /**
     *  自动注入一个配置实体类
     */
    @Autowired
    StarterProperties starterProperties;

    /**
     * @Bean:只能存在于配置类中，当配置类中的方法存在这个注解时，方法的返回值会被放入IOC容器中
     * @ConditionalOnMissingBean:只有当前容器没有这个bean的时候才会创建bean,保证单例
     * @return StarterService
     */
    @Bean
    @ConditionalOnMissingBean
    public StarterService createStarterService(){
        StarterService starterService = new StarterService();
        starterService.setRainName(starterProperties.getRainProperty());
        return starterService;
    }

}
