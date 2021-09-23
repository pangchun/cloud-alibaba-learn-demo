package com.pangchun.controller;

import com.pangchun.entity.Account;
import com.pangchun.entity.Storage;
import com.pangchun.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/storage")
public class StorageController {

    private final RestTemplate restTemplate;

    @Resource
    private StorageService storageService;

    @Autowired
    public StorageController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/get")
    public Storage get() {
        Storage storage = storageService.getById(1);
        System.out.println(storage.toString());
        return storage;
    }

    @PostMapping("/buy")
    public void buy(Long productId, Long userId) {
        storageService.buy(productId, userId, restTemplate);
    }
}