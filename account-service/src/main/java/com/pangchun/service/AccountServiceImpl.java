package com.pangchun.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pangchun.entity.Account;
import com.pangchun.mapper.AccountMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
}