package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import uk.ac.reigate.dto.lookup.PostcodeLookupDTO
import uk.ac.reigate.oas.domain.Address
import uk.ac.reigate.services.external.PCAPredictCaptureService

@Service
class PostcodeLookupService {
    
    @Autowired
    PCAPredictCaptureService lookupService
    
    public List<PostcodeLookupDTO> search(String postcode) {
        return lookupService.search(postcode)
    }
    
    public Address retrieve(String id) {
        return lookupService.retrieve(id)
    }
}
