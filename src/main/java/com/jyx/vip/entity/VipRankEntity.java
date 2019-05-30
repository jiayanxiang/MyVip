package com.jyx.vip.entity;

/**
 * @author:jyx
 * @date:2019-05-30 16:44
 * @desc(描述):
 */
public class VipRankEntity {

    private int id;

    private String name;

    private int needAmount;

    private int discount;

    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNeedAmount() {
        return needAmount;
    }

    public void setNeedAmount(int needAmount) {
        this.needAmount = needAmount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
