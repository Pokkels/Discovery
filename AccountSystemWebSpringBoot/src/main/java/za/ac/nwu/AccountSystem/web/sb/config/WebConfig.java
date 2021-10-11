package za.ac.nwu.AccountSystem.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import za.ac.nwu.AccountSystem.logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages =
        {
        "za.ac.nwu.AccountSystem.web.sb.controller",
        "za.ac.nwu.AccountSystem.web.sb.exception"
})
public class WebConfig {
}