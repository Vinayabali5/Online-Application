package uk.ac.reigate

import java.sql.SQLException
import java.util.logging.Logger

import org.h2.tools.Server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.core.env.Environment

@SpringBootApplication
@ComponentScan(value="uk.ac.reigate")
class OnlineApplications extends SpringBootServletInitializer {
    
    private static final Logger LOGGER = Logger.getLogger(OnlineApplications.class.getName());
    
    @Autowired
    private Environment env;
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(OnlineApplications.class, args);
    }
    
    /*
     static main(args) {
     SpringApplication ctx = new SpringApplication(OnlineApplications.class)
     ctx.addListeners(new ApplicationPidFileWriter());
     ctx.addListeners(new EmbeddedServerPortFileWriter());
     Environment env = ctx.run(args).getEnvironment();
     //        
     //        String activeProfile = env.getProperty("spring.profiles.active") != null ? env.getProperty("spring.profiles.active") : 'none selected'
     //        String port = env.getProperty("server.port")
     //        String servletPath = env.getProperty("server.servletPath") != null ? env.getProperty("server.servletPath") : '/'
     //        String contextPath = env.getProperty("server.contextPath") != null ? env.getProperty("server.contextPath") : '/'
     LOGGER.info("\n" +
     "----------------------------------------------------------------------------------------------------------\n" +
     "Application '" + env.getProperty("app.name") + "' is running! \n" +
     "----------------------------------------------------------------------------------------------------------\n" +
     "Profile:\n" +
     "Run Profile: \t\t" + env.getProperty("spring.profiles.active") + "\n" +
     "Active Profiles: \t" + env.getActiveProfiles() + "\n" +
     "----------------------------------------------------------------------------------------------------------\n" +
     "Access URLs:\n" +
     "Local: \t\t\t\thttp://127.0.0.1:" + env.getProperty("server.port") + "\n" +
     "External: \t\t\thttp://" + InetAddress.getLocalHost().getHostAddress() + ":" + env.getProperty("server.port") + "\n" +
     "----------------------------------------------------------------------------------------------------------\n" +
     "Database:\n" +
     "Database URL: \t\t" + env.getProperty("spring.datasource.url") + "\n" +
     "Show SQL: \t\t\t" + env.getProperty("spring.jpa.show_sql") + "\n" +
     "----------------------------------------------------------------------------------------------------------"
     )
     }
     */
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
    
    private static Class<OnlineApplications> applicationClass = OnlineApplications.class;
    
    
    /**
     * Start internal H2 server so we can query the DB from IDE
     *
     * @return H2 Server instance
     * @throws SQLException
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}

