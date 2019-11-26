package study.springsecurity.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
//@EnableWebSecurity
public class WebSecurityCfg extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;

    /**
     * （★）HTTP请求安全处理
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //登录
        http.formLogin() //需要用户登录时，转到的登录页面
                .loginPage("/login.html") //登录跳转页面controller或页面
                //.usernameParameter("username")
                //.passwordParameter("password")
                .loginProcessingUrl("/login") //登录表单提交地址
                .defaultSuccessUrl("/main.html", true) //
                //.successForwardUrl("/") //
                //.successHandler(loginSuccessHandler) //
                .failureUrl("/login.html?error") //登录失败url，前端可通过url中是否有error来提供友好的用户登入提示
        //.failureForwardUrl()
        //.failureHandler(null)
        ;
        //授权
        http.authorizeRequests()
                .antMatchers("/login**")
                .permitAll()
                .anyRequest()  //任何请求
                .authenticated() //需要身份认证
        ;
        //注销
        http.logout()
                .logoutUrl("/logout")  //
                .logoutSuccessUrl("/login.html/logout") //
                .logoutSuccessHandler(null)
        ;
        //认证及授权
        http.exceptionHandling()
                .accessDeniedPage("/403")
        ;
        //其他
        http.csrf().disable()
        ;

//        http.httpBasic()
//                .and()
//                //登录过滤器UsernamePasswordAuthenticationFilter默认登录的url是"/login"，在这能改
//                .formLogin()
//                .loginPage("/index1111.html")
//                .loginProcessingUrl("/beacon/user/login")      //默认登录的方法
//                .successHandler(myAuthenticationSuccessHandler)//自定义的认证后处理器
//                .failureHandler(myAuthenticationFailureHandler) //登录失败后的处理
//                .and()
//                .authorizeRequests() //下面是授权的配置
//                .antMatchers("/beacon/user/login",
//                        securityProperties.getBrowser().getLoginPage(),//放过登录页不过滤，否则报错
//                        "/beacon/user/valicode",
//                        "/beacon/user/getMaxVersion",
//                        "/beacon/user/getMyData"
//                ).permitAll()
//                .anyRequest()        //任何请求
//                .authenticated()    //都需要身份认证
//                .and()
//                .csrf()
//                .disable() //关闭csrf防护
//        ;
    }

    /**
     * （★）WEB安全
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/static/**",
                        "/asset-manifest.json",
                        "/favicon.ico",
                        "/manifest.json",
                        "/service-worker.js");
    }

    /**
     * （★）身份验证管理器
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
