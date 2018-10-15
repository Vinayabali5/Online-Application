package uk.ac.reigate.oas.repositories

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.oas.domain.Contact

interface ContactRepository extends CrudRepository<Contact, Integer> {
}
