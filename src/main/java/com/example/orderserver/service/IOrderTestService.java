package com.example.orderserver.service;

public interface IOrderTestService {
    public String order(String str);

    public void circuitBreaker(String orderNo);
}
