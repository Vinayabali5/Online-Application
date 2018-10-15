package uk.ac.reigate.services.submission

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import uk.ac.reigate.dto.submission.SubmissionDTO
import uk.ac.reigate.oas.domain.Application
import uk.ac.reigate.oas.domain.Submission
import uk.ac.reigate.oas.domain.institution.AvailableCourse
import uk.ac.reigate.oas.repositories.SubmissionRepository
import uk.ac.reigate.oas.repositories.institution.AvailableCourseRepository
import uk.ac.reigate.services.ApplicationService
import uk.ac.reigate.services.institution.InstitutionService

@Service
class SubmissionService {
    
    @Autowired
    SubmissionRepository submissionRepository
    
    @Autowired
    ApplicationService applicationService
    
    @Autowired
    InstitutionService institutionService
    
    @Autowired
    AvailableCourseRepository availableCourseRepository
    
    Submission save(Submission submission){
        return submissionRepository.save(submission)
    }
    
    List<Submission> findSubmissionsByApplication(Application application) {
        return submissionRepository.findAllByApplication(application)
    }
    
    Submission create(SubmissionDTO submissionDto) {
        
        
        Submission submission = new Submission()
        submission.application = applicationService.findById(submissionDto.applicationId)
        submission.institution = institutionService.findById(submissionDto.institution.id)
        submission.submissionDate = new Date()
        List<AvailableCourse> courses = new ArrayList<AvailableCourse>()
        courses = submissionDto.selectedCourses.collect { course ->
            if (course != null && course.id != null) {
                availableCourseRepository.findById(course.id).orElse(null)
            }
        }
        courses.removeAll(Collections.singleton(null))
        submission.selectedCourses = courses
        submission.complete = true
        Submission savedSubmission = save(submission)
        return savedSubmission
    }
}
