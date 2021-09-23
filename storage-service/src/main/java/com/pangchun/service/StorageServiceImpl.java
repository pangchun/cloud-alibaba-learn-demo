package com.pangchun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangchun.entity.Order;
import com.pangchun.entity.Storage;
import com.pangchun.mapper.StorageMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void buy(Long productId, Long userId, RestTemplate restTemplate) {

        // 1.创建订单
        Order order = new Order();
        order.setProductId(productId);
        order.setUserId(userId);
        order.setCount(1);
        order.setMoney(100.0);
        order.setStatus(0);
        order = restTemplate.postForObject("http://order-service/order/create/", order, Order.class);
        assert order != null;

        int a = 1/0;

        // 2.从账户扣除费用
        restTemplate.put("http://account-service/account/subtract/" + userId + "/" + order.getMoney(), null);

        // 3.从仓储扣除库存
        Storage storage = this.lambdaQuery().eq(Storage::getProductId, productId).one();
        boolean flag = this.lambdaUpdate()
                .eq(Storage::getProductId, productId)
                .set(Storage::getUsed, storage.getUsed() + 1)
                .set(Storage::getResidue, storage.getResidue() - 1)
                .update();
        System.out.println(this.getById(storage.getId()));
    }
}