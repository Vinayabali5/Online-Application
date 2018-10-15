package uk.ac.reigate.api.submission

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

import uk.ac.reigate.dto.submission.SubmissionDTO
import uk.ac.reigate.oas.domain.Submission
import uk.ac.reigate.oas.domain.security.User
import uk.ac.reigate.services.submission.SubmissionService

@RestController
@Api(description = "Submission API")
class SubmissionApi {
    
    @Autowired
    SubmissionService submissionService
    
    /**
     * This method is used to retrieve the application form data for the currently logged in user. This is then returned to the user via
     * the API as an ApplicationDTO object.
     *
     * @param user the currently logged in user.
     * @return a ResponseEntity wrapping an ApplicationDTO object.
     */
    @ApiOperation(value = "Retrieve Submission Data", notes = "This endpoint is used to retrieve the currently logged in users submission data.", response = SubmissionDTO.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An ApplicationDTO object.")
    ])
    @RequestMapping(value = '/api/submission', method = RequestMethod.GET)
    ResponseEntity<List<SubmissionDTO>> userSubmissions(@AuthenticationPrincipal User user) {
        if (user == null) {
            return new ResponseEntity<?>(HttpStatus.UNAUTHORIZED)
        }
        List<Submission> submissions = submissionService.findSubmissionsByApplication(user.application)
        return new ResponseEntity<?>(submissions, HttpStatus.OK)
    }
    
    @RequestMapping(value = '/api/submission', method = RequestMethod.POST)
    ResponseEntity<SubmissionDTO> createSubmission(@AuthenticationPrincipal User user, @RequestBody SubmissionDTO submissionDto) {
        if (user.application.id != submissionDto.applicationId) {
            throw new AccessDeniedException("User not able to update this application form")
        }
        Submission savedSubmission = submissionService.create(submissionDto)
        
        return new ResponseEntity<SubmissionDTO> (new SubmissionDTO(savedSubmission), HttpStatus.OK )
    }
}
