package com.gxy.entity.backed;

import lombok.Data;

/**
 * @Title: PtPtc
 * @Author GUOXINYV
 * @Date 2024/2/19 19:55
 * @description:
 */
@Data
public class PtPtc {
    private int id;
    private int ptId;
    private int ptcId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPtId() {
        return ptId;
    }

    public void setPtId(int ptId) {
        this.ptId = ptId;
    }

    public int getPtcId() {
        return ptcId;
    }

    public void setPtcId(int ptcId) {
        this.ptcId = ptcId;
    }
}
