package za.ac.nwu.AccountSystem.logic.flow.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import za.ac.nwu.AccountSystem.domain.dto.AccountTypeDto;
import za.ac.nwu.AccountSystem.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.AccountSystem.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTypeFlowImpl.class);

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator)
    {
        this.accountTypeTranslator = accountTypeTranslator;
    }


    @Override
    public AccountTypeDto create(AccountTypeDto accountType)
    {
        if (null == accountType.getCreationDate())
        {
            accountType.setCreationDate(LocalDate.now());
        }

        LOGGER.info("Object List of AccountTypes {}",accountType);
        return accountTypeTranslator.create(accountType);
    }
}
