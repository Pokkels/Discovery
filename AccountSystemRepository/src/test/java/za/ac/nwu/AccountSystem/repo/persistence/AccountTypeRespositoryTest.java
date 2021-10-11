package za.ac.nwu.AccountSystem.repo.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.AccountSystem.domain.dto.AccountTypeDto;
import za.ac.nwu.AccountSystem.domain.persistence.AccountType;
import za.ac.nwu.AccountSystem.repo.config.RepositoryConfigTest;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryConfigTest.class})
public class AccountTypeRespositoryTest {

    @Autowired
    AccountTypeRepository accountTypeRepository;
    @Before
    public void setUp() throws Exception {
        // What happens before each test
    }
    @After
    public void tearDown() throws Exception {
        // What happens after each test
    }

    @Test
    public void getAccountTypeByMnemonicNativeQueryMiles(){
        AccountType miles = accountTypeRepository.getAccountTypeMnemonicNativeQuery("MILES");
        assertNotNull(miles);
        assertEquals("MILES",miles.getMnemonic());
    }

    @Test

    public void getAccountTypeByMnemonicNativeQuery(){
        AccountType miles = accountTypeRepository.getAccountTypeMnemonicNativeQuery("MILES");
        assertNull(miles);
    }

    @Test
    public void getAccountTypeByMnemonicMiles(){
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("MILES");
        assertNotNull(miles);
        assertEquals("MILES",miles.getMnemonic());

    }

    @Test
    public void getAccountTypeByMnemonicPlay(){
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("PLAY");
        assertNotNull(miles);
        assertEquals("PLAY",miles.getMnemonic());
    }

    @Test
    public void getAccountTypeByMnemonic(){
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("R");
        assertNull(miles);

    }

    @Test
    public void getAccountTypDtoByMnemonicMiles(){
        AccountTypeDto miles = accountTypeRepository.getAccountTypeDtoByMnemonic("MILES");
        assertNotNull(miles);
        assertEquals("MILES",miles.getMnemonic());
    }
}

