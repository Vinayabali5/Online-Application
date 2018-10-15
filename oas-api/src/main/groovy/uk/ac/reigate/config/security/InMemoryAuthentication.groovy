package uk.ac.reigate.config.security

import java.util.logging.Logger

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@Profile(['dev', 'demo'])
@Configuration
@Order(75)
@EnableWebSecurity
class InMemoryAuthentication {
    
    private final static Logger LOGGER = Logger.getLogger("Security Settings");
    
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info("II Adding In Memory Authentication");
        
        auth.inMemoryAuthentication()
                .withUser("test").password("password").roles("Applicant")
    }
}
