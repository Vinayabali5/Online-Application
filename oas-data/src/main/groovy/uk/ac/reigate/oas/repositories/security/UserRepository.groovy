package uk.ac.reigate.oas.repositories.security;

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.oas.domain.security.User

interface UserRepository extends CrudRepository<User, Integer> {
    
    User findById (Integer id)
    
    User findByUsername(String username)
    
    User findByConfirmationCode(String confirmationCode)
}
