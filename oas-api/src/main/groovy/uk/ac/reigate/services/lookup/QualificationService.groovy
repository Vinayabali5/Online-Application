package uk.ac.reigate.services.lookup

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.oas.domain.lookup.Qualification
import uk.ac.reigate.oas.repositories.lookup.QualificationRepository

@Service
class QualificationService {
    
    @Autowired
    QualificationRepository qualificationRepository
    
    /**
     * Default NoArgs constructor
     */
    QualificationService() {}
    
    /**
     * Autowired Constructor
     *
     * @param qualificationRepository
     */
    QualificationService(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }
    
    /**
     * Find an individual qualification using the qualifications ID fields
     *
     * @param id the ID fields to search for
     * @return the Qualification object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    Qualification findById(Integer id) {
        return qualificationRepository.findById(id).orElse(null);
    }
    
    /**
     * Find a single page of Qualification objects
     * @return a List of Qualifications
     */
    @Transactional(readOnly = true)
    List<Qualification> findAll() {
        List<Qualification> qualifications = qualificationRepository.findAll();
        return qualifications
    }
    
}
