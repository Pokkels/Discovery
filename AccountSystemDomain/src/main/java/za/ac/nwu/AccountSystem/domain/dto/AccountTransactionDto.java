package za.ac.nwu.AccountSystem.domain.dto;

import za.ac.nwu.AccountSystem.domain.persistence.AccountTransaction;
import za.ac.nwu.AccountSystem.domain.persistence.AccountType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTransactionDto {


    private Long transactionId;
    private AccountType accountType;
    private Long memberId;
    private Long earned;
    private Long spend;
    private LocalDate transactionDate;

    public AccountTransactionDto(Long transactionId, AccountType accountType, Long memberId, Long earned, Long spend, LocalDate transactionDate) {
        this.accountType = accountType;
        this.memberId = memberId;
        this.earned = earned;
        this.spend = spend;
        this.transactionDate = transactionDate;
    }



    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getEarned() {
        return earned;
    }

    public void setEarned(Long earned) {
        this.earned = earned;
    }

    public Long getSpend() {
        return spend;
    }

    public void setSpend(Long spend) {
        this.spend = spend;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountType, that.getAccountType()) && Objects.equals(memberId, that.getMemberId()) && Objects.equals(earned, that.getEarned()) && Objects.equals(spend, that.getSpend()) && Objects.equals(transactionDate, that.getTransactionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, earned, spend, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                ", accountType=" + accountType +
                ", memberId=" + memberId +
                ", earned=" + earned +
                ", spend=" + spend +
                ", transactionDate=" + transactionDate +
                '}';
    }

}
