package com.lvlivejp.shirodemo.mapper;

import com.lvlivejp.shirodemo.model.TUserRole;

import java.util.List;

/**
 * 通用 Mapper 代码生成器
 *
 * @author mapper-generator
 */
public interface TUserRoleDao extends tk.mybatis.mapper.common.Mapper<TUserRole> {

    List<String> getRoleNameByUserName(String username);

}




