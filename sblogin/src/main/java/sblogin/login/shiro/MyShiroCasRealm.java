package sblogin.login.shiro;

import javax.annotation.PostConstruct;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sblogin.model.UserInfo;

/**
 * @author cyb
 * @date: 2018/3/30 16:05
 * Description:
 */
public class MyShiroCasRealm extends CasRealm {
    private static final Logger logger = LoggerFactory.getLogger(MyShiroCasRealm.class);

    @PostConstruct
    public void initProperty() {
        //setDefaultRoles("ROLE_USER");
        setCasServerUrlPrefix(ShiroCasConfiguration.casServerUrlPrefix);
        // 客户端回调地址
        setCasService(ShiroCasConfiguration.shiroServerUrlPrefix + ShiroCasConfiguration.casFilterUrlPattern);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String loginName = (String) super.getAvailablePrincipal(principalCollection);

        /**
         * 实际项目中，这里可以根据实际情况做缓存，
         * 如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
         *
         */
        UserInfo user = new UserInfo(loginName);
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.setRoles(Sets.newHashSet("admin"));
            info.addStringPermissions(Lists.newArrayList("user:list"));
            return info;
        }
        return null;
    }
}
