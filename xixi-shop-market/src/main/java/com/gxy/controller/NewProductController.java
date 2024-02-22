package com.gxy.controller;

import com.github.pagehelper.PageInfo;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.market.HotProducts;
import com.gxy.entity.market.NewProducts;
import com.gxy.service.NewProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: NewProductController
 * @Author GUOXINYV
 * @Date 2024/2/22 19:12
 * @description:
 */
@RestController
@RequestMapping("/api/newProduct")
public class NewProductController {
    @Autowired
    private NewProductsService newProductsService;

    @PostMapping(value = "/addNew",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result addNewProduct(@RequestBody NewProducts newProducts){
        return newProductsService.insertModel(newProducts);
    }

    @PutMapping(value = "/updateNew",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result updateNewProduct(@RequestBody NewProducts newProducts){
        return newProductsService.updateModel(newProducts);
    }

    @DeleteMapping(value = "/deleteNew/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result deleteNewProduct(@PathVariable int id){
        return newProductsService.deleteModelById(id);
    }

    @PostMapping(value = "/getNew",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<NewProducts> getNewProduct(@RequestBody Search search){
        return newProductsService.getModelsBySearch(search);
    }
}
