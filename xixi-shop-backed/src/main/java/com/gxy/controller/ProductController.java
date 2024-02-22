package com.gxy.controller;

import com.github.pagehelper.PageInfo;
import com.gxy.entity.backed.Managers;
import com.gxy.entity.backed.Product;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: ProductController
 * @Author GUOXINYV
 * @Date 2024/2/21 19:21
 * @description:
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result addProduct(@RequestBody Product product){
        return productService.insertModel(product);
    }

    @PutMapping(value = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result updateProduct(@RequestBody Product product){
        return productService.updateModel(product);
    }

    @DeleteMapping(value = "/deleteProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result deleteProduct(@RequestParam int id){
        return productService.deleteModelById(id);
    }

    @PostMapping(value = "/getProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<Product> getProductByPage(@RequestBody Search search){
        return productService.getModelsBySearch(search);
    }
}
