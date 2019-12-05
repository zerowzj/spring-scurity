package study.springsecurity.auth.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.IOException;

@Component
public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExpiredSessionStrategy.class);

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        LOGGER.info("");
    }
}
