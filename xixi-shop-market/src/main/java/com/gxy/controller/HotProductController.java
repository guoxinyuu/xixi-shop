package com.gxy.controller;

import com.github.pagehelper.PageInfo;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.market.HotProducts;
import com.gxy.service.HotProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: HotProductController
 * @Author GUOXINYV
 * @Date 2024/2/22 17:20
 * @description:
 */
@RestController
@RequestMapping("/api/hotProduct")
public class HotProductController {
    @Autowired
    private HotProductService hotProductService;

    @PostMapping(value = "/addHot",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result addHotProduct(@RequestBody HotProducts hotProducts){
        return hotProductService.insertModel(hotProducts);
    }

    @PutMapping(value = "/updateHot",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result updateHotProduct(@RequestBody HotProducts hotProducts){
        return hotProductService.updateModel(hotProducts);
    }

    @DeleteMapping(value = "/deleteHot/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result deleteHotProduct(@PathVariable int id){
        return hotProductService.deleteModelById(id);
    }

    @PostMapping(value = "/getHot",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<HotProducts> getHotProduct(@RequestBody Search search){
        return hotProductService.getModelsBySearch(search);
    }

}
