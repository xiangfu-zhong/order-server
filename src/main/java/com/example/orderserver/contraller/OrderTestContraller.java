package com.example.orderserver.contraller;

import com.example.orderserver.service.IOrderTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderTestContraller")
public class OrderTestContraller {

    //@Autowired
    //private IOrderTestService orderTestService;

    @GetMapping("/order")
    public String order(String str){
        System.out.println("order方法调用成功！！！");
        //orderTestService.order(str);
        return "success1111";
    }

    @GetMapping("/circuitBreaker")
    public String circuitBreaker(String orderNo){
        //orderTestService.circuitBreaker(orderNo);
        return "success";
    }
}
