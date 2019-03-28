package com.lvlivejp.shirodemo.service;

import com.lvlivejp.shirodemo.model.TPermission;

import java.util.List;

public interface PermissionService {

    List<TPermission> findAll();

    void insert(TPermission tPermission);
}
