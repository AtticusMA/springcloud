package cn.leyizuo.springcloud.goods_server.webAPI.entity;

import cn.leyizuo.springcloud.goods_server.common.BaseEntity;

import java.math.BigDecimal;

public class Goods extends BaseEntity {


    /**
     *商品名称
     */
    private String itemname;

    /**
     * 单位
     */
    private String unit;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 产品种类明细
     */
    private String sku;

    /**
     * 产品描述
     */
    private String description;

    /**
     * 图片链接
     */
    private String img;

    public Goods(){super();}

    public Goods(int id,String name,BigDecimal price){
        super(id);
        this.itemname=name;
        this.price = price;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "itemname='" + itemname + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
