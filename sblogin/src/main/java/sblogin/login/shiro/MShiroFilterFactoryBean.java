package sblogin.login.shiro;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.session.Session;

import org.apache.shiro.subject.Subject;

import sblogin.model.UserInfo;

/**
 * @author cyb
 * @date: 2018/3/30 16:38
 * Description:
 */
public class MShiroFilterFactoryBean extends CasFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token,
                                     Subject subject, ServletRequest request, ServletResponse response) throws Exception {

        Session session = subject.getSession();

        if (session != null) {
            String username = (String) token.getPrincipal();
            try {
                UserInfo user = new UserInfo(username);
                if (user != null) {
                    session.setAttribute("USER_INFO", user);
                } else {
                    subject.logout();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onLoginSuccess(token, subject, request, response);
    }

}
