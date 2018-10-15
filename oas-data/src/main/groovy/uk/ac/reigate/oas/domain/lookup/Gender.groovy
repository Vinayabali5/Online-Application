package uk.ac.reigate.oas.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import uk.ac.reigate.oas.domain.BaseEntityIdentity

@Entity
@Table(name="gender")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "gender_id"))
])
@EqualsAndHashCode(includeFields=true)
class Gender extends BaseEntityIdentity {
    
    @Column(name = "code", unique = true, nullable = false)
    String code
    
    @Column(name = "description", nullable = false)
    String description
    
    /**
     * Default No Args constructor
     */
    Gender(){}
    
    Gender(Integer id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }
    
    Gender(String code, String description) {
        this(null, code, description);
    }
    
    String toString() {
        return description
    }
}
