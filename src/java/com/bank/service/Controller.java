package com.bank.service;

import com.bank.data.entity.Account;
import com.bank.data.entity.AccountLimit;
import com.bank.data.entity.AccountRepository;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "Controller")
public class Controller {

    @WebMethod(operationName = "lookLikeBalance")
    public AccountLimit lookLikeBalance(@WebParam(name = "numberCard") long numberCard) {
        AccountRepository repo = new AccountRepository();
        List<Account> accntList = repo.list();
        Account accnt = null;
        for (Account account : accntList) {
            if (numberCard == account.getAccountNumber()) {
                accnt = account;
                break;
            } else
            {
                
            }
        }
        if (accnt != null) {
            AccountLimit accnt_limit = new AccountLimit();
            accnt_limit.setBalanceCard(accnt.getBalanceCard());
            accnt_limit.setLimitCard(accnt.getLimit_card());
            accnt_limit.setNameOf_Bank(accnt.getNameOf_Bank());
            return accnt_limit;
        }
        repo.close();
        return null;
    }

}
