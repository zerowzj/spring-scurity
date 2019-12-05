package study.springsecurity.auth.access;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class SecurityMetadataSourceCfg {

    private List<String> pathLt = Lists.newArrayList("/demo1", "/demo2", "/demo3");

    @Bean
    public FilterInvocationSecurityMetadataSource securityMetadataSource() {
        FilterInvocationSecurityMetadataSource metadataSource = new DefaultFilterInvocationSecurityMetadataSource(getRequestMap());
        return metadataSource;
    }

    private LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> getRequestMap() {
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<>();
        for (String path : pathLt) {
            AntPathRequestMatcher matcher = new AntPathRequestMatcher(path + "*");
            List<ConfigAttribute> configAttrLt = Lists.newArrayList(new SecurityConfig(path));
            requestMap.put(matcher, configAttrLt);
        }
        return requestMap;
    }
}
