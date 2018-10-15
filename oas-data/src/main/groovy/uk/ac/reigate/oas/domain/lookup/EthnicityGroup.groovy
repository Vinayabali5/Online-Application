package uk.ac.reigate.oas.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import uk.ac.reigate.oas.domain.BaseEntity

@Entity
@Table(name = "ethnicity_group")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "ethnicity_group_id"))
])
@EqualsAndHashCode(includeFields=true)
class EthnicityGroup extends BaseEntity {
    
    @Column(name = 'description')
    String description
}
