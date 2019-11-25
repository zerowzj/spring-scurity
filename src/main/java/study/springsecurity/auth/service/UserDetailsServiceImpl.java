package study.springsecurity.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import study.springsecurity.auth.details.CustomUserDetails;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("获取用户[{}]信息", username);
//        if("".equalsIgnoreCase("")){
//            throw new UsernameNotFoundException("用户不存在");
//        }
        UserDetails userDetails = new CustomUserDetails("wzj", "{noop}123");
        return userDetails;
    }
}
