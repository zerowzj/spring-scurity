package study.springsecurity.auth.details;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("加载用户[{}]的信息", username);
        if (!"wzj".equalsIgnoreCase(username)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        UserDetails userDetails = new CustomUserDetails("wzj", "{noop}123");
        return userDetails;
    }
}
