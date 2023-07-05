package com.AppBank.AppBank.Account;

import com.AppBank.AppBank.Account.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountServiceIfx {

    Account saveAccount(Account account) throws Exception;

    List<Account> findAll();

    Account findAccountById(Long id) throws Exception;

    Account updateAccount(Long id, Account account) throws Exception;

    void deleteAccountById(Long id);

}
