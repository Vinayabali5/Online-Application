package uk.ac.reigate.api.institution

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import uk.ac.reigate.dto.institution.InstitutionDTO
import uk.ac.reigate.oas.domain.Application
import uk.ac.reigate.oas.domain.institution.Institution
import uk.ac.reigate.oas.domain.security.User
import uk.ac.reigate.services.ApplicationService
import uk.ac.reigate.services.institution.InstitutionService

/**
 * This class is used to retrieve and process the Institution form data for the currently authenticated user. 
 * @author VinayaBali
 *
 */
@RestController
@Api(description = "Institution Form API")
class InstitutionsApi {
    
    @Autowired
    ApplicationService applicationService
    
    @Autowired
    InstitutionService institutionService
    
    /**
     * This method is used to retrieve the institution form data for the currently logged in user. This is then returned to the user via
     * the API as an InstitutionDTO object.
     *
     * @param user the currently logged in user.
     * @return a ResponseEntity wrapping an InstitutionDTO object.
     */
    @ApiOperation(value = "Retrieve Institution Form", notes = "This endpoint is used to retrieve the currently logged in users Institution form data.", response = InstitutionDTO.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An InstitutionDTO object.")
    ])
    @RequestMapping(value = '/api/institutions', method = RequestMethod.GET)
    ResponseEntity<List<InstitutionDTO>> userInstitution(@AuthenticationPrincipal User user) {
        if (user == null) {
            return new ResponseEntity<?>(HttpStatus.UNAUTHORIZED)
        }
        Application application = applicationService.findById(user.application.id)
        List<Institution> institutions = institutionService.findByPartnerSchool(application.school)
        return new ResponseEntity<List<InstitutionDTO>>(InstitutionDTO.mapFromList(institutions), HttpStatus.OK)
    }
}
