package study.springboot.security.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

@Component
public class CCObjectPostProcessor implements ObjectPostProcessor<FilterSecurityInterceptor> {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccessDecisionManager accessDecisionManager;
    @Autowired
    private FilterInvocationSecurityMetadataSource metadataSource;

    @Override
    public FilterSecurityInterceptor postProcess(FilterSecurityInterceptor interceptor) {
        interceptor.setAuthenticationManager(authenticationManager);
        interceptor.setAccessDecisionManager(accessDecisionManager);
        interceptor.setSecurityMetadataSource(metadataSource);
        return interceptor;
    }
}
