package com.gxy.controller;

import com.github.pagehelper.PageInfo;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.backed.ProductTypes;
import com.gxy.service.ProductTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: ProductTypesController
 * @Author GUOXINYV
 * @Date 2024/2/19 19:07
 * @description:
 */
@RestController
@RequestMapping("/api/productTypes")
public class ProductTypesController {
    @Autowired
    private ProductTypesService productTypesService;

    @PostMapping("/addType")
    public Result addProductType(@RequestBody ProductTypes productTypes){
        return productTypesService.insertModel(productTypes);
    }

    @PostMapping("/getTypes")
    public PageInfo<ProductTypes> getTypesBypage(@RequestBody Search search){
        return productTypesService.getModelsBySearch(search);
    }

    @PutMapping("/updateType")
    public Result updateType(@RequestBody ProductTypes productTypes){
        return productTypesService.updateModel(productTypes);
    }

    @DeleteMapping("/deleteType/{id}")
    public Result deleteType(@PathVariable int id){
        return productTypesService.deleteModelById(id);
    }

}
