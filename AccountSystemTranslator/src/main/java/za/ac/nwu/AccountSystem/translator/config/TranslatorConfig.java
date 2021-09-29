package za.ac.nwu.AccountSystem.translator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.AccountSystem.repo.config.RepositoryConfig;
import za.ac.nwu.AccountSystem.repo.persistence.AccountTypeRepository;
import za.ac.nwu.AccountSystem.translator.AccountTypeTranslator;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.AccountSystem.translator"
})
public class TranslatorConfig {

}
