package uk.ac.reigate.services.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import uk.ac.reigate.exceptions.UserExistsException
import uk.ac.reigate.oas.domain.security.User
import uk.ac.reigate.oas.repositories.security.UserRepository

@Component
class UserService {
    
    @Autowired
    UserRepository userRepository
    
    User getByUsername(String username) {
        return userRepository.findByUsername(username)
    }
    
    User save(User user) {
        return userRepository.save(user)
    }
    
    User createUser(User user) throws UserExistsException {
        if (getByUsername(user.username) != null) {
            throw new UserExistsException()
        }
        return save(user)
    }
}
