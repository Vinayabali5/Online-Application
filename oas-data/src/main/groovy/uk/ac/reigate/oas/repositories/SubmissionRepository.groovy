package uk.ac.reigate.oas.repositories

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.oas.domain.Application
import uk.ac.reigate.oas.domain.Submission

interface SubmissionRepository extends CrudRepository<Submission, Integer> {
    
    List<Submission> findAllByApplication(Application application)
}
