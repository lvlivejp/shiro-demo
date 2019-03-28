package com.lvlivejp.shirodemo.controller;

import com.lvlivejp.shirodemo.model.TPermission;
import com.lvlivejp.shirodemo.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ShiroController {

    @Autowired
    PermissionService permissionService;


    @RequestMapping("/shiro/update")
    public void updateShiro(TPermission tPermission){

        permissionService.insert(tPermission);



    }
}
