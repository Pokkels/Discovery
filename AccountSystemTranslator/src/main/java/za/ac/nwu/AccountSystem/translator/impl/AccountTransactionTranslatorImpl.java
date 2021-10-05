package za.ac.nwu.AccountSystem.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.AccountSystem.domain.persistence.AccountTransaction;
import za.ac.nwu.AccountSystem.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.AccountSystem.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private AccountTransactionRepository repo;

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository){
        this.repo = accountTransactionRepository;
    }


    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {


        return repo.save(accountTransaction);
    }

    @Override
    public List<AccountTransaction> getAllAccountTransactions() {

        List<AccountTransaction> accountTransactions;

        accountTransactions = new ArrayList<>(repo.findAll());
        return accountTransactions;
    }

    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionId) {


        return repo.findById(transactionId).orElse(null);
    }
}
