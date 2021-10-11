package za.ac.nwu.AccountSystem.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.ac.nwu.AccountSystem.domain.dto.AccountTypeDto;
import za.ac.nwu.AccountSystem.domain.persistence.AccountType;
import za.ac.nwu.AccountSystem.repo.persistence.AccountTypeRepository;
import za.ac.nwu.AccountSystem.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTypeTranslatorImpl.class);
    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository)
    {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes()
    {

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try{
            for (AccountType accountType: accountTypeRepository.findAll()){
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        }catch (Exception e){
            throw new RuntimeException("Error 404");
        }
        LOGGER.info("Object List AccountTypes {}",accountTypeDtos);

        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto)
    {
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);

    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic)
    {

        AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
        return new AccountTypeDto(accountType);
    }
    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic)
    {

        AccountType accountType = accountTypeRepository.getAccountTypeMnemonicNativeQuery(mnemonic);
        return new AccountTypeDto(accountType);
    }
    @Override
    public AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic)
    {
        return accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
    }

}
