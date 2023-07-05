package com.AppBank.AppBank.Services;

import com.AppBank.AppBank.Repositories.AccountRepository;
import com.AppBank.AppBank.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AccountServiceIfx {

    Account saveAccount(Account account);

    Account findAccountById(Long id) throws Exception;

    Account updateAccount(Long id);

    void deleteAccountById(Long id);

}
