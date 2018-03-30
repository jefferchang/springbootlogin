package sblogin.login.shiro;

import static sblogin.login.shiro.ShiroCasConfiguration.casLoginUrl;

import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * @author cyb
 * @date: 2018/3/30 16:54
 * Description:
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        Session session = subject.getSession(true);
        boolean isPermitted = false;

        //
        if (session.getAttribute("USER_INFO") == null) {
            isPermitted = false;
        }
        return isPermitted;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {


        Subject subject = getSubject(request, response);

        Session session = subject.getSession(true);


        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (subject.getPrincipal() == null || session.getAttribute("USER_INFO") == null) {

            httpServletResponse.sendRedirect(ShiroCasConfiguration.loginUrl);
            //页面跳转

        }
        return false;

    }
}
