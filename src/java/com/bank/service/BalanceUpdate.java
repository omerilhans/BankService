package com.bank.service;

import com.bank.data.entity.Account;
import com.bank.data.entity.AccountRepository;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "BalanceUpdate")
public class BalanceUpdate {

    @WebMethod(operationName = "getUpdateBalance")
    public String getUpdateBalance(@WebParam(name = "hesapNumarasi") int hesapNumarasi,
            @WebParam(name = "hesapTutari") int hesapTutari) {
        AccountRepository repo = new AccountRepository();
        List<Account> accntList = repo.list();
        Account accnt = null;
        for (Account account : accntList) {
            if ((long) hesapNumarasi == account.getAccountNumber()) {
                accnt = account;
                break;
            }
        }
        if (accnt != null) {
            accnt.setBalanceCard(accnt.getBalanceCard() - hesapTutari);
            repo.merge(accnt);
            repo.close();
            return "doNe";
        }
        repo.close();
        return "NoNe";
    }
}
