package com.pangchun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pangchun.entity.Storage;
import org.springframework.web.client.RestTemplate;

public interface StorageService extends IService<Storage> {

    /**
     * 购买一件商品
     *
     * @param productId    商品id
     * @param userId       用户id
     * @param restTemplate {@link RestTemplate}
     */
    void buy(Long productId, Long userId, RestTemplate restTemplate);
}