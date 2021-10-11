package za.ac.nwu.AccountSystem.translator.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import za.ac.nwu.AccountSystem.repo.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.AccountSystem.translator"
})
public class TranslatorConfig {

}
