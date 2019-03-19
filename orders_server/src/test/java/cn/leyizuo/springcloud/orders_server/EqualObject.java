package cn.leyizuo.springcloud.orders_server;

import cn.leyizuo.springcloud.orders_server.webAPI.entity.Goods;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class EqualObject {
    public static void main(String[] args){
        Goods goods1 = new Goods(1,"haochi",new BigDecimal("12.1"));
        Goods goods2 = new Goods(1,"haochi",new BigDecimal("12.1"));
        //牛逼啊，两个都不想等；
        System.out.println(goods1==goods2);
        System.out.println(goods1.equals(goods2));
        System.out.println(goods1.hashCode());
        System.out.println(goods2.hashCode());
        System.out.println(goods1.hashCode()==goods2.hashCode());
        String s0 = "sdssdds";
        String s1 = "sdssdds";
        System.out.println(s0==s1);
        System.out.println(s0.equals(s1));
        String s2 = new String("sdssdds");
        String s3 = new String("sdssdds");
        System.out.println("对象是否相等");
        System.out.println(s2==s3);
        System.out.println(s2.equals(s3));

        Map<String,Goods> map = new HashMap<>();
    }
}
