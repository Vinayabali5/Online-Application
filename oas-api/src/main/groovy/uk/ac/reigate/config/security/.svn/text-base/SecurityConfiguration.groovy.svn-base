package uk.ac.reigate.config.security

import java.util.logging.Logger

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.core.env.Environment
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository


//@Profile('secured')
@Configuration
@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled = true)
class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private final static Logger LOGGER = Logger.getLogger("Security Settings");
    
    @Autowired
    private Environment env
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("II Configuring HTTP Basic Security");
        
        BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint()
        entryPoint.setRealmName("OAS")
        
        if (env.acceptsProfiles("dev", "demo")) {
            LOGGER.info("II Configuring Development Security Settings");
            http.authorizeRequests()
                    .antMatchers("/swagger-ui.html", "/webjars/**", "/api-docs", "/swagger-resources", "/configuration/**").permitAll()
        }
        
        http.authorizeRequests()
                .antMatchers("/api/register/**").permitAll()
                .antMatchers("/api/lookup/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/**").denyAll()
                .antMatchers(HttpMethod.PUT, "/api/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/**").authenticated()
                .antMatchers(HttpMethod.GET, "/api/**").authenticated()
                .antMatchers("/**").permitAll()
                .and()
                .httpBasic()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()
    }
    
    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
}
