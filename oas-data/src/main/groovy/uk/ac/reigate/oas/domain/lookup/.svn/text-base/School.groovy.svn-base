package uk.ac.reigate.oas.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.oas.domain.BaseEntityIdentity
import uk.ac.reigate.oas.domain.institution.Institution

@Entity
@Table(name = "school")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "school_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class School extends BaseEntityIdentity {
    
    @Column(name = "name", nullable = false)
    String name
    
    @Column(name = "ukprn", unique = true, nullable = false)
    Integer ukprn
    
    @ManyToMany(mappedBy = "partnerSchool")
    List<Institution> institutions
    
    /**
     * Default No Args constructor
     */
    School(){}
    
    School(Integer id, String name, Integer ukprn){
        this.id = id;
        this.name = name;
        this.ukprn = ukprn;
    }
    
    School(String name, Integer ukprn){
        this(null, name, ukprn)
    }
    
    String toString(){
        return name;
    }
}
