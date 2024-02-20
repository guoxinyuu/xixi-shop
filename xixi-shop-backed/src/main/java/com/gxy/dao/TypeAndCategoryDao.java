package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.backed.PtPtc;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title: TypeAndCategoryDao
 * @Author GUOXINYV
 * @Date 2024/2/19 19:58
 * @description:
 */
@Mapper
@Repository
public interface TypeAndCategoryDao extends BaseMapper<PtPtc> {
    @Select("select * from pt_ptc where pt_id=#{ptId}")
    List<PtPtc> getPtPtcById(int ptId);

    @Delete("delete from pt_ptc where pt_id=#{ptId}")
    int deletePtPtc(int ptId);
}
