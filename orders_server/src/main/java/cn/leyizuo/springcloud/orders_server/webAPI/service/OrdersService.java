package cn.leyizuo.springcloud.orders_server.webAPI.service;

import cn.leyizuo.springcloud.orders_server.webAPI.entity.Goods;
import cn.leyizuo.springcloud.orders_server.webAPI.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {

    @Autowired
    private GoodsService goodsService;

    public final static Map<Integer, Orders> orders = new HashMap<>();

    static{
        orders.put(1,new Orders(1,"123456"));
        orders.put(2,new Orders(2,"223456"));
        orders.put(3,new Orders(3,"323456"));
        orders.put(4,new Orders(4,"423456"));
        orders.put(5,new Orders(5,"523456"));
    }

    public Orders getOrdersById(int id){
        Orders order = new Orders();
        order =orders.get(id);
        Goods goods = goodsService.findById(id);
        List<Goods> goodsList = new ArrayList();
        goodsList.add(goods);
        order.setGoods(goodsList);
        return order;
    }
}
