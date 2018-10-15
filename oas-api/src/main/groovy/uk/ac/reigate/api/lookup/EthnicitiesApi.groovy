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

import uk.ac.reigate.dto.lookup.EthnicityDTO
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.oas.domain.lookup.Ethnicity
import uk.ac.reigate.services.lookup.EthnicityService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


/**
 * This class is used to set up a collection of Ethnicity HTTP end-points for the API. 
 * 
 * @author VinayaBali
 *
 */@Controller
@RequestMapping(value = "/api", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/api", description = "Ethnicity API")
public class EthnicitiesApi {
    
    private static final Logger LOGGER = Logger.getLogger(EthnicitiesApi.class.getName());
    
    @Autowired
    private final EthnicityService ethnicityService;
    
    /**
     * Default NoArgs constructor
     */
    EthnicitiesApi() {}
    
    /**
     * Autowired constructor
     */
    EthnicitiesApi(EthnicityService ethnicityService) {
        this.ethnicityService = ethnicityService;
    }
    
    /**
     * This method is used to retrieve all the Ethnicity objects and send to the user as EthnicityDTO objects.
     *
     * @return A ResponseEntity with the corresponding list of EthnicityDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Ethnicity entities", notes = "A GET request to the Ethnicities endpoint returns an array of all the ethnicities in the system.", response = EthnicityDTO.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of ethnicities")
    ])
    @RequestMapping(value = "/lookup/ethnicities", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<EthnicityDTO>> getAllEthnicities() throws NotFoundException {
        LOGGER.info("** EthnicitiesApi - getAll");
        List<Ethnicity> ethnicities = ethnicityService.findAll();
        return new ResponseEntity<List<EthnicityDTO>>(EthnicityDTO.mapFromList(ethnicities), HttpStatus.OK);
    }
}
