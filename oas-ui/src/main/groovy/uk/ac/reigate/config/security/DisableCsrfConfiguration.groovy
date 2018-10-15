package uk.ac.reigate.config.security


import java.util.logging.Logger

import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
//@Profile(value='dev')
@Order(999)
@EnableWebSecurity
class DisableCsrfConfiguration extends WebSecurityConfigurerAdapter{
    
    private static final Logger LOGGER = Logger.getLogger(DisableCsrfConfiguration.class.getName());
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("Disabling CSRF support")
        http.csrf().disable();
    }
}
