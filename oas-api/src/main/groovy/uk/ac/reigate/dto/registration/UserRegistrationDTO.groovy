package uk.ac.reigate.dto.registration

import javax.validation.constraints.NotNull

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import uk.ac.reigate.dto.lookup.SchoolDTO
import uk.ac.reigate.utils.CustomJsonDateDeserializer

class UserRegistrationDTO {
    
    /**
     * The users email address
     */
    @NotNull
    String email
    
    /**
     * The users legal first name
     */
    @NotNull
    String legalFirstName
    
    /**
     * The users legal surname
     */
    @NotNull
    String legalSurname
    
    /**
     * The users date of birth
     */
    @NotNull
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    Date dob
    
    /**
     * The users current school ID
     */
    SchoolDTO school
}
