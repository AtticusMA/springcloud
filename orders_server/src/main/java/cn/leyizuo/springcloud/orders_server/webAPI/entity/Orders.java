package cn.leyizuo.springcloud.orders_server.webAPI.entity;

import cn.leyizuo.springcloud.orders_server.common.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Orders extends BaseEntity {

     private String orderNo;// '订单编号',
     private int shopId;// '门店id',
     private int userId;// int(32) NOT NULL COMMENT '用户id',
     private String order_status;// tinyint(4) NOT NULL COMMENT '订单状态',
     private BigDecimal goods_money;// decimal(11,2) NOT NULL COMMENT '商品价格(未进行任何折扣的价格)',
     private String deliver_type;//` tinyint(4) NOT NULL COMMENT '收货方式（0送货上门，1自提）',
     private BigDecimal total_money;// decimal(11,2) NOT NULL COMMENT '总价',
     private BigDecimal deliver_money;// decimal(11,2) NOT NULL COMMENT '快递价格',
     private BigDecimal real_total_money;// decimal(11,2) NOT NULL COMMENT '最终的收款',
     private String pay_type;// tinyint(4) NOT NULL COMMENT '付款的方式(1货到付款，0在线付款)',
     private String pay_from;// tinyint(4) DEFAULT NULL COMMENT '付款的来源（支付宝1，微信0）',
     private int addresseeId;// varchar(10) NOT NULL COMMENT '收件人id,无会生成一个user',
     private String isInvoice;// char(1) NOT NULL COMMENT '是否开发票',
     private String orderSrc;//char(1) NOT NULL COMMENT '订单来源',
     private String isAppraise;// char(1) NOT NULL COMMENT '是否评论',
     private Date delivery_time;// datetime DEFAULT NULL COMMENT '发货时间',
     private Date receive_time;// datetime DEFAULT NULL COMMENT '收货时间',
     private int expressId;// int(20) DEFAULT NULL COMMENT '快递公司的id',
     private int expressNo;// int(32) DEFAULT NULL COMMENT '快递单号',
     private int tradeNo; //int(32) DEFAULT NULL COMMENT '交易流水号',
     private BigDecimal commission_fee; //decimal(11,2) DEFAULT NULL COMMEN
     private List<Goods> goods;


    public Orders(){
        super();
    }

    public Orders(int id,String orderNo){
        super(id);
        this.orderNo=orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public BigDecimal getGoods_money() {
        return goods_money;
    }

    public void setGoods_money(BigDecimal goods_money) {
        this.goods_money = goods_money;
    }

    public String getDeliver_type() {
        return deliver_type;
    }

    public void setDeliver_type(String deliver_type) {
        this.deliver_type = deliver_type;
    }

    public BigDecimal getTotal_money() {
        return total_money;
    }

    public void setTotal_money(BigDecimal total_money) {
        this.total_money = total_money;
    }

    public BigDecimal getDeliver_money() {
        return deliver_money;
    }

    public void setDeliver_money(BigDecimal deliver_money) {
        this.deliver_money = deliver_money;
    }

    public BigDecimal getReal_total_money() {
        return real_total_money;
    }

    public void setReal_total_money(BigDecimal real_total_money) {
        this.real_total_money = real_total_money;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getPay_from() {
        return pay_from;
    }

    public void setPay_from(String pay_from) {
        this.pay_from = pay_from;
    }

    public String getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(String isInvoice) {
        this.isInvoice = isInvoice;
    }

    public String getOrderSrc() {
        return orderSrc;
    }

    public void setOrderSrc(String orderSrc) {
        this.orderSrc = orderSrc;
    }

    public String getIsAppraise() {
        return isAppraise;
    }

    public void setIsAppraise(String isAppraise) {
        this.isAppraise = isAppraise;
    }

    public Date getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(Date delivery_time) {
        this.delivery_time = delivery_time;
    }

    public Date getReceive_time() {
        return receive_time;
    }

    public void setReceive_time(Date receive_time) {
        this.receive_time = receive_time;
    }

    public int getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(int expressNo) {
        this.expressNo = expressNo;
    }

    public int getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(int tradeNo) {
        this.tradeNo = tradeNo;
    }

    public BigDecimal getCommission_fee() {
        return commission_fee;
    }

    public void setCommission_fee(BigDecimal commission_fee) {
        this.commission_fee = commission_fee;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAddresseeId() {
        return addresseeId;
    }

    public void setAddresseeId(int addresseeId) {
        this.addresseeId = addresseeId;
    }

    public int getExpressId() {
        return expressId;
    }

    public void setExpressId(int expressId) {
        this.expressId = expressId;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderNo='" + orderNo + '\'' +
                ", shopid=" + shopId +
                ", userid=" + userId +
                ", order_status='" + order_status + '\'' +
                ", goods_money=" + goods_money +
                ", deliver_type='" + deliver_type + '\'' +
                ", total_money=" + total_money +
                ", deliver_money=" + deliver_money +
                ", real_total_money=" + real_total_money +
                ", pay_type='" + pay_type + '\'' +
                ", pay_from='" + pay_from + '\'' +
                ", addresseeid=" + addresseeId +
                ", isInvoice='" + isInvoice + '\'' +
                ", orderSrc='" + orderSrc + '\'' +
                ", isAppraise='" + isAppraise + '\'' +
                ", delivery_time=" + delivery_time +
                ", receive_time=" + receive_time +
                ", expressid=" + expressId +
                ", expressNo=" + expressNo +
                ", tradeNo=" + tradeNo +
                ", commission_fee=" + commission_fee +
                '}';
    }
}