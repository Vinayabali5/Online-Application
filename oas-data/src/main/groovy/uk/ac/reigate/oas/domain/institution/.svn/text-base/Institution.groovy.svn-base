package uk.ac.reigate.oas.domain.institution

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ForeignKey
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.oas.domain.BaseEntityIdentity
import uk.ac.reigate.oas.domain.lookup.School

@Entity
@Table(name = "institution")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "institution_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Institution extends BaseEntityIdentity {
    
    /**
     * This field is used to store the name of the institution
     */
    @Column(name = "name", nullable = false)
    String name
    
    /**
     * This field is used to store a short alias for the institution
     */
    @Column(name = "alias", nullable = false, columnDefinition="varchar(5)")
    String alias
    
    /**
     * This is to define the many-to-many relationship between institutions and schools.
     */
    @ManyToMany
    @JoinTable(
    name = "institution_partner_school",
    joinColumns = @JoinColumn(name = "institution_id", referencedColumnName = "institution_id", foreignKey = @ForeignKey(name = "FK_institution_partner_school__institution")),
    inverseJoinColumns = @JoinColumn(name = "school_id", referencedColumnName = "school_id", foreignKey = @ForeignKey(name = "FK_institution_partner_school__school"))
    )
    List<School> partnerSchool
    
    @OneToMany(mappedBy = "institution")
    List<AvailableCourse> availableCourses
    
    @Column(name = "min_courses", nullable = false)
    Integer minCourses
    
    @Column(name = "max_courses", nullable = false)
    Integer maxCourses
    
    @Column(name = "course_selection_test", columnDefinition="varchar(MAX)")
    String courseSelectionText
    
    /**
     * Default No Args constructor
     */
    Institution(){}
    
    String toString(){
        return name;
    }
}
