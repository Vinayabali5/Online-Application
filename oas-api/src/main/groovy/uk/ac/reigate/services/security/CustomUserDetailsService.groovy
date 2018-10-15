package uk.ac.reigate.services.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.oas.domain.security.User
import uk.ac.reigate.oas.repositories.security.UserRepository

@Service(value = 'UserDetailsService')
@Transactional
class CustomUserDetailsService implements UserDetailsService {

    @Autowired 
    UserRepository userRepository
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
        if (user == null) {
            throw new UsernameNotFoundException("No user found with the username: " + username)
        }
        return user
    }
    
}
