package cn.leyizuo.springcloud.goods_server.webAPI.controller;

import cn.leyizuo.springcloud.goods_server.webAPI.entity.Goods;
import cn.leyizuo.springcloud.goods_server.webAPI.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Value("${server.port}")
    private String name;
    @GetMapping("/goods/{id}")
    public Goods getOrderById(@PathVariable int id){

        Goods goods = new Goods();
        goods =goodsService.findById(id);
        goods.setDescription(name);
        return goods;
    }
}