package uk.ac.reigate.dto.application

import javax.validation.constraints.NotNull

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.dto.AddressDTO
import uk.ac.reigate.dto.ContactDTO
import uk.ac.reigate.dto.lookup.EthnicityDTO
import uk.ac.reigate.dto.lookup.SchoolDTO
import uk.ac.reigate.dto.lookup.TitleDTO
import uk.ac.reigate.oas.domain.Application

/**
 * This DTO is used to transfer application data between the API and the end user.
 *
 * @author VinayaBali
 *
 */
@ApiModel
class ApplicationDTO {
    
    /**
     * This field is the id for the application.
     */
    @ApiModelProperty(value = "The id for the application.", required = true)
    @NotNull
    @JsonProperty
    Integer applicationId
    
    /**
     * This field is the user account associated with the application.
     */
    @ApiModelProperty(value = "is the user account associated with the application.", required = true)
    @NotNull
    @JsonProperty
    Integer userId
    
    /**
     * This field is the title of the applicant.
     */
    @ApiModelProperty(value = "The title of the applicant.", required = true)
    @JsonProperty
    TitleDTO title
    
    /**
     * This field is the legal first name for the applicant.
     */
    @ApiModelProperty(value = "The legal first name for the applicant.", required = true)
    @JsonProperty
    String legalFirstName
    
    /**
     * This field is the legal surname for the applicant.
     */
    @ApiModelProperty(value = "The legal surname for the applicant.", required = true)
    @JsonProperty
    String legalSurname
    
    /**
     * This field is the preferred name for the applicant.
     */
    @ApiModelProperty(value = "The preferred name for the applicant.", required = true)
    @JsonProperty
    String preferredName
    
    /**
     * THis fields is the home telephone number for the applicant.
     */
    @ApiModelProperty(value = "The home telephone number for the applicant.", required = true)
    @JsonProperty
    String home
    
    /**
     * This field is the mobile telephone number for the applicant.
     */
    @ApiModelProperty(value = "", required = true)
    @JsonProperty
    String mobile
    
    /**
     * This field is the email address for the applicant.
     */
    @ApiModelProperty(value = "The email address for the applicant.", required = true)
    @JsonProperty
    String email
    
    /**
     * This field is the address for the applicant.
     */
    @ApiModelProperty(value = "The address for the applicant.", required = true)
    @JsonProperty
    AddressDTO address
    
    /**
     * This field is the foster care status for the applicant.
     */
    @ApiModelProperty(value = "The foster care status for the applicant.", required = true)
    @JsonProperty
    Boolean fosterCare
    
    /**
     * This field is the name of the council that is looking after the applicant if they are in foster care.
     */
    @ApiModelProperty(value = "The name of the council that is looking after the applicant if they are in foster care.", required = true)
    @JsonProperty
    String councilLookingAfter
    
    /**
     * This field is the name of the social worker or support worker for the applicant.
     */
    @ApiModelProperty(value = "The name of the social worker or support worker for the applicant.", required = true)
    @JsonProperty
    String nameOfSocialSupportWorker
    
    /**
     * This field is status of the applicant living independently.
     */
    @ApiModelProperty(value = "status of the applicant living independently.", required = true)
    @JsonProperty
    Boolean liveIndependently
    
    /**
     * This field is the nationality of the applicant.
     */
    @ApiModelProperty(value = "The nationality of the applicant.", required = true)
    @JsonProperty
    String nationality
    
    /**
     * This field is the gender for the applicant.
     */
    @ApiModelProperty(value = "The gender for the applicant.", required = true)
    @JsonProperty
    Integer genderId
    
    /**
     * This field is the date of birth for the applicant.
     */
    @ApiModelProperty(value = "The date of birth for the applicant.", required = true)
    @JsonProperty
    Date dateOfBirth
    
    /**
     * This relationship is collection of contacts for the applicant.
     */
    List<ContactDTO> contacts
    
    /**
     * This field is the school for the applicant.
     */
    @ApiModelProperty(value = "The school for the applicant.", required = true)
    @JsonProperty
    Integer schoolId
    
    /**
     * This field is the school for the applicant.
     */
    @ApiModelProperty(value = "The school for the applicant.", required = true)
    @JsonProperty
    SchoolDTO school
    
    /**
     * This field is the date the applicant started at their current/previous school.
     */
    @ApiModelProperty(value = "The date the applicant started at their current/previous school.", required = true)
    @JsonProperty
    Date schoolStartDate
    
    /**
     * This field is the date the applicant will complete at their current/previous school.
     */
    @ApiModelProperty(value = "The date the applicant will complete at their current/previous school.", required = true)
    @JsonProperty
    Date schoolEndDate
    
    /**
     * This relationship is a collection of predicted grades for the applicant.
     */
    List<PredictedGradeDTO> predictedGrades
    
    /**
     * This field is the career aims for the applicant.
     */
    @ApiModelProperty(value = "The career aims for the applicant.", required = true)
    @JsonProperty
    String careerAims
    
    /**
     * This field is the work/voluntary experience for the applicant.
     */
    @ApiModelProperty(value = "The work/voluntary experience for the applicant.", required = true)
    @JsonProperty
    String workVoluntaryExperience
    
    /**
     * This field is the other exams, achievements and interests for the applicant.
     */
    @ApiModelProperty(value = "The other exams, achievements and interests for the applicant.", required = true)
    @JsonProperty
    String examsAchievementsInterests
    
    /**
     * This field is the residency status of the applicant. If they have been living in the UK or EEA for the last 3 years.
     */
    @ApiModelProperty(value = "The residency status of the applicant. If they have been living in the UK or EEA for the last 3 years.", required = true)
    @JsonProperty
    Boolean resident
    
    /**
     * This field is the country of residence prior to entry into the UK or EEA for the applicant.
     */
    @ApiModelProperty(value = "The country of residence prior to entry into the UK or EEA for the applicant.", required = true)
    @JsonProperty
    String previousResidentCountry
    
    /**
     * This field is if the applicant has entered the country for the purpose of education.
     */
    @ApiModelProperty(value = "The applicant has entered the country for the purpose of education. ", required = true)
    @JsonProperty
    Boolean enteredCountryForEducation
    
    /**
     * This field is the date the applicant entered the UK.
     */
    @ApiModelProperty(value = "The date the applicant entered the UK.", required = true)
    @JsonProperty
    Date dateOfEntry
    
    /**
     * This field is the ethnicity of the applicant.
     */
    @ApiModelProperty(value = "The ethnicity of the applicant.", required = true)
    @JsonProperty
    EthnicityDTO ethnicity
    
    /**
     * This relationship is to link applications with learning difficulties and disabilities.
     */
    // TODO: add lldd DTO list
    //    @JsonProperty
    //    List<LLDD> lldds
    
    /**
     * This field is the ehcp status for the applicant.
     */
    @ApiModelProperty(value = "The ehcp status for the applicant.", required = true)
    @JsonProperty
    Boolean ehcp
    
    /**
     * This field is if the applicant considers that they require support or adaptations while at the institution.
     */
    @ApiModelProperty(value = "if the applicant considers that they require support or adaptations while at the institution.", required = true)
    @JsonProperty
    Boolean supportOrAdaptations
    
    /**
     * This field is the prescribed medication for the applicant.
     */
    @ApiModelProperty(value = "The prescribed medication for the applicant. ", required = true)
    @JsonProperty
    String prescribedMedication
    
    /**
     * This field is the allegries for the applicant.
     */
    @ApiModelProperty(value = "The allegries for the applicant.", required = true)
    @JsonProperty
    String allergies
    
    /**
     * This field is the locked status of the application.
     */
    @ApiModelProperty(value = "The locked status of the application.", required = true)
    @JsonProperty
    Boolean locked
    
    /**
     * Default NoArgs constructor
     */
    ApplicationDTO() {
        
    }
    
    /**
     * ApplicationDTO Constructor from an Application object.
     *
     * @param application the Application object to construct from
     */
    ApplicationDTO(Application application) {
        this.applicationId = application.id
        
        this.userId = application?.user.id
        this.title = new TitleDTO(application?.title)
        this.legalFirstName = application.legalFirstName
        this.legalSurname = application.legalSurname
        this.preferredName = application.preferredName
        this.home = application.home
        this.mobile = application.mobile
        this.email = application.email
        this.address = new AddressDTO(application?.address)
        this.fosterCare = application.fosterCare
        this.councilLookingAfter = application.councilLookingAfter
        this.nameOfSocialSupportWorker = application.nameOfSocialSupportWorker
        this.liveIndependently = application.liveIndependently
        this.nationality = application.nationality
        this.genderId = application?.gender?.id
        this.dateOfBirth = application.dateOfBirth
        
        this.schoolId = application?.school?.id
        this.school = new SchoolDTO(application?.school)
        this.schoolStartDate = application?.schoolStartDate
        this.schoolEndDate = application?.schoolEndDate
        
        this.careerAims = application.careerAims
        this.workVoluntaryExperience = application.workVoluntaryExperience
        this.examsAchievementsInterests = application.examsAchievementsInterests
        this.resident = application.resident
        this.previousResidentCountry = application.previousResidentCountry
        this.enteredCountryForEducation = application.enteredCountryForEducation
        this.dateOfEntry = application.dateOfEntry
        this.ethnicity = new EthnicityDTO(application?.ethnicity)
        this.ehcp = application.ehcp
        this.supportOrAdaptations = application.supportOrAdaptations
        this.prescribedMedication = application.prescribedMedication
        this.allergies = application.allergies
        
        this.contacts = ContactDTO.mapFromList(application.contacts)
        this.predictedGrades = PredictedGradeDTO.mapFromList(application?.predictedGrades)
        
        //    List<LLDD> lldds
        
        this.locked = application.locked
        
    }
    
}
