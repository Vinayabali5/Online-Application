package uk.ac.reigate.oas.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.oas.domain.lookup.Qualification

interface QualificationRepository extends CrudRepository<Qualification, Integer> {
}
