package com.example.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @program: code
 * @description:
 * @author: ThinkGem
 * @create: 2020-04-25 23:13
 **/
public class UserRealm extends AuthorizingRealm{


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.print("执行授权编辑");
        return null;
    }

    /**
     * 身份认证/登录，验证用户是不是拥有相应的身份；
     * @param token
     * @return
     * @throws AuthenticationException
     *
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.print("执行身份认证编辑");
        return null;
    }
}
