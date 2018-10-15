package uk.ac.reigate.oas.repositories

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.oas.domain.PredictedGrade

interface PredictedGradeRepository extends CrudRepository<PredictedGrade, Integer> {
}
