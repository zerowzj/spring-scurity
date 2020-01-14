package study.springboot.security.auth.details;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (Strings.isNullOrEmpty(username)) {
            throw new UsernameNotFoundException("用户名不能为空");
        }
        log.info("加载用户[{}]的信息", username);
        if (!"wzj".equalsIgnoreCase(username)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        UserDetails userDetails = new CustomUserDetails("wzj", "{noop}123",getGrantedLt());
        return userDetails;
    }

    private List<SimpleGrantedAuthority> getGrantedLt() {
        List<SimpleGrantedAuthority> grantedLt = Lists.newArrayList();
        grantedLt.add(new SimpleGrantedAuthority("/demo1"));
        return grantedLt;
    }
}
