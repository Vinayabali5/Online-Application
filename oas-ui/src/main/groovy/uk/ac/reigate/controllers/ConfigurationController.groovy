package uk.ac.reigate.controllers

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RestController

@RestController
class ConfigurationController {
    
    @Value("\${location}")
    String location
    
    @Value("\${profile}")
    String profile
    
    @Value("\${apiUrl}")
    String apiUrl
    
    
    @Value("\${debug}")
    String debug
    
    //@RequestMapping(["/config"])
    public Map<String, String> loadConfig() {
        def out = [
            location: this.location,
            profile: this.profile,
            apiUrl: this.apiUrl,
            debug: this.debug
        ];
        return out
    }
    
}
