package cn.leyizuo.springcloud.goods_server.webAPI.service;

import cn.leyizuo.springcloud.goods_server.webAPI.entity.Goods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsService {
    private final static Map<Integer, Goods>  DataBase = new HashMap<>();

    @Value("${server.port}")
    private static String name;   //这个为什么就获取不了呢

    static{
        DataBase.put(1,new Goods(1,name,new BigDecimal(10)));
        DataBase.put(2,new Goods(2,"good2",new BigDecimal(10.0)));
        DataBase.put(3,new Goods(3,"good3",new BigDecimal(10.1)));
        DataBase.put(4,new Goods(4,"good4",new BigDecimal(10.2)));
        DataBase.put(5,new Goods(5,"good5",new BigDecimal(10.3)));
    }

    public Goods findById(int id){
        return DataBase.get(id);
    }
}
