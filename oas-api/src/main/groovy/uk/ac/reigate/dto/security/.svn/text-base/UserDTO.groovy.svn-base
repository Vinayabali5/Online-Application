package uk.ac.reigate.dto.security

import uk.ac.reigate.oas.domain.security.User

class UserDTO {

    String username
    
    String firstName
    
    String surname
    
    List<String> roles
    
    Integer applicationId
    
    UserDTO(User user) {
        this.username = user.username
        this.firstName = user.legalFirstName
        this.surname = user.legalSurname
        this.roles = user.roles != null ? user.roles.collect { it.name } : null
        this.applicationId = user.application?.id
    }    
}
