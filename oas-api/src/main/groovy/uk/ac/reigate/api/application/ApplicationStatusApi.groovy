package uk.ac.reigate.api.application

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import uk.ac.reigate.dto.application.ApplicationStatusDTO
import uk.ac.reigate.oas.domain.security.User
import uk.ac.reigate.services.ApplicationStatusService

/**
 * 
 * @author VinayaBali
 *
 */

@RestController
class ApplicationStatusApi {
    
    @Autowired
    ApplicationStatusService applicationStatusService
    
    @RequestMapping(value = '/api/application/status', method = RequestMethod.GET)
    ResponseEntity<ApplicationStatusDTO> applicationStatus(@AuthenticationPrincipal User user) {
        if (user == null) {
            return new ResponseEntity<?>(HttpStatus.UNAUTHORIZED)
        }
        ApplicationStatusDTO status = applicationStatusService.checkStatus(user.application)
        return new ResponseEntity<ApplicationStatusDTO>(status, HttpStatus.OK)
    }
}
