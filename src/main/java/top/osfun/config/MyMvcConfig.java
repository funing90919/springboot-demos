package top.osfun.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.osfun.component.MyLocaleResolver;
import top.osfun.filter.MyFilter;
import top.osfun.listener.MyListener;
import top.osfun.servlet.MyServlet;

import java.util.Arrays;

/**
 * 自定义MVC配置
 * 1、注册mvc三大组件：servlet、Filter、Listener
 * 需要使用ServletRegistrationBean、FilterRegistrationBean、ServletListenerRegistrationBean
 * 2、定制和修改Servlet容器的相关配置；
 *
 * 参考自动注册SpringMVC的前端控制器；DIspatcherServlet； DispatcherServletAutoConfiguration
 *
 * 静态资源存放目录，查看ResourceProperties
 *
 * Created by Jacky on 2019-01-12 14:44
 */
//@EnableWebMvc 使用后自定义实现将全面接管SpringMVC，默认的自动配置失效，类似于自己整合Spring与SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 发送/hello请求映射到hello页面
        registry.addViewController("/hello").setViewName("hello");
    }

    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(new MyServlet(), "/myServlet");
        // 设置参数
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<MyListener> registrationBean =
                new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }

    // 将这个定制Servlet容器加入到Spring容器中
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            // 定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(80);
            }
        };
    }

    @Bean
    public LocaleResolver myLocaleResolver() {
        return new MyLocaleResolver();
    }
}
