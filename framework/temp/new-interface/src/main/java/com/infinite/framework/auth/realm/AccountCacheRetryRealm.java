package com.infinite.framework.auth.realm;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础认证服务
 *
 * @author hx on 16-6-16.
 * @since 1.0
 */
public class AccountCacheRetryRealm extends AuthorizingRealm {

    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 第一步从token中取出用户发送过来的身份信息
        String username = (String) token.getPrincipal();
        if (StringUtils.isEmpty(username)) {
            throw new UnknownAccountException();
        }
        //TODO 从数据库查找用户信息
        return new SimpleAuthenticationInfo(username, username.getBytes(), this.getName());
    }

    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //从principals获取主身份信息
        //将getPrimaryPrincipal()返回的值强制转换为真实身份信息【在上边的doGetAuthenticationInfo()认证通过填充到SimpleAuthenticationInfo中的身份信息】
        String userCode = (String) principals.getPrimaryPrincipal();

        //根据身份信息获取权限信息
        //先链接数据库。。。
        //模拟从数据库获取数据
        List<String> permissions = new ArrayList<String>();
        permissions.add("user:create");//用户的创建权限
        permissions.add("user:update");//用户的修改
        permissions.add("item:add");//商品的添加权限
        //....等等权限

        //查到权限数据，返回
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将List里面的权限填充进去
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

}