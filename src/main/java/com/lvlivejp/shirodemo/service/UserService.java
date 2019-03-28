package com.lvlivejp.shirodemo.service;

import com.lvlivejp.shirodemo.base.BaseResult;
import com.lvlivejp.shirodemo.model.TUser;

public interface UserService {
    BaseResult save(TUser tUser);
}
