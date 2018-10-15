package uk.ac.reigate.services.security

import javax.mail.internet.MimeMessage
import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidUserConfirmationCodeException
import uk.ac.reigate.exceptions.UserExistsException
import uk.ac.reigate.oas.domain.security.User
import uk.ac.reigate.oas.repositories.security.UserRepository

@Component
class UserRegistrationService {
    
    @Autowired
    UserRepository userRepository
    
    @Autowired
    PasswordEncoder passwordEncoder
    
    @Autowired
    JavaMailSender mailSender
    
    /**
     * This methods is used to save an instance of a User to the database
     * 
     * @param user
     * @return
     */
    public User save(User user) {
        return userRepository.save(user)
    }
    
    /**
     * This method is used to create a new user that does not already exist in the system
     * 
     * @param user
     * @return
     * @throws UserExistsException
     */
    public User createUser(@Valid User user) throws UserExistsException {
        User existingUser = userRepository.findByUsername(user.username)
        if (existingUser != null) {
            throw new UserExistsException()
        }
        user.confirmationCode = UUID.randomUUID().toString()
        User savedUser = save(user)
        sendConfirmation(savedUser)
        return savedUser
    }
    
    /**
     * This method is used to retrieve a User object from a supplied confirmation code.
     * 
     * @param confirmationCode the confirmation code to search for
     * @return a User object with a matching confirmation code
     */
    public User confirmation(String confirmationCode) {
        User user = userRepository.findByConfirmationCode(confirmationCode)
        if (user == null) {
            throw new InvalidUserConfirmationCodeException()
        }
        return user
    }
    
    /**
     * This method is used to set up the password for a user account either for a new user or for a password reset. This
     * will also reset the confirmation code and set the enabled flag to the same as the supplied User object. 
     * 
     * @param user a User object to set the password of. The User object should already exist.  
     * @return the saved version of the User object
     */
    public User setPassword(User user) {
        User existingUser = userRepository.findById(user.id)
        if (existingUser == null) {
            throw new InvalidDataException()
        }
        existingUser.password = passwordEncoder.encode(user.password)
        existingUser.confirmationCode = null
        existingUser.enabled = user.enabled
        return userRepository.save(existingUser)
    }
    
    /**
     * This method is used to send a new user their registration confirmation email
     *
     * @param user the User object for the new user
     */
    private void sendConfirmation(User user) {
        // TODO: Add email confirmation email sending
        MimeMessage message = mailSender.createMimeMessage()
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
        
        //SimpleMailMessage message = new SimpleMailMessage()
        message.from = 'noreply@reigate.ac.uk'
        helper.to = ['mike.horgan@reigate.ac.uk']
        helper.subject = 'Test'
        
        // TODO: Add the correct URL resolution
        String baseUrl = 'http://localhost:10901'
        String text = ''
        //text += '<html><body>'
        text += '<p>Welcome, you have requested for an account to be created. Click the link below to activate your account: </p>'
        text += '<p><a href="' + baseUrl + '/#!/register/confirm/' + user.confirmationCode + '">Activate Account</a></p>'
        //text += '</body></html>'
        helper.setText(text, true)
        mailSender.send(message)
    }
}
