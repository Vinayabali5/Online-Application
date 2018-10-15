package uk.ac.reigate.oas.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.oas.domain.BaseEntityIdentity

@Entity
@Table(name = "contact_type")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "contact_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class ContactType extends BaseEntityIdentity implements Serializable {
    
    /**
     * The name of the Contact Type
     */
    @Column(name = "name", nullable = false)
    String name
    
    /**
     * Default No Args constructor
     */
    ContactType(){}
    
    String toString() {
        return name
    }
}
