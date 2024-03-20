package com.example.orderserver.service.impl;

import com.example.orderserver.feignClient.IProductFeignClient;
import com.example.orderserver.service.IOrderTestService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
//import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderTestServiceImpl implements IOrderTestService {

    private static Log log= LogFactory.getLog(OrderTestServiceImpl.class);

    @Autowired
    private IProductFeignClient productFeignClient;

//    @HystrixCommand(fallbackMethod = "orderFallback")
//    @Override
//    public void order(String str) {
//        System.out.println("下单成功！");
//        //扣减库存
//        productFeignClient.updateStore("123");
//        //throw new RuntimeException("模拟业务异常");
//    }

    /**
     * 标记当前方法开启服务降级
     */
//    @HystrixCommand(
//            commandProperties = {
//                    // 启用熔断器
//                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED, value = "true"),
//                    // 设置请求线程数量，默认是20个时候，发生熔断，这设置成5个
//                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "5"),
//                    // 请求线程失败的比率，默认是大于50%时候发生熔断
//                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "50"),
//                    // 熔断机制重试策略的时间间隔，默认是5秒重试一次
//                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5"),
//            },
//            fallbackMethod = "circuitBreakFallback"
//    )
//    @Override
//    public void circuitBreaker(String orderNo) {
//        //扣减库存
//        productFeignClient.updateStore("123");
//    }


    private void circuitBreakFallback(String orderNo){
        System.out.println("服务熔断，请稍后重试！！");
    }


    private void orderFallback(String str){
        System.out.println("服务降级，请稍后重试");
    }

    public String order(String str) {
        log.info("recive order request！！！");
        return productFeignClient.updateStore("123");
    }

    public void circuitBreaker(String orderNo) {

    }
}
