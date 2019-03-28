package com.lvlivejp.shirodemo.mapper;

import com.lvlivejp.shirodemo.model.TPermission;
import com.lvlivejp.shirodemo.model.TRolePermission;

import java.util.List;

/**
 * 通用 Mapper 代码生成器
 *
 * @author mapper-generator
 */
public interface TRolePermissionDao extends tk.mybatis.mapper.common.Mapper<TRolePermission> {

    List<TPermission> getPerNameByUserName(String username);
}




