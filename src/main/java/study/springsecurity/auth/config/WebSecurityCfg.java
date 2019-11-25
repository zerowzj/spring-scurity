package study.springsecurity.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Order(1)
public class WebSecurityCfg extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin() //表单登录
//                 .loginPage("/login.html") //设置登录跳转页面controller、也可以直接跳转页面
//                .loginProcessingUrl("/login") //自定义登录页面的表单提交地址
//                .and()
//                .authorizeRequests()
//                .antMatchers("/login")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf()
//                .disable();

//        http.formLogin()
//                .and()
//                .authorizeRequests().antMatchers("/oauth/**").permitAll()
//                .anyRequest()
//                .authenticated();

        http.requestMatchers()
                .antMatchers("/login", "/oauth/authorize")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll();

//        http.authorizeRequests()
//                .antMatchers("/oauth/**", "/login/**", "/logout")
//                .permitAll()
//                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .and()
//                .logout().logoutSuccessUrl("/");
    }

    /**
     * 认证管理器
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    /**
     * 用户信息服务
     */
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withUsername("wzj")
//                .password("{noop}123")
//                .roles("USER")
//                .build();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(userDetails);
//        return manager;
//    }


    /**
     * 定义用户名 密码和角色
     * 1.
     * 2.
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("wang")
//                .password("{noop}123")
//                .authorities("USER");
//    }
}
