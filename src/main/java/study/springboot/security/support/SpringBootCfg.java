package study.springboot.security.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "study.springboot.security")
@SpringBootApplication(scanBasePackages = "study.springboot.security")
public class SpringBootCfg {
}
