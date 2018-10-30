package uk.ac.reigate.oas.domain

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ForeignKey
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

import uk.ac.reigate.oas.domain.institution.AvailableCourse
import uk.ac.reigate.oas.domain.institution.Institution

@Entity
@Table(name="submission")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "submission_id"))
])
@EqualsAndHashCode(includeFields=true)
class Submission extends BaseEntityIdentity {
    
    @OneToOne
    @JoinColumn(name = "application_id", foreignKey = @ForeignKey(name = "FK_submission_application"), nullable = false)
    Application application
    
    @OneToOne
    @JoinColumn(name = "institution_id", foreignKey = @ForeignKey(name = "FK_submission_institution"), nullable = false)
    Institution institution
    
    @Column(name = "submission_date", columnDefinition = "date", nullable = false)
    Date submissionDate
    
    @Column(name = "complete", columnDefinition = "bit default 1")
    Boolean complete
    
    @OneToMany
    @JoinTable(
    name = "submission_selected_courses",
    joinColumns = [
        @JoinColumn(name = "submission_id", referencedColumnName = "submission_id",  foreignKey = @ForeignKey(name = "FK_submission_selected_courses__submission"))
    ], inverseJoinColumns = [
        @JoinColumn(name = "available_course_id", referencedColumnName = "available_course_id",  foreignKey = @ForeignKey(name = "FK_submission_selected_courses__available_course"))
    ])
    List<AvailableCourse> selectedCourses
}
