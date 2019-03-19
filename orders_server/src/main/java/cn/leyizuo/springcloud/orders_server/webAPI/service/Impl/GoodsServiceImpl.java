package cn.leyizuo.springcloud.orders_server.webAPI.service.Impl;

import cn.leyizuo.springcloud.orders_server.webAPI.entity.Goods;
import cn.leyizuo.springcloud.orders_server.webAPI.service.GoodsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

/**
 * 实现当调用的服务挂掉的时候，替代方法
 */
@Component
public class GoodsServiceImpl implements GoodsService {


    @Override
    public Goods findById(int id) {
        return new Goods(15,"失败了",new BigDecimal("15.0"));
    }
}
