package uk.ac.reigate.dto.application

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.dto.application.status.PersonalDetailsStatusDTO

class ApplicationStatusDTO {
    
    @JsonProperty
    boolean applicationStarted
    
    @JsonProperty
    boolean applicationComplete
    
    @JsonProperty
    boolean personalDetailsComplete
    
    @JsonProperty
    PersonalDetailsStatusDTO personalDetailsStatus
    
    @JsonProperty
    boolean educationHistoryComplete
    
    @JsonProperty
    boolean additionalInformationComplete
}
