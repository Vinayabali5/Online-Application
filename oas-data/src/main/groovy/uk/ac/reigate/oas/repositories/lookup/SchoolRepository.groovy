package uk.ac.reigate.oas.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.oas.domain.lookup.School

interface SchoolRepository extends CrudRepository<School, Integer> {
}
