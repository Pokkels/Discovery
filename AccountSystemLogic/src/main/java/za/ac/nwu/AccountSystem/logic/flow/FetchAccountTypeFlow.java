package za.ac.nwu.AccountSystem.logic.flow;

import za.ac.nwu.AccountSystem.domain.dto.AccountTypeDto;
import za.ac.nwu.AccountSystem.domain.persistence.AccountType;

import java.util.List;

public interface FetchAccountTypeFlow
{
    List<AccountTypeDto>  getAllAccountTypes();
    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
    AccountType getAccountTypeDbEntityByMnemonic(String mnemonic);

}
