package study.springboot.security.support;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "*.jsp", name = "JspServlet")
public class JspServlet extends org.apache.jasper.servlet.JspServlet {

}
