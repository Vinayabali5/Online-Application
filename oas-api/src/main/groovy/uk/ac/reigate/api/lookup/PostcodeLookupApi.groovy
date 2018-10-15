package uk.ac.reigate.api.lookup

import java.util.logging.Logger

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import uk.ac.reigate.dto.AddressDTO
import uk.ac.reigate.dto.lookup.PostcodeLookupDTO
import uk.ac.reigate.exceptions.NotFoundException;
import uk.ac.reigate.exceptions.UnknownAPIException
import uk.ac.reigate.oas.domain.Address
import uk.ac.reigate.services.PostcodeLookupService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


/**
 * This class is used to set up a collection of PostcodeLookup HTTP end-points for the API. 
 * 
 * @author VinayaBali
 *
 */@RestController
@RequestMapping(value = "/api", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/api", description = "Postcode Lookup API")
public class PostcodeLookupApi {
    
    private final static Logger log = Logger.getLogger(PostcodeLookupApi.class.getName());
    
    @Autowired
    private final PostcodeLookupService postcodeLookupService;
    
    /**
     * Default NoArgs constructor
     */
    PostcodeLookupApi() {}
    
    /**
     * Autowired constructor
     */
    PostcodeLookupApi(PostcodeLookupService postcodeLookupService){
        this.postcodeLookupService = postcodeLookupService;
    }
    
    /**
     * The search method is used to retrieve a full list of a PostcodeLookup object as identified by the postcode provided
     *
     * @param postcode the postcode value to search for using the PostcodeLookupService
     * @return a ResponseEntity wrapping an array of matching PostcodeLookup objects
     * @throws UnknownAPIException if something goes wrong with the postcode lookup an UnknownAPIException is thrown
     */
    @ApiOperation(value = "Postcode Search", notes = "This endpoint is used to search for a given postcode using the postcode lookup service. This will return a list of matching addresses from the given search paramster.", response = PostcodeLookupDTO.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of PostcodeLookup objects.")
    ])
    @RequestMapping(value='/postcodes/search/{postcode}', method=RequestMethod.GET)
    public ResponseEntity<List<PostcodeLookupDTO>> search(
            @ApiParam(value = "A postcode to use for the search", required = true)
            @PathVariable (value='postcode') String postcode) throws UnknownAPIException {
        log.info("*** PostcodeLookupApi.search")
        try {
            List<PostcodeLookupDTO> postcodes = postcodeLookupService.search(postcode)
            return new ResponseEntity<List<PostcodeLookupDTO>>(postcodes, HttpStatus.OK)
        } catch (UnknownHostException e) {
            throw new UnknownAPIException("Postcode lookup failed")
            //return new ResponseEntity<List<PostcodeLookup>>(new ErrorMessageDto("Postcode Lookup Server Unavailable", "Cannot connect to the postcode lookup server at this time."), HttpStatus.GATEWAY_TIMEOUT)
        } catch (Exception e) {
            throw new UnknownAPIException(e.getMessage())
        }
    }
    
    
    /**
     * The getById method is used to retrieve an instance of a Address object as identified by the id provided
     *
     * @param id the ID The Unique Id of the Postcode to retrieve the address
     * @return a ResponseEntity wrapping the corresponding Address object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Postcode Address Retrieval", notes = "This endpoint is used to retrieve a address from the postcode lookup service using the ID supplied. This will return an address the is assoicated with the given ID.", response = AddressDTO.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An AddressDTO object.")
    ])
    @RequestMapping(value='/postcodes/retrieve/{id}', method=RequestMethod.GET)
    public ResponseEntity <AddressDTO> getById (
            @ApiParam(value = "The unique ID of the Address to retrieve.", required = true)
            @PathVariable (value='id') String id) throws NotFoundException {
        Address postcodelookup = postcodeLookupService.retrieve(id);
        log.info("*** PostcodeLookupApi.getById(id) returned");
        return new ResponseEntity<Address>(postcodelookup, HttpStatus.OK)
    }
}

