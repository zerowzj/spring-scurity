package study.springsecurity.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityCfg extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() //定义当需要用户登录时候，转到的登录页面
                .loginPage("login.html")     //设置登录跳转页面controller，也可以直接跳转页面
                .loginProcessingUrl("/login") //自定义登录页面的表单提交地址
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .authorizeRequests()
                .antMatchers("/", "/login.html")
                .permitAll() //
                .anyRequest()
                .authenticated()                //默认其它的请求都需要认证，这里一定要添加
                .and()
                .csrf().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
