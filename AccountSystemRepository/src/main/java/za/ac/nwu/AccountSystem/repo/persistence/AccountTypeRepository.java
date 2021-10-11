package za.ac.nwu.AccountSystem.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import za.ac.nwu.AccountSystem.domain.dto.AccountTypeDto;
import za.ac.nwu.AccountSystem.domain.persistence.AccountType;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long>
{


    @Query(value = "SELECT" +
            "       ACCOUNT_TYPE_ID,    " +
            "       ACCOUNT_TYPE_NAME,  " +
            "       CREATION_DATE,      " +
            "       MNEMONIC,           " +
            "   FROM                    " +
            "       HEINO1.ACCOUNT_TYPE  "+
            "   WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
    AccountType getAccountTypeMnemonicNativeQuery(String mnemonic);

    @Query(value = "SELECT" +
            "             at       " +
            "   FROM               " +
            "      AccountType at  " +
            "   WHERE at.mnemonic = :mnemonic")
    AccountType getAccountTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.AccountSystem.domain.dto.AccountTypeDto(" +
            "         at.mnemonic,           " +
            "         at.accountTypeName,    " +
            "         at.creationDate,       " +
            "         at.miles)              " +
            "   FROM                           " +
            "         AccountType at            "  +
            "   WHERE at.mnemonic = :mnemonic")
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);
}