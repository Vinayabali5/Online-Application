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
@Table(name = "title")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "title_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Title extends BaseEntityIdentity {
    
    @Column(name = "code", nullable = false)
    String code
    
    @Column(name = "description", nullable = false)
    String description
    
    Title(){}
    
    Title(Integer id, String code, String description){
        this.id = id;
        this.code = code;
        this.description = description
    }
    
    Title(String code, String description){
        this(null, code, description)
    }
    
    String toString() {
        return description
    }
}
