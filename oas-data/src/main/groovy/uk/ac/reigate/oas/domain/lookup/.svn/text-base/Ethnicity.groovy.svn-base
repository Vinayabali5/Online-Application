package uk.ac.reigate.oas.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import uk.ac.reigate.oas.domain.BaseEntity

@Entity
@Table(name = "ethnicity")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "ethnicity_id"))
])
@EqualsAndHashCode(includeFields=true)
class Ethnicity extends BaseEntity {
    
    @Column(name="code", unique = true, nullable = false)
    String code
    
    @Column(name="description", nullable = false)
    String description
    
    @OneToOne
    @JoinColumn(name = 'ethnicity_group_id')
    EthnicityGroup group
    
    /**
     * ToString function that returns the code for a CodedEntity
     */
    String toString() {
        return code + ': ' + description
    }
}
