package uk.ac.reigate.oas.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import uk.ac.reigate.oas.domain.BaseEntity

@Entity
@Table(name = "lldd")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "lldd_id"))
])
@EqualsAndHashCode(includeFields=true)
class LLDD extends BaseEntity {
    
    @Column(name="code", unique = true, nullable = false)
    String code
    
    @Column(name="description", nullable = false)
    String description
}
