
package com.gxy.entity.service;

import com.github.pagehelper.PageInfo;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;


/**
 * ModelService
 */
public interface ModelService<T> {

    Result<T> insertModel(T model);

    Result<T> updateModel(T model);

    Result<Object> deleteModelById(int id);

    T getModelById(int id);

    PageInfo<T> getModelsBySearch(Search search);
}
