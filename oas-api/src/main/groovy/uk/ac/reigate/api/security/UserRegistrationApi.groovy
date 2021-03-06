package uk.ac.reigate.api.security

import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import uk.ac.reigate.dto.registration.RegistrationMessageDTO
import uk.ac.reigate.dto.registration.UserConfirmationDTO
import uk.ac.reigate.dto.registration.UserRegistrationDTO
import uk.ac.reigate.dto.registration.UserSetPasswordDTO
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidUserConfirmationCodeException
import uk.ac.reigate.exceptions.PasswordMatchingException
import uk.ac.reigate.oas.domain.security.User
import uk.ac.reigate.services.lookup.SchoolService
import uk.ac.reigate.services.security.UserRegistrationService

/**
 * This class is used to provide all the user registrations end points
 *  
 * @author VinayaBali
 *
 */
@RequestMapping(value = '/api/register')
@RestController
class UserRegistrationApi {
    
    @Autowired
    SchoolService schoolService
    
    @Autowired
    UserRegistrationService userRegistrationService
    
    /**
     * This method is used to create a new user based on the UserRegistrationDTO supplied.
     * 
     * @param userDTO a UserRegistrationDTO object 
     * @return 
     */
    @RequestMapping(value = '', method = RequestMethod.POST)
    ResponseEntity<RegistrationMessageDTO> register(@RequestBody @Valid UserRegistrationDTO userDTO) {
        User newUser = new User(
                username : userDTO.email,
                legalFirstName: userDTO.legalFirstName,
                legalSurname: userDTO.legalSurname,
                dob: userDTO.dob,
                school: schoolService.findById(userDTO.school.id)
                )
        User savedUser = userRegistrationService.createUser(newUser)
        def msg = new RegistrationMessageDTO(success: true, message: 'User successfully created. Check your email for a verification email.')
        def output = new ResponseEntity<?>(msg, HttpStatus.CREATED)
        return output
    }
    
    /**
     * This method is used to retrieve the user confirmation information
     * 
     * @param confirmationCode a user confirmation code to search for a given user
     * @return a UserConfirmationDTO with basic user information
     */
    @RequestMapping(value = '/confirm/{confirmationCode}', method = RequestMethod.GET)
    ResponseEntity<UserConfirmationDTO> userRegistrationConfirmation(@PathVariable String confirmationCode) {
        User user = userRegistrationService.confirmation(confirmationCode)
        UserConfirmationDTO output = new UserConfirmationDTO(firstName: user.legalFirstName, surname: user.legalSurname, confirmationCode: user.confirmationCode)
        return new ResponseEntity<UserConfirmationDTO>(output, HttpStatus.OK)
    }
    
    /**
     * This method is used to set the users password 
     *
     * @param confirmationCode a user confirmation code to search for a given user
     * @return a UserConfirmationDTO with basic user information
     */
    @RequestMapping(value = '/confirm/{confirmationCode}', method = RequestMethod.POST)
    ResponseEntity<UserConfirmationDTO> userRegistrationSetpassword(@PathVariable String confirmationCode, @RequestBody @Valid UserSetPasswordDTO userSetPasswordDTO) {
        if (userSetPasswordDTO.password != userSetPasswordDTO.repeatPassword) {
            throw new PasswordMatchingException()
        }
        User user = userRegistrationService.confirmation(confirmationCode)
        if (user == null) {
            throw new InvalidUserConfirmationCodeException()
        }
        if (user.username != userSetPasswordDTO.confirmUsername) {
            throw new InvalidDataException()
        }
        user.password = userSetPasswordDTO.password
        user.enabled = true
        userRegistrationService.setPassword(user)
        RegistrationMessageDTO output = new RegistrationMessageDTO(message: 'Password set successfully', success: true)
        return new ResponseEntity<RegistrationMessageDTO>(output, HttpStatus.OK)
    }
    
    // TODO: Add re-send confirmation email method
    
}
