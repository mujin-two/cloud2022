package com.amu.springCloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {
    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
