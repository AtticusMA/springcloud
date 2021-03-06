package cn.leyizuo.springcloud.goods_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GoodsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsServerApplication.class, args);
    }

}
