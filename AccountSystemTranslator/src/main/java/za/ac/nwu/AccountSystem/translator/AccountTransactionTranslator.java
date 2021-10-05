package za.ac.nwu.AccountSystem.translator;

import za.ac.nwu.AccountSystem.domain.persistence.AccountTransaction;

import java.util.List;

public interface AccountTransactionTranslator {

    AccountTransaction save(AccountTransaction accountTransaction);

    List<AccountTransaction> getAllAccountTransactions();

    AccountTransaction getAccountTransactionByPk(Long transactionId);
}
