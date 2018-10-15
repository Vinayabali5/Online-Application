package uk.ac.reigate.dto.application

import io.swagger.annotations.ApiModelProperty

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.dto.lookup.QualificationDTO
import uk.ac.reigate.oas.domain.PredictedGrade

class PredictedGradeDTO {
    
    @ApiModelProperty(value = "The ID for the predicted grade.", required = true)
    @JsonProperty
    Integer id
    
    @ApiModelProperty(value = "The application ID for the predicted grade.", required = true)
    @JsonProperty
    Integer applicationId
    
    @ApiModelProperty(value = "The qualification ID for the predicted grade.", required = true)
    @JsonProperty
    Integer qualificationId
    
    @ApiModelProperty(value = "The qualification for the predicted grade.", required = true)
    @JsonProperty
    QualificationDTO qualification
    
    @ApiModelProperty(value = "The grade for the predicted grade.", required = true)
    @JsonProperty
    String grade
    
    @ApiModelProperty(value = "The year of examination for the predicted grade.", required = true)
    @JsonProperty
    Integer yearOfExamination
    
    /**
     * Default NoArgs constructor
     */
    PredictedGradeDTO() {
    }
    
    PredictedGradeDTO(PredictedGrade predictedGrade) {
        this.id = predictedGrade?.id
        this.applicationId = predictedGrade?.application?.id
        this.qualificationId = predictedGrade?.qualification?.id
        this.qualification = new QualificationDTO(predictedGrade?.qualification)
        this.grade = predictedGrade.grade
        this.yearOfExamination = predictedGrade.yearOfExamination
    }
    
    @Override
    public String toString() {
        return "PredictedGradeDTO [id=" + id + ", applicationId=" + applicationId + ", qualificationId=" + qualificationId + ", grade=" + grade + ", yearOfExamination=" + yearOfExamination + "]";
    }
    
    public toPredictedGrade() {
        return new PredictedGrade(id: this.id, qualification: this.qualification.toQualification(), grade: this.grade, yearOfExamination: this.yearOfExamination);
    }
    
    public static PredictedGradeDTO mapFromEntity(PredictedGrade predictedGrade) {
        return new PredictedGradeDTO(predictedGrade);
    }
    
    public static List<PredictedGradeDTO> mapFromList(List<PredictedGrade> predictedGrades) {
        List<PredictedGradeDTO> output = predictedGrades.collect {  predictedGrade ->
            new PredictedGradeDTO(predictedGrade)
        };
        return output
    }
}
