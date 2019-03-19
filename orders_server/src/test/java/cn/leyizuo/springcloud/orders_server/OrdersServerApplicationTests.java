package cn.leyizuo.springcloud.orders_server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(OrdersServerApplication.class)
public class OrdersServerApplicationTests {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Test
    public void contextLoads() {
        String serviceId="cn-leyizuo-springcloud-goodsserver";
        for(int i=0;i<100;i++){
            ServiceInstance serviceInstance=loadBalancerClient.choose(serviceId);
            System.out.println("第"+(i+1)+"次"+serviceInstance.getPort());
        }
    }
}
