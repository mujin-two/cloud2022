package com.amu.springCloud.service;

public interface PaymentService {
    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);
}
