package com.lvlivejp.shirodemo.service.impl;

import com.lvlivejp.shirodemo.mapper.TProductDao;
import com.lvlivejp.shirodemo.model.TProduct;
import com.lvlivejp.shirodemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    TProductDao tProductDao;

    @Override
    public TProduct update(TProduct tProduct){
        tProductDao.updateByPrimaryKey(tProduct);
        return tProduct;
    }
}
