package study.springsecurity.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication(scanBasePackages = "study.springsecurity.auth.server")
public class SpringBootCfg {
}
