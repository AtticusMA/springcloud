package cn.leyizuo.springcloud.orders_server.webAPI.controller;

import cn.leyizuo.springcloud.orders_server.webAPI.entity.Orders;
import cn.leyizuo.springcloud.orders_server.webAPI.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders/{id}")
    public Orders findOrderById(@PathVariable int id){
        return  ordersService.getOrdersById(id);
    }
}
