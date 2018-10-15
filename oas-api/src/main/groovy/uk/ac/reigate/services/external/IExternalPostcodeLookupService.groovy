package uk.ac.reigate.services.external

import uk.ac.reigate.dto.lookup.PostcodeLookupDTO
import uk.ac.reigate.exceptions.PostcodeRetrievalException
import uk.ac.reigate.exceptions.PostcodeSearchException
import uk.ac.reigate.oas.domain.Address

interface IExternalPostcodeLookupService {
    
    /**
     * This method will be used to search for a list of potential addresses for a given postcode.
     * 
     * @param postcode The postcode to search for
     * @return A list of PostcodeLookup data 
     */
    List<PostcodeLookupDTO> search(String postcode) throws PostcodeSearchException
    
    /**
     * This method will be used to retrieve an instance of an Address based on the address retrieval ID 
     * 
     * @param id An address retrieval ID 
     * @return A Address object
     */
    Address retrieve(String id) throws PostcodeRetrievalException
}
