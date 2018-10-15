package uk.ac.reigate

import java.util.logging.Logger

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.ApplicationPidFileWriter
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.core.env.Environment

@SpringBootApplication
@ComponentScan(value="uk.ac.reigate")
class OnlineApplicationUI extends SpringBootServletInitializer {
    
    private static final Logger LOGGER = Logger.getLogger(OnlineApplicationUI.class.getName());
    
    @Autowired
    private Environment env;
    
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(OnlineApplicationUI.class, args);
        ctx.addApplicationListener(new ApplicationPidFileWriter());
        Environment env = ctx.getEnvironment()
        String activeProfile = env.getProperty("spring.profiles.active") != null ? env.getProperty("spring.profiles.active") : 'none selected'
        String port = env.getProperty("server.port")
        String servletPath = env.getProperty("server.servletPath") != null ? env.getProperty("server.servletPath") : '/'
        String contextPath = env.getProperty("server.contextPath") != null ? env.getProperty("server.contextPath") : '/'
        LOGGER.info("\n" +
                "----------------------------------------------------------------------------------------------------------\n" +
                "Application '" + env.getProperty("app.name") + "' is running! \n" +
                "----------------------------------------------------------------------------------------------------------\n" +
                "Profile:\n" +
                "Run Profile: \t\t" + env.getProperty("spring.profiles.active") + "\n" +
                "Active Profiles: \t" + env.getActiveProfiles() + "\n" +
                "----------------------------------------------------------------------------------------------------------\n" +
                "Access URLs:\n" +
                "Local:\t\t\thttp://127.0.0.1:" + port + contextPath + "\n" +
                "External:\t\thttp://" + InetAddress.getLocalHost().getHostAddress() + ":" + port + contextPath + "\n" +
                "----------------------------------------------------------------------------------------------------------\n" +
                "Settings:\n" +
                "API URL:\t\t" + env.getProperty("apiUrl") + "\n" +
                "Debug Mode:\t\t" + env.getProperty("debug") + "\n" +
                "----------------------------------------------------------------------------------------------------------"
                )
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
    
    private static Class<OnlineApplicationUI> applicationClass = OnlineApplicationUI.class;
}
