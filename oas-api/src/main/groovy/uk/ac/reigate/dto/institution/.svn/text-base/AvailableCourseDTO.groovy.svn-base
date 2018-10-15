package uk.ac.reigate.dto.institution

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.oas.domain.institution.AvailableCourse

class AvailableCourseDTO {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer level;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String title;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String entryRequirements;
    
    @JsonProperty
    private String specialRequirements;
    
    /**
     * Default No Args constructor
     */
    AvailableCourseDTO() {
    }
    
    /**
     * Constructor to create a AvailableCourseDTO object from a AvailableCourse object
     *
     * @param availableCourse the AvailableCourse object to use for construction
     */
    AvailableCourseDTO(AvailableCourse availableCourse) {
        this.id = availableCourse.id;
        this.level = availableCourse.level;
        this.code = availableCourse.code;
        this.title = availableCourse.title;
        this.description = availableCourse.description;
        this.entryRequirements = availableCourse.entryRequirements;
        this.specialRequirements = availableCourse.specialRequirements;
    }
    
    @Override
    public String toString() {
        return "AvailableCourseDTO [id=" + id + ", level=" + level + ", code=" + code + ", title=" + title + ", description=" + description + ", entryRequirements=" + entryRequirements + ", specialRequirements=" + specialRequirements + "]";
    }
    
    public static AvailableCourseDTO mapFromEntity(AvailableCourse availableCourse) {
        return new AvailableCourseDTO(availableCourse);
    }
    
    public static List<AvailableCourseDTO> mapFromList(List<AvailableCourse> availableCourses) {
        return availableCourses.collect { availableCourse ->  new AvailableCourseDTO(availableCourse) };
    }
}
