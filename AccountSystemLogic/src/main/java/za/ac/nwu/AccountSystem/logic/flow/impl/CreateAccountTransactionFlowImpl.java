package za.ac.nwu.AccountSystem.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import za.ac.nwu.AccountSystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.AccountSystem.domain.persistence.AccountTransaction;
import za.ac.nwu.AccountSystem.domain.persistence.AccountType;
import za.ac.nwu.AccountSystem.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.AccountSystem.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.AccountSystem.translator.AccountTransactionTranslator;

@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator, FetchAccountTypeFlow fetchAccountTypeFlow)
    {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto)
    {
        accountTransactionDto.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);
        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        LOGGER.info("Object List AccountTransactions {}",createdAccountTransaction);
        return new AccountTransactionDto(createdAccountTransaction);
    }

}
