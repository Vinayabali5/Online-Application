package uk.ac.reigate.oas.repositories.institution

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.oas.domain.institution.Institution
import uk.ac.reigate.oas.domain.lookup.School

interface InstitutionRepository extends CrudRepository<Institution, Integer> {
    
    List<Institution> findByPartnerSchool(School school)
}
