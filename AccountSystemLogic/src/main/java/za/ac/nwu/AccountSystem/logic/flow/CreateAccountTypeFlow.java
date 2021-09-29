package za.ac.nwu.AccountSystem.logic.flow;

import za.ac.nwu.AccountSystem.domain.dto.AccountTypeDto;
import za.ac.nwu.AccountSystem.domain.persistence.AccountType;

public interface CreateAccountTypeFlow {
    AccountTypeDto create(AccountTypeDto accountType);

}
