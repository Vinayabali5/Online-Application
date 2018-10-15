package uk.ac.reigate.oas.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ForeignKey
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.oas.domain.lookup.Qualification

@Entity
@Table(name = "predicted_grade")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "predicted_grade_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@ToString
class PredictedGrade extends BaseEntityIdentity {
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'application_id', foreignKey = @ForeignKey(name = "FK_predicted_grade__application"))
    Application application
    
    @OneToOne
    @JoinColumn(name = "qualification_id", foreignKey = @ForeignKey(name = "FK_predicted_grade__qualification"))
    Qualification qualification
    
    @Column(name = "grade")
    String grade
    
    @Column(name = "year_of_examination")
    Integer yearOfExamination
}
