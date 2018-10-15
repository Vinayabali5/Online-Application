package uk.ac.reigate.api.security

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import uk.ac.reigate.dto.security.UserDTO
import uk.ac.reigate.oas.domain.security.User

/**
 * This class is a rest controller that is used for sending authentication details to the end user. 
 * 
 * @author VinayaBali
 *
 */
@RestController
class AuthenticationApi {
    
    /**
     * This method is used to send a UserDTO object of the currently authenticated user to the API.
     * 
     * @param user the currently authenticated user.
     * @return a ResponseEntity wrapping a UserDTO object for authenticated user.
     */
    @RequestMapping(value = '/api/auth', method = RequestMethod.GET)
    ResponseEntity<?> login(@AuthenticationPrincipal User user) {
        if (user == null) {
            return new ResponseEntity<?>(HttpStatus.UNAUTHORIZED)
        }
        return new ResponseEntity<?>(new UserDTO(user), HttpStatus.OK)
    }
}
