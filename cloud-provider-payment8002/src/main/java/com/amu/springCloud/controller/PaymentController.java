package com.amu.springCloud.controller;

import com.amu.springCloud.entities.CommonResult;
import com.amu.springCloud.entities.Payment;
import com.amu.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create (@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("create result:{}", result);
        if (result > 0) {
            return new CommonResult(200,"添加成功,serverPort: " + serverPort,result);
        } else {
            return new CommonResult(444,"添加失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> create (@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("select result:{}", result);
        if (result != null) {
            return new CommonResult(200,"查询成功,serverPort: " + serverPort,result);
        } else {
            return new CommonResult(444,"查询失败:" + id,null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
