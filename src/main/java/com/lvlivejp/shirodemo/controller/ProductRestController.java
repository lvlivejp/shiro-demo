package com.lvlivejp.shirodemo.controller;

import com.lvlivejp.shirodemo.base.BaseResult;
import com.lvlivejp.shirodemo.model.TProduct;
import com.lvlivejp.shirodemo.service.ProductService;
import com.lvlivejp.shirodemo.utils.BaseResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/product")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @PutMapping("")
    public BaseResult<TProduct> update(TProduct tProduct){
        productService.update(tProduct);
        return BaseResultUtils.success(tProduct);
    }
}
