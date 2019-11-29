package study.springboot.security.support;

import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebServlet;

@Component
@WebServlet(urlPatterns = "*.jsp", name = "JspServlet")
public class JspServlet extends org.apache.jasper.servlet.JspServlet {

}
