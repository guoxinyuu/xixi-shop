package com.gxy.entity.common.vo;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.Data;

@Data
public class Search {
    private int currentPage;
    private int pageSize;
    private  String sort;
    private String direction;
    private String keyword;

    public void initSearch() {
        if (this == null) {
            return;
        }
        this.currentPage = this.currentPage == 0 ? 1 : this.currentPage;
        this.pageSize = this.pageSize == 0 ? 5 :this.pageSize;
        this.sort = StringUtils.isBlank(this.sort) ? "id" : this.sort;
        this.direction = StringUtils.isBlank(this.direction) ? "desc" : this.direction;
    }

}
