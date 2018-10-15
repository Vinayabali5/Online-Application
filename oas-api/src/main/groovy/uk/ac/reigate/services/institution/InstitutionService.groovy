package uk.ac.reigate.services.institution

import javax.transaction.Transactional

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import uk.ac.reigate.oas.domain.institution.Institution
import uk.ac.reigate.oas.domain.lookup.School
import uk.ac.reigate.oas.repositories.institution.InstitutionRepository

@Service
class InstitutionService {
    
    @Autowired
    InstitutionRepository institutionRepository
    
    /**
     * Default NoArgs constructor
     */
    InstitutionService() {}
    
    /**
     * Autowired Constructor
     *
     * @param institutionRepository
     */
    InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }
    
    /**
     * Find an individual institution using the institutions ID fields
     *
     * @param id the ID fields to search for
     * @return the Institution object that matches the ID supplied, or null if not found
     */
    Institution findById(Integer id) {
        return institutionRepository.findById(id).orElse(null);
    }
    
    /**
     * Find all institutions
     *
     * @return a SearchResult set with the list of Institutions
     */
    List<Institution> findAll() {
        return institutionRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Institution object in the database
     *
     * @param institution the new Institution object to be saved
     * @return the saved version of the Institution object
     */
    public Institution save(Institution institution) {
        return institutionRepository.save(institution)
    }
    
    /**
     * Saves a list of Institution objects to the database
     *
     * @param institutions a list of Institutions to be saved to the database
     * @return the list of save Institution objects
     */
    @Transactional
    public List<Institution> saveList(List<Institution> institutions) {
        return institutions.collect { institution -> save(institution) };
    }
    
    /**
     * This service method is used to find the institutions that are partners to the supplied school.
     * 
     * @param school the school to look for the partners of
     * @return a list of Institutions 
     */
    public List<Institution> findByPartnerSchool(School school) {
        return institutionRepository.findByPartnerSchool(school)
    }
}
