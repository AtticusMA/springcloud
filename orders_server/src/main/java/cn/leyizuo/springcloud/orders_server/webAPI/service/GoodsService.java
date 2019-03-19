package cn.leyizuo.springcloud.orders_server.webAPI.service;


import cn.leyizuo.springcloud.orders_server.webAPI.entity.Goods;

import cn.leyizuo.springcloud.orders_server.webAPI.service.Impl.GoodsServiceImpl;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@FeignClient(value="cn-leyizuo-springcloud-goodsserver",fallback = GoodsServiceImpl.class)
public interface GoodsService {


//第一种方式使用大量代码
//    @Autowired
//    private DiscoveryClient discoveryClient;

//    @Autowired
//    private RestTemplate restTemplate;
//
//
//    public Goods findById(int id){
//        String serviceId="cn-leyizuo-springcloud-goodsserver";
//
//        String url="http://"+serviceId+"/goods/"+id;   //端口就不需要直接指出applicationname即可
//        return this.restTemplate.getForObject(url,Goods.class);
        //discoverClient报错 没有autowired
//        List<ServiceInstance>  instances = this.discoveryClient.getInstances(serviceId);
//        if(instances.isEmpty()){
//            return null;
//        }
//        ServiceInstance serviceInstance = instances.get(0);
        //String url = "http://"+serviceInstance.getHost()+"/"+serviceInstance.getInstanceId()+"/goods/"+id;  //不行
        //String url = "http://"+serviceInstance.getInstanceId()+"/goods/"+id;
//        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/goods/"+id;  //主机加端口号就能链接，不需要其他的实例
//        System.out.println(serviceInstance.getHost()+"+++++++"+serviceInstance.getInstanceId()+"+++++++++"+serviceInstance.getPort());
//        System.out.println(url);
//        return this.restTemplate.getForObject(url,Goods.class);
//    }


    /**
     * 使用feign 一个简变得http客户端
     * @param id
     * @return
     */
    @RequestMapping(value="/goods/{id}",method = RequestMethod.GET )
    Goods findById(@PathVariable("id") int id);
}
