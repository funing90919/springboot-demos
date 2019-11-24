package top.os.base.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Jacky on 2019-01-05 15:02.
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        // 开启登录功能，没有权限则跳转登录页
        http.formLogin();
        // 1./login登录页
        // 2.重定向到/login?error表示登录失败
        // 3.更多详细规则

        // 开启自动配置的注销及注销后跳转的页面
        http.logout().logoutSuccessUrl("/");
        // 1.访问/logout
        // 2.重定向到/login?logout
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("funing").password("123456").roles("VIP1", "VIP2")
                .and()
                .withUser("zhouna").password("123456").roles("VIP3");
    }
}
