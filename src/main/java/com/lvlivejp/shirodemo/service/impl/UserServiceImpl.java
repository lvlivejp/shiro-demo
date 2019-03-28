package com.lvlivejp.shirodemo.service.impl;

import com.lvlivejp.shirodemo.base.BaseResult;
import com.lvlivejp.shirodemo.mapper.TUserDao;
import com.lvlivejp.shirodemo.model.TUser;
import com.lvlivejp.shirodemo.service.UserService;
import com.lvlivejp.shirodemo.utils.BaseResultUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserDao tUserDao;

    @Autowired
    private HashedCredentialsMatcher hashedCredentialsMatcher;

    @Override
    public BaseResult save(TUser tUser) {
        SimpleHash simpleHash = new SimpleHash(hashedCredentialsMatcher.getHashAlgorithmName(), tUser.getPassword(), tUser.getUserName(), hashedCredentialsMatcher.getHashIterations());
        // 记得注册的时候把密码加密一下
        tUser.setPassword(simpleHash.toString());
        tUserDao.insert(tUser);
        return BaseResultUtils.success(tUser);
    }
}
