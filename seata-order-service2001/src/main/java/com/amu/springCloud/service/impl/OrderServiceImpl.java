package com.amu.springCloud.service.impl;

import com.amu.springCloud.dao.OrderDao;
import com.amu.springCloud.domain.Order;
import com.amu.springCloud.service.AccountService;
import com.amu.springCloud.service.OrderService;
import com.amu.springCloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        log.info("新订单");
        orderDao.create(order);

        log.info("改库存");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("改账户余额");
        accountService.decrease(order.getUserId(), order.getMoney());

        // 修改订单的状态，0 -> 1，表示已完成
        log.info("修改订单状态");
        orderDao.update(order.getUserId(),0);

        log.info("新订单完成");
    }

}
