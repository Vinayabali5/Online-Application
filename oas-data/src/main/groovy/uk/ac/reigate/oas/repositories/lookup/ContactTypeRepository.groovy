package uk.ac.reigate.oas.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.oas.domain.lookup.ContactType

interface ContactTypeRepository extends CrudRepository<ContactType, Integer> {
}
