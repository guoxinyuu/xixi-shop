package com.gxy.controller;

import com.github.pagehelper.PageInfo;
import com.gxy.entity.backed.ProductTypesCategory;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.dto.ProductTypesCategoryDto;
import com.gxy.service.PTCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: PTCategoryController
 * @Author GUOXINYV
 * @Date 2024/2/20 19:14
 * @description:
 */
@RestController
@RequestMapping("/api/PTCategory")
public class PTCategoryController {
    @Autowired
    private PTCategoryService ptCategoryService;

    @PostMapping("/addPTCategory")
    public Result addPTCategory(@RequestBody ProductTypesCategoryDto model){
        return ptCategoryService.insertModel(model);
    }

    @PutMapping("/updatePTCategory")
    public Result updatePTCategory(@RequestBody ProductTypesCategoryDto model){
        return ptCategoryService.updateModel(model);
    }

    @DeleteMapping("/deletePTCategory/{id}")
    public Result deletePTCategory(@PathVariable int id){
        return ptCategoryService.deleteModelById(id);
    }

    @PostMapping("/getPTCategory")
    public PageInfo<ProductTypesCategoryDto> getPTCategory(@RequestBody Search search){
        return ptCategoryService.getModelsBySearch(search);
    }
}
