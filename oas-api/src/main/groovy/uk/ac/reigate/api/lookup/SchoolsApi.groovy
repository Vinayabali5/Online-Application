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

import uk.ac.reigate.dto.lookup.SchoolDTO
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.oas.domain.lookup.School
import uk.ac.reigate.services.lookup.SchoolService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


/**
 * This class is used to set up a collection of Schools HTTP end-points for the API. 
 * 
 * @author VinayaBali
 *
 */@Controller
@RequestMapping(value = "/api", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/api", description = "Schools API")
public class SchoolsApi {
    
    private static final Logger LOGGER = Logger.getLogger(SchoolsApi.class.getName());
    
    @Autowired
    private final SchoolService schoolService;
    
    /**
     * Default NoArgs constructor
     */
    SchoolsApi() {}
    
    /**
     * Autowired constructor
     */
    SchoolsApi(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    
    /**
     * This method is used to retrieve all the School objects and send to the user as SchoolDTO objects.
     *
     * @return A ResponseEntity wrapping the corresponding list of SchoolDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of School entities", notes = "A GET request to the Schools endpoint returns an array of all the schools in the system.", response = SchoolDTO.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of schools")
    ])
    @RequestMapping(value = "/lookup/schools", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<SchoolDTO>> getAllSchools() throws NotFoundException {
        LOGGER.info("** SchoolsApi - schoolsGet");
        List<School> schools = schoolService.findAll();
        return new ResponseEntity<List<SchoolDTO>>(SchoolDTO.mapFromList(schools), HttpStatus.OK);
    }
}
