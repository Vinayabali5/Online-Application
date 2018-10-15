package uk.ac.reigate.dto.application.status

import com.fasterxml.jackson.annotation.JsonProperty

class PersonalDetailsStatusDTO {
    
    @JsonProperty
    Boolean complete
    
    @JsonProperty
    List<String> warnings
    
    @JsonProperty
    List<String> errors
    
    PersonalDetailsStatusDTO() {
        this.complete = false
        this.warnings = []
        this.errors = []
    }
}
