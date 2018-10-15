package uk.ac.reigate.dto.submission

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.dto.DTOObject
import uk.ac.reigate.dto.institution.AvailableCourseDTO
import uk.ac.reigate.dto.institution.InstitutionDTO
import uk.ac.reigate.oas.domain.Submission

class SubmissionDTO implements DTOObject<SubmissionDTO, Submission> {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    Boolean complete
    
    @JsonProperty
    Integer applicationId
    
    @JsonProperty
    InstitutionDTO institution
    
    @JsonProperty
    List<AvailableCourseDTO> selectedCourses
    
    /**
     * Default No Args constructor
     */
    SubmissionDTO() {
    }
    
    /**
     * Constructor to create a SubmissionDTO object from a Submission object
     *
     * @param submission the Submission object to use for construction
     */
    SubmissionDTO(Submission submission) {
        this.applicationId = submission.id
        this.complete = submission.complete
        this.applicationId = submission?.application?.id
        this.institution = new InstitutionDTO(submission.institution)
        this.selectedCourses = AvailableCourseDTO.mapFromList(submission.selectedCourses)
    }
    
    public SubmissionDTO mapFromEntity(Submission submission) {
        return new SubmissionDTO(submission);
    }
    
    public List<SubmissionDTO> mapFromList(List<Submission>  submissions) {
        return submissions.collect { submission ->  new SubmissionDTO(submission) };
    }
}
