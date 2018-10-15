package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import uk.ac.reigate.dto.application.ApplicationDTO
import uk.ac.reigate.dto.application.PredictedGradeDTO
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NoDataSuppliedException
import uk.ac.reigate.oas.domain.Application
import uk.ac.reigate.oas.domain.Contact
import uk.ac.reigate.oas.domain.PredictedGrade
import uk.ac.reigate.services.lookup.EthnicityService
import uk.ac.reigate.services.lookup.GenderService
import uk.ac.reigate.services.lookup.SchoolService
import uk.ac.reigate.services.lookup.TitleService

@Service
class ApplicationUpdateService {
    
    @Autowired
    ApplicationService applicationService
    
    @Autowired
    PredictedGradeService predictedGradeService
    
    @Autowired
    ContactService contactService
    
    @Autowired
    TitleService titleService
    
    @Autowired
    GenderService genderService
    
    @Autowired
    SchoolService schoolService
    
    @Autowired
    EthnicityService ethnicityService
    
    /**
     * This method is used to update an application data object from the DTO supplied.
     *
     * @param dto An ApplicationDTO object with the relevant changes.
     * @return The saved version of the Application.
     */
    Application updateFromDTO(ApplicationDTO dto) {
        if (dto == null) {
            throw new NoDataSuppliedException()
        }
        if (dto.applicationId == null) {
            throw new InvalidDataException()
        }
        Application app = applicationService.findById(dto.applicationId)
        
        if (app == null) {
            throw new InvalidDataException()
        }
        
        app.title = dto.title.toTitle()
        
        app.legalFirstName = dto.legalFirstName
        app.legalSurname = dto.legalSurname
        app.preferredName = dto.preferredName
        app.home = dto.home
        app.mobile = dto.mobile
        app.email = dto.email
        
        app.address = dto.address.toAddress()
        
        app.fosterCare = dto.fosterCare
        app.councilLookingAfter = dto.councilLookingAfter
        app.nameOfSocialSupportWorker = dto.nameOfSocialSupportWorker
        app.liveIndependently = dto.liveIndependently
        app.nationality = dto.nationality
        
        if (dto.genderId != null) {
            app.gender = genderService.findById(dto.genderId)
        }
        
        app.dateOfBirth = dto.dateOfBirth
        
        List<Contact> contacts = dto.contacts.collect { it ->
            Contact contact = it.toContact();
            contact.application = app;
            return contact;
        }
        app.contacts = null
        app.contacts = contacts
        
        app.school = dto.school.toSchool()
        app.schoolStartDate = dto.schoolStartDate
        app.schoolEndDate = dto.schoolEndDate
        
        // TODO: add method to process application predicted grades
        List<PredictedGrade> predictedGrades = dto.predictedGrades.collect { it ->
            PredictedGrade grade = it.toPredictedGrade();
            grade.application = app;
            return grade;
        }
        app.predictedGrades = null
        app.predictedGrades = predictedGrades //.unique(false, new PredictedGradeComparator())
        
        app.careerAims = dto.careerAims
        app.workVoluntaryExperience = dto.workVoluntaryExperience
        app.examsAchievementsInterests = dto.examsAchievementsInterests
        app.resident = dto.resident
        app.previousResidentCountry = dto.previousResidentCountry
        app.enteredCountryForEducation = dto.enteredCountryForEducation
        app.dateOfEntry = dto.dateOfEntry
        
        app.ethnicity = dto?.ethnicity?.id != null ? dto?.ethnicity?.toEthnicity() : null;
        
        app.ehcp = dto.ehcp
        app.supportOrAdaptations = dto.supportOrAdaptations
        app.prescribedMedication = dto.prescribedMedication
        app.allergies = dto.allergies
        
        return applicationService.save(app)
    }
    
    PredictedGrade addPredictedGradeFromDto(PredictedGradeDTO dto) {
        Application app = applicationService.findById(dto.applicationId)
        PredictedGrade predictedGrade = dto.toPredictedGrade()
        predictedGrade.application = app
        return predictedGradeService.save(predictedGrade)
    }
    
    PredictedGrade updatePredictedGradeFromDto(PredictedGradeDTO dto) {
        PredictedGrade predictedGrade = predictedGradeService.findById(dto?.id)
        predictedGrade.qualification = dto?.qualification.toQualification()
        predictedGrade.grade = dto?.grade
        predictedGrade.yearOfExamination = dto?.yearOfExamination
        return predictedGradeService.save(predictedGrade)
    }
    
    
    
    
}
