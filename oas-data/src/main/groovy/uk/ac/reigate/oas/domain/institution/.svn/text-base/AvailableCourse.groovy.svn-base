package uk.ac.reigate.oas.domain.institution

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

import uk.ac.reigate.oas.domain.BaseEntity

@Entity
@Table(name = "available_course")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "available_course_id"))
])
@EqualsAndHashCode(includeFields=true)
class AvailableCourse extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "institution_id")
    Institution institution
    
    /**
     * This field is used to record the academic level of the course
     */
    @Column(name = "level")
    Integer level
    
    /**
     * This field is used to record the institutions code  
     */
    @Column(name = "code")
    String code
    
    /**
     * This field is used to record the title for the course
     */
    @Column(name = "title")
    String title
    
    /**
     * This fields is used to record a brief description of the course
     */
    @Column(name = "description", columnDefinition="varchar(MAX)")
    String description
    
    /**
     * This field is used to record any entry requirements for the course
     */
    @Column(name = "entry_requirements", columnDefinition="varchar(MAX)")
    String entryRequirements
    
    /**
     * This field is used to record any special requirements for the course
     */
    @Column(name = "special_requirements", columnDefinition="varchar(MAX)")
    String specialRequirements
    
    /**
     * This field is used to an external URL link for the course
     */
    @Column(name = "external_link")
    String externalLink
}
