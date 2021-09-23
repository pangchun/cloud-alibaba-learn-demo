package com.pangchun.controller;

import com.pangchun.entity.Account;
import com.pangchun.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("/get")
    public Account get() {
        Account account = accountService.getById(1);
        System.out.println(account.toString());
        return account;
    }

    @PutMapping("/subtract/{userId}/{money}")
    public void subtract(@PathVariable("userId") Long userId, @PathVariable("money") Double money) {
        Account account = accountService.lambdaQuery().eq(Account::getUserId, userId).one();
        boolean flag = accountService.lambdaUpdate()
                .eq(Account::getUserId, userId)
                .set(Account::getUsed, account.getUsed() + money)
                .set(Account::getResidue, account.getResidue() - money)
                .update();
        System.out.println(accountService.getById(account.getId()));
    }
}