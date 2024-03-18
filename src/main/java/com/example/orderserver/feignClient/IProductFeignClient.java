package com.example.orderserver.feignClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="PRODUCT-SERVER")
public interface IProductFeignClient {

    @GetMapping("/productTestContraller/updateStore")
    String updateStore(@RequestParam("productNo") String productNo);
}
