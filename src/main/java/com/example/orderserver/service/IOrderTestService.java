package com.example.orderserver.service;

public interface IOrderTestService {
    public void order(String str);

    public void circuitBreaker(String orderNo);
}
