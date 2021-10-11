package za.ac.nwu.AccountSystem.translator;

import za.ac.nwu.AccountSystem.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator
{

    List<AccountTypeDto> getAllAccountTypes();
    AccountTypeDto create(AccountTypeDto accountType);
    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);
    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);


}
