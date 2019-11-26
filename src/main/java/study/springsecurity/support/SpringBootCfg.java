package study.springsecurity.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "study.springsecurity",
        exclude = {SecurityAutoConfiguration.class})
public class SpringBootCfg {
}
