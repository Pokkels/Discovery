package za.ac.nwu.AccountSystem.logic.flow;

import za.ac.nwu.AccountSystem.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionFlow {
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto);

}
