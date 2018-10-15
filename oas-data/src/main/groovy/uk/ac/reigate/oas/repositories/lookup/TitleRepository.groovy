package uk.ac.reigate.oas.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.oas.domain.lookup.Title

interface TitleRepository extends CrudRepository<Title, Integer> {
}
