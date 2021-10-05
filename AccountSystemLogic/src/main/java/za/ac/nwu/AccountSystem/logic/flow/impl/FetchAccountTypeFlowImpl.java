package za.ac.nwu.AccountSystem.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.AccountSystem.domain.dto.AccountTypeDto;
import za.ac.nwu.AccountSystem.domain.persistence.AccountType;
import za.ac.nwu.AccountSystem.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.AccountSystem.repo.persistence.AccountTypeRepository;
import za.ac.nwu.AccountSystem.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {


    private final AccountTypeRepository accountTypeRepository;
    private final AccountTypeTranslator accountTypeTranslator;


    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeRepository accountTypeRepository, AccountTypeTranslator accountTypeTranslator){
        this.accountTypeRepository = accountTypeRepository;
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){

        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountType getAccountTypeDbEntityByMnemonic(String mnemonic){
        return accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        return accountTypeTranslator.getAccountTypeByMnemonicNativeQuery(mnemonic);
    }

}
