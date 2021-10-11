package za.ac.nwu.AccountSystem.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE", schema = "HEINO1")
public class AccountType implements Serializable
{


    private static final long serialVersionUID = 6817255429142789236L;
    private Long accountTypeId;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;
    private Long miles;

    private Set<AccountTransaction> accountTransactions;

    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate creationDate,Long miles)
    {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
        this.miles = miles;
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate,Long miles)
    {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
        this.miles = miles;
    }

    public AccountType() {
    }

    @Id
    @SequenceGenerator(name = "ACCOUNT_TYPE_SEQ", sequenceName = "HEINO1.ACCOUNT_TYPE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TYPE_SEQ")

    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId()
    {
        return accountTypeId;
    }
    public void setAccountTypeId(Long accountTypeId)
    {
        this.accountTypeId = accountTypeId;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic()
    {
        return mnemonic;
    }
    public void setMnemonic(String mnemonic)
    {
        this.mnemonic = mnemonic;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName()
    {
        return accountTypeName;
    }
    public void setAccountTypeName(String accountTypeName)
    {
        this.accountTypeName = accountTypeName;
    }


    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate()
    {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate)
    {
        this.creationDate = creationDate;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType")
    public Set<AccountTransaction> getAccountTransactions()
    {
        return accountTransactions;
    }
    public void setAccountTransactions(Set<AccountTransaction> accountTransactions)
    {
        this.accountTransactions = accountTransactions;
    }

    @Column(name = "MILES_SUM")
    public Long getMiles()
    {
        return miles;
    }

    public void setMiles(Long miles)
    {
        this.miles = miles;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName)  && Objects.equals(creationDate, that.creationDate) && Objects.equals(miles, that.miles);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(accountTypeId, mnemonic, accountTypeName, creationDate, miles);
    }

    @Override
    public String toString()
    {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate + '\'' +
                ", miles=" + miles +
                '}';
    }

}