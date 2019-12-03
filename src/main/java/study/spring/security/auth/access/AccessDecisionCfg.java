package study.spring.security.auth.access;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.stereotype.Component;

@Component
public class AccessDecisionCfg {

    @Bean
    public AccessDecisionManager decisionManager(@Autowired AccessDecisionVoter voter) {
        AffirmativeBased manager = new AffirmativeBased(Lists.newArrayList(voter));
        return manager;
    }

    @Bean
    public AccessDecisionVoter decisionVoter() {
        RoleVoter voter = new RoleVoter();
        voter.setRolePrefix("");
        return voter;
    }
}
