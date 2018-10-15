package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.oas.domain.lookup.Ethnicity
import uk.ac.reigate.oas.repositories.lookup.EthnicityRepository

@Service
class EthnicityService {
    
    @Autowired
    EthnicityRepository ethnicityRepository
    
    /**
     * Default NoArgs constructor
     */
    EthnicityService() {}
    
    /**
     * Autowired Constructor
     *
     * @param ethnicityRepository
     */
    EthnicityService(EthnicityRepository ethnicityRepository) {
        this.ethnicityRepository = ethnicityRepository;
    }
    
    /**
     * Find an individual ethnicity using the ethnicities ID fields
     *
     * @param id the ID fields to search for
     * @return the Ethnicity object that matches the ID supplied, or null if not found
     */
    Ethnicity findById(Integer id) {
        return ethnicityRepository.findById(id).orElse(null);
    }
    
    /**
     * Find all ethnicities
     *
     * @return a SearchResult set with the list of Ethnicities
     */
    List<Ethnicity> findAll() {
        return ethnicityRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Ethnicity object in the database
     *
     * @param ethnicity the new Ethnicity object to be saved
     * @return the saved version of the Ethnicity object
     */
    public Ethnicity save(Ethnicity ethnicity) {
        return ethnicityRepository.save(ethnicity)
    }
    
    /**
     * Saves a list of Ethnicity objects to the database
     *
     * @param ethnicities a list of Ethnicities to be saved to the database
     * @return the list of save Ethnicity objects
     */
    @Transactional
    public List<Ethnicity> saveList(List<Ethnicity> ethnicities) {
        return ethnicities.collect { ethnicity -> save(ethnicity) };
    }
}
