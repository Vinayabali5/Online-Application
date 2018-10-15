package uk.ac.reigate.controllers

import java.util.logging.Logger

import org.springframework.stereotype.Controller

@Controller
class LandingPageController {
    
    protected static Logger LOGGER = Logger.getLogger(LandingPageController.class.getName());
    
    private static final String DEFAULT_VIEW = "index"
    
    //    @RequestMapping(["/", "/home"])
    public String showHomePage() {
        LOGGER.info("II Loading landing page");
        return DEFAULT_VIEW;
    }
}