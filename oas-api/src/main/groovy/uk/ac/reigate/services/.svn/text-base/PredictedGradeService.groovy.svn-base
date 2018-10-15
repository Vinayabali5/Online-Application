package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.oas.domain.PredictedGrade
import uk.ac.reigate.oas.repositories.PredictedGradeRepository

@Service
class PredictedGradeService {
    
    @Autowired
    PredictedGradeRepository predictedGradeRepository
    
    /**
     * Default NoArgs constructor
     */
    PredictedGradeService() { }
    
    /**
     * Autowired Constructor
     *
     * @param predictedGradeRepository
     */
    PredictedGradeService(PredictedGradeRepository predictedGradeRepository) {
        this.predictedGradeRepository = predictedGradeRepository
    }
    
    /**
     * Find an individual predictedGrade using the predictedGrades ID fields
     *
     * @param id the ID fields to search for
     * @return the PredictedGrade object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    PredictedGrade findById(Integer id) {
        return predictedGradeRepository.findById(id).orElse(null);
    }
    
    /**
     * Find all predictedGrades
     *
     * @return a SearchResult set with the list of PredictedGrades
     */
    @Transactional(readOnly = true)
    List<PredictedGrade> findAll() {
        return predictedGradeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete PredictedGrade object in the database
     *
     * @param predictedGrade the new PredictedGrade object to be saved
     * @return the saved version of the PredictedGrade object
     */
    @Transactional
    public PredictedGrade save(PredictedGrade predictedGrade) {
        return predictedGradeRepository.save(predictedGrade)
    }
    
    
    /**
     * Saves a list of PredictedGrade objects to the database
     *
     * @param sddresses a list of PredictedGrades to be saved to the database
     * @return the list of save PredictedGrade objects
     */
    @Transactional
    public List<PredictedGrade> savePredictedGrades(List<PredictedGrade> predictedGrades) {
        return predictedGrades.collect { predictedGrade -> save( predictedGrade) };
    }
}
