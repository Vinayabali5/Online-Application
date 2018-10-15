package uk.ac.reigate.api.lookup;

import java.util.logging.Logger

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.dto.lookup.QualificationDTO
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.oas.domain.lookup.Qualification
import uk.ac.reigate.services.lookup.QualificationService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


/**
 * This class is used to set up a collection of Qualification HTTP end-points for the API. 
 * 
 * @author VinayaBali
 *
 */@Controller
@RequestMapping(value = "/api", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/api", description = "Qualifications API")
public class QualificationsApi {
    
    private static final Logger LOGGER = Logger.getLogger(QualificationsApi.class.getName());
    
    @Autowired
    private final QualificationService qualificationService;
    
    /**
     * Default NoArgs constructor
     */
    QualificationsApi() {}
    
    /**
     * This method is used to retrieve all the Qualification objects and send to the user as QualificationDTO objects.
     *
     * @return A ResponseEntity with the corresponding list of QualificationDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Qualification entities", notes = "A GET request to the Qualifications endpoint returns an array of all the qualifications in the system.", response = QualificationDTO.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of qualifications")
    ])
    @RequestMapping(value = "/lookup/qualifications", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<QualificationDTO>> getAllQualifications() throws NotFoundException {
        LOGGER.info("** QualificationsApi - qualificationsGet");
        List<Qualification> qualifications = qualificationService.findAll();
        return new ResponseEntity<List<QualificationDTO>>(QualificationDTO.mapFromList(qualifications), HttpStatus.OK);
    }
}
