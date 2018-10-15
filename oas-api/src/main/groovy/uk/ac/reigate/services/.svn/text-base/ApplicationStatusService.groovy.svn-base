package uk.ac.reigate.services

import org.springframework.stereotype.Service

import uk.ac.reigate.dto.application.ApplicationStatusDTO
import uk.ac.reigate.dto.application.status.PersonalDetailsStatusDTO
import uk.ac.reigate.oas.domain.Application

@Service
class ApplicationStatusService {
    
    /**
     * This method is used to check the status of the supplied application
     * 
     * @param application an Application to check the status for
     * @return a DTO to send to the API
     */
    ApplicationStatusDTO checkStatus(Application application) {
        ApplicationStatusDTO status = new ApplicationStatusDTO()
        status.applicationStarted = application != null ? true : false
        status.personalDetailsComplete = checkPersonalDetails(application)
        status.personalDetailsStatus = checkPersonalDetailsStatus(application)
        status.educationHistoryComplete = checkEducationHistory(application)
        status.additionalInformationComplete = false
        status.applicationComplete = status.personalDetailsComplete && status.educationHistoryComplete && status.additionalInformationComplete
        return status
    }
    
    /**
     * This method is used to test if an application has had the personal details section completed with the basic data required.
     * 
     * @param application an Application object to be checked.
     * @return true if the personal details are complete, false if not.
     */
    boolean checkPersonalDetails(Application application) {
        boolean complete = true;
        if (application.legalFirstName == null || application.legalFirstName == '') complete = false
        if (application.legalSurname == null || application.legalSurname == '') complete = false
        if (application.email == null || application.email == '') complete = false
        if (application.address == null) complete = false
        if (application.gender == null) complete = false
        if (application.dateOfBirth == null) complete = false
        if (application.contacts == null || application.contacts.empty) complete = false
        return complete
    }
    
    
    PersonalDetailsStatusDTO checkPersonalDetailsStatus(Application application) {
        PersonalDetailsStatusDTO output = new PersonalDetailsStatusDTO()
        output.complete = true;
        if (application.legalFirstName == null || application.legalFirstName == '') output.complete = false
        if (application.legalSurname == null || application.legalSurname == '') output.complete = false
        if (application.email == null || application.email == '') output.complete = false
        if (application.address == null) output.complete = false
        if (application.gender == null) output.complete = false
        if (application.dateOfBirth == null) output.complete = false
        if (application.contacts == null || application.contacts.empty) output.complete = false
        return output
    }
    /**
     * This method is used to test if an application has had the education history details section completed with the basic data required.
     * 
     * @param application an Application object to be checked.
     * @return true if the education history details are complete, false if not.
     */
    boolean checkEducationHistory(Application application) {
        boolean complete = true;
        if (application.school == null) complete = false
        if (application.predictedGrades == null || application.predictedGrades.empty) complete = false
        if (application.schoolStartDate == null) complete = false
        if (application.schoolEndDate == null) complete = false
        return complete
    }
}
