package study.springboot.security.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import study.springboot.security.auth.filter.WatchDogFilter;

@Configuration
public class WebSecurityCfg extends WebSecurityConfigurerAdapter {

    @Autowired
    private WatchDogFilter watchDogFilter;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler loginFailureHandler;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    /**
     * （★）HTTP请求安全
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //（☆）过滤器
//        http.addFilterBefore(watchDogFilter, UsernamePasswordAuthenticationFilter.class)
//        ;
        //（☆）认证
//        http.httpBasic(); //Basic登录方式
        http.formLogin() //表单登录，需要登录时，转到的登录页面
                .loginPage("/login.html") //登录跳转页面controller或页面
                .loginProcessingUrl("/login") //登录表单提交地址
                .defaultSuccessUrl("/main.html", true) //
                //.successForwardUrl("/") //
                //.successHandler(loginSuccessHandler) //登录成功处理器
                .failureUrl("/login.html?login_failure") //登录失败url，前端可通过url中是否有error来提供友好的用户登入提示
                //.failureForwardUrl()
                .failureHandler(loginFailureHandler) //登录失败处理器
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .isCustomLoginPage()
        ;
        //（☆）授权
        http.authorizeRequests() //请求授权
//                .accessDecisionManager() //
//                .withObjectPostProcessor() //
//                .antMatchers("/login**")
//                .permitAll() //不需要权限认证
                .anyRequest()  //任何请求
                .authenticated() //需要身份认证
        ;
        //（☆）
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .accessDeniedPage("/403")
        ;
        //（☆）注销
        http.logout()
                .logoutUrl("/logout")  //
                .logoutSuccessUrl("/login.html") //
                .logoutSuccessHandler(logoutSuccessHandler)
        ;
        //（☆）会话
        http.sessionManagement()
                .invalidSessionUrl("/login.html?session_invalid")
//                .maximumSessions(1)
//                .maxSessionsPreventsLogin(false) // 当达到最大值时，是否保留已经登录的用户
//                .expiredSessionStrategy(new CustomExpiredSessionStrategy()) // 当达到最大值时，旧用户被踢出后的操作
        ;
        //（☆）其他
        http.csrf().disable() //关闭跨站请求防护
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
                .antMatchers("/static/**");
    }

    /**
     * （★）身份验证管理器
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
