package za.ac.nwu.AccountSystem.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.AccountSystem.domain.persistence.AccountTransaction;
import za.ac.nwu.AccountSystem.domain.persistence.AccountType;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
}