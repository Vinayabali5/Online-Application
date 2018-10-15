package uk.ac.reigate.api.application

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import uk.ac.reigate.dto.application.ApplicationDTO
import uk.ac.reigate.dto.application.PredictedGradeDTO
import uk.ac.reigate.oas.domain.Application
import uk.ac.reigate.oas.domain.PredictedGrade
import uk.ac.reigate.oas.domain.security.User
import uk.ac.reigate.services.ApplicationService
import uk.ac.reigate.services.ApplicationUpdateService

/**
 * This class is used to retrieve and process the Application form data for the currently authenticated user. 
 * @author VinayaBali
 *
 */
@RestController
@Api(description = "Application Form API")
class ApplicationApi {
    
    @Autowired
    ApplicationService applicationService
    
    @Autowired
    ApplicationUpdateService applicationUpdateService
    
    /**
     * This method is used to retrieve the application form data for the currently logged in user. This is then returned to the user via
     * the API as an ApplicationDTO object.
     * 
     * @param user the currently logged in user.
     * @return a ResponseEntity wrapping an ApplicationDTO object. 
     */
    @ApiOperation(value = "Retrieve Application Form", notes = "This endpoint is used to retrieve the currently logged in users Application form data.", response = ApplicationDTO.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An ApplicationDTO object.")
    ])
    @RequestMapping(value = '/api/application', method = RequestMethod.GET)
    ResponseEntity<ApplicationDTO> userApplication(@AuthenticationPrincipal User user) {
        if (user == null) {
            return new ResponseEntity<?>(HttpStatus.UNAUTHORIZED)
        }
        if (user.application == null) {
            user.application = applicationService.createNewApplication(user)
        }
        Application application = applicationService.findById(user.application.id)
        ApplicationDTO applicationDto = new ApplicationDTO(application)
        return new ResponseEntity<ApplicationDTO>(applicationDto, HttpStatus.OK)
    }
    
    /**
     * This method is used to update an application form data object for the currently logged in user from the supplied ApplicationDTO data supplied.
     * 
     * @param user the currently logged in user.
     * @param applicationDto An ApplicationDTO object .
     * @return a ResponseEntity wrapping the updated ApplicationDTO object.
     */
    @ApiOperation(value = "Save Application Form", notes = "This endpoint is used to save the currently logged in users Application form data.", response = ApplicationDTO.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An ApplicationDTO object.")
    ])
    @RequestMapping(value = '/api/application', method = RequestMethod.PUT)
    ResponseEntity<ApplicationDTO> updateApplication(@AuthenticationPrincipal User user, @RequestBody ApplicationDTO applicationDto) {
        if (user.id != applicationDto.userId) {
            throw new AccessDeniedException("User not able to update this application form")
        }
        Application savedApplication = applicationUpdateService.updateFromDTO(applicationDto)
        return new ResponseEntity<ApplicationDTO> (new ApplicationDTO(savedApplication), HttpStatus.OK )
    }
    
    @RequestMapping(value = '/api/application/predicted-grades', method = RequestMethod.POST)
    ResponseEntity<PredictedGradeDTO> createPredictedGrade(@AuthenticationPrincipal User user, @RequestBody PredictedGradeDTO predictedGradeDto) {
        if (user.application.id != predictedGradeDto.applicationId) {
            throw new AccessDeniedException("User not able to update this application form")
        }
        PredictedGrade savedPredictedGrade = applicationUpdateService.addPredictedGradeFromDto(predictedGradeDto)
        return new ResponseEntity<PredictedGradeDTO> (new PredictedGradeDTO(savedPredictedGrade), HttpStatus.OK )
    }
    
    @RequestMapping(value = '/api/application/predicted-grades', method = RequestMethod.PUT)
    ResponseEntity<PredictedGradeDTO> updatePredictedGrade(@AuthenticationPrincipal User user, @RequestBody PredictedGradeDTO predictedGradeDto) {
        if (user.application.id != predictedGradeDto.applicationId) {
            throw new AccessDeniedException("User not able to update this application form")
        }
        PredictedGrade savedPredictedGrade = applicationUpdateService.updatePredictedGradeFromDto(predictedGradeDto)
        return new ResponseEntity<PredictedGradeDTO> (new PredictedGradeDTO(savedPredictedGrade), HttpStatus.OK )
    }
}
