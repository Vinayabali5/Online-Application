package uk.ac.reigate.oas.domain

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ForeignKey
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

import uk.ac.reigate.oas.domain.lookup.Ethnicity
import uk.ac.reigate.oas.domain.lookup.Gender
import uk.ac.reigate.oas.domain.lookup.LLDD
import uk.ac.reigate.oas.domain.lookup.School
import uk.ac.reigate.oas.domain.lookup.Title
import uk.ac.reigate.oas.domain.security.User

/**
 * This data entity is used to store the application data. 
 * 
 * @author Michael Horgan
 *
 */
@Entity
@Table(name="application")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "application_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Application extends BaseEntityIdentity implements Serializable {
    
    @Column(name = "reference")
    String reference
    
    /**
     * This field is the user account associated with the application. 
     */
    @OneToOne
    @JoinColumn(name = 'user_id', foreignKey = @ForeignKey(name = "FK_application__user"), nullable = false)
    User user
    
    /**
     * This field is the title of the applicant.
     */
    @OneToOne
    @JoinColumn(name = 'title_id', foreignKey = @ForeignKey(name = "FK_application__title"))
    Title title
    
    /**
     * This field is the legal first name for the applicant.
     */
    @Column(name = "legal_first_name", nullable = false)
    String legalFirstName
    
    /**
     * This field is the legal surname for the applicant.
     */
    @Column(name = "legal_surname", nullable = false)
    String legalSurname
    
    /**
     * This field is the legal surname for the applicant.
     */
    @Column(name = "middle_names")
    String middleNames
    
    /**
     * This field is the preferred name for the applicant.
     */
    @Column(name = "preferred_name")
    String preferredName
    
    /**
     * THis fields is the home telephone number for the applicant.
     */
    @Column(name = "home")
    String home
    
    /**
     * This field is the mobile telephone number for the applicant.
     */
    @Column(name = "mobile")
    String mobile
    
    /**
     * This field is the email address for the applicant.
     */
    @Column(name = "email")
    String email
    
    /**
     * This field is the address for the applicant.
     */
    @OneToOne(cascade = [ CascadeType.ALL ])
    @JoinColumn(name = 'address_id', foreignKey = @ForeignKey(name = "FK_application__address"))
    Address address
    
    /**
     * This field is the foster care status for the applicant.
     */
    @Column(name = "foster_care", columnDefinition = "bit default 0")
    Boolean fosterCare = false
    
    /**
     * This field is the name of the council that is looking after the applicant if they are in foster care.
     */
    @Column(name = "council_looking_after")
    String councilLookingAfter
    
    /**
     * This field is the name of the social worker or support worker for the applicant.
     */
    @Column(name = "name_of_social_support_worker")
    String nameOfSocialSupportWorker
    
    /**
     * This field is status of the applicant living independently.
     */
    @Column(name = "live_independently", columnDefinition = "bit default 0")
    Boolean liveIndependently = false
    
    /**
     * This field is the nationality of the applicant.
     */
    @Column(name = "nationality")
    String nationality
    
    /**
     * This field is the gender for the applicant.
     */
    @OneToOne
    @JoinColumn(name = 'gender_id', foreignKey = @ForeignKey(name = "FK_application__gender"))
    Gender gender
    
    /**
     * This field is the date of birth for the applicant.
     */
    @Column(name = "dob", columnDefinition = "date")
    Date dateOfBirth
    
    /**
     * This relationship is collection of contacts for the applicant.
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "application", cascade = [ CascadeType.ALL ])
    List<Contact> contacts
    
    /**
     * This field is the gender for the applicant.
     */
    @OneToOne
    @JoinColumn(name = 'school_id', foreignKey = @ForeignKey(name = "FK_application__school"))
    School school
    
    /**
     * This field is the date the applicant started at their current/previous school.
     */
    @Column(name = "school_start_date", columnDefinition = "date")
    Date schoolStartDate
    
    /**
     * This field is the date the applicant will complete at their current/previous school.
     */
    @Column(name = "school_end_date", columnDefinition = "date")
    Date schoolEndDate
    
    /**
     * This relationship is a collection of predicted grades for the applicant.
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "application", cascade = [ CascadeType.ALL ])
    List<PredictedGrade> predictedGrades
    
    /**
     * This field is the career aims for the applicant.
     */
    @Column(name = "career_aims")
    String careerAims
    
    /**
     * This field is the work/voluntary experience for the applicant.
     */
    @Column(name = "work_voluntary_experience")
    String workVoluntaryExperience
    
    /**
     * This field is the other exams, achievements and interests for the applicant.
     */
    @Column(name = "exams_achievements_interests")
    String examsAchievementsInterests
    
    /**
     * This field is the residency status of the applicant. If they have been living in the UK or EEA for the last 3 years.
     */
    @Column(name = "resident", columnDefinition = "bit default 1")
    Boolean resident = true
    
    /**
     * This field is the country of residence prior to entry into the UK or EEA for the applicant.
     */
    @Column(name = "previous_resident_country")
    String previousResidentCountry
    
    /**
     * This field is if the applicant has entered the country for the purpose of education. 
     */
    @Column(name = "entered_country_for_education", columnDefinition = "bit default 0")
    Boolean enteredCountryForEducation = false
    
    /**
     * This field is the date the applicant entered the UK.
     */
    @Column(name = "date_of_entry", columnDefinition = "date")
    Date dateOfEntry
    
    /**
     * This field is the ethnicity of the applicant.
     */
    @OneToOne
    @JoinColumn(name = "ethnicity_id", foreignKey = @ForeignKey(name = "FK_application__ethnicity"))
    Ethnicity ethnicity
    
    /**
     * This relationship is to link applications with learning difficulties and disabilities.
     */
    @ManyToMany
    @JoinTable(
    name = "application_lldd",
    joinColumns = @JoinColumn(name = "application_id", referencedColumnName = "application_id", foreignKey = @ForeignKey(name = "FK_application_lldd__application")),
    inverseJoinColumns = @JoinColumn(name = "lldd_id", referencedColumnName = "lldd_id", foreignKey = @ForeignKey(name = "FK_application_lldd__lldd"))
    )
    List<LLDD> lldds
    
    /**
     * This field is the ehcp status for the applicant.
     */
    @Column(name = "echp", columnDefinition = "bit default 0")
    Boolean ehcp = false
    
    /**
     * This field is if the applicant considers that they require support or adaptations while at the institution.
     */
    @Column(name = "support_or_adaptations", columnDefinition = "bit default 0")
    Boolean supportOrAdaptations = false
    
    /**
     * This field is the prescribed medication for the applicant. 
     */
    @Column(name = "prescribed_medication")
    String prescribedMedication
    
    /**
     * This field is the allegries for the applicant.
     */
    @Column(name = "allergies")
    String allergies
    
    /**
     * This relationship is a collection of submissions to institutions for the application.
     */
    @OneToMany(mappedBy = "application")
    List<Submission> submissions
    
    /*
     * The following fields are used by the system to control the status of the application.
     */
    
    /**
     * This field is the locked status of the application.
     */
    @Column(name = "locked", nullable = false, columnDefinition = "bit default 0")
    Boolean locked = false
    
    /**
     * Default NoArgs constructor.
     */
    Application(){}
    
    /**
     * This method is the string representation of the application.
     */
    String toString(){
        return "Application: " + this.id;
    }
}
