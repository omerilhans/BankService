package com.bank.data.entity;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class AccountBean {

    private AccountRepository accountRepo;
    private Account account;
    private List<Account> accountList;

    public AccountBean() {
        account = new Account();
        accountList = new ArrayList<>();
        accountRepo = new AccountRepository();
        System.out.println("AccountBean'den Geçti");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        int accountId = 0;
        if (request.getParameter("accountId") != null) {
            accountId = new Integer(request.getParameter("accountId"));
        }
        if (accountId == 0) {
            account.setAccountId(0);
            account.setAccountNumber(0);
            account.setAccountType("Normal");
            account.setCustomerFullName("Unname");
        } else {
            account = accountRepo.find(accountId);
        }
        accountList = accountRepo.list();
    }

    public void save() {
        accountRepo = new AccountRepository();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        int accountId = 0;
        if (request.getParameter("accountId") != null) {
            accountId = new Integer(request.getParameter("accountId"));
        }
        if (accountId == 0) {
            account.setBalanceCard(account.getLimit_card());
            account.setAccountNumber(getRandomNumber());
            accountRepo.persist(account);
        } else {
            accountRepo.merge(account);
        }
        accountRepo.close();
    }

    public long getRandomNumber() {
        return (int) (Math.random() * 100000);
    }

    public void delete() {
        accountRepo = new AccountRepository();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        int accountId = 0;
        if (request.getParameter("accountId") != null) {
            accountId = new Integer(request.getParameter("accountId"));
        }
        if (accountId != 0) {
            accountRepo.remove(accountId);
            accountList = accountRepo.list();
            accountRepo.close();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Getter - Setter">
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
//</editor-fold>

}
