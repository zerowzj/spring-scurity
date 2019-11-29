package study.springboot.security.auth.access;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class AccessDecisionCfg {

    @Autowired
    private AccessDecisionVoter voter;

    @Bean
    public AccessDecisionManager decisionManager() {
        AffirmativeBased manager = new AffirmativeBased(Lists.newArrayList(voter));
        return manager;
    }

    @Bean
    public AccessDecisionVoter decisionVoter() {
        RoleVoter voter = new RoleVoter();
        voter.setRolePrefix("");
        return voter;
    }

    @Bean
    public FilterInvocationSecurityMetadataSource securityMetadataSource() {
        FilterInvocationSecurityMetadataSource metadataSource = new DefaultFilterInvocationSecurityMetadataSource(getRequestMap());
        return metadataSource;
    }

    public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> getRequestMap() {
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> metadataSource = new LinkedHashMap<>();
        List<ConfigAttribute> configAttrLt = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            String pfPath = "/a-" + (i + 1);
            AntPathRequestMatcher matcher = new AntPathRequestMatcher(pfPath + "*");
            configAttrLt.add(new SecurityConfig(pfPath));
            metadataSource.put(matcher, configAttrLt);
        }
        return metadataSource;
    }
}
