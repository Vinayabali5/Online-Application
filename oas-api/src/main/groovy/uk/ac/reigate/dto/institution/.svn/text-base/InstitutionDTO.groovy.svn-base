package uk.ac.reigate.dto.institution

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.oas.domain.institution.Institution

class InstitutionDTO {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String name;
    
    @JsonProperty
    private String alias;
    
    @JsonProperty
    private List<AvailableCourseDTO> availableCourses
    
    @JsonProperty
    private Integer minCourses;
    
    @JsonProperty
    private Integer maxCourses;
    
    @JsonProperty
    private String courseSelectionText;
    
    /**
     * Default No Args constructor
     */
    InstitutionDTO() {
    }
    
    /**
     * Constructor to create a GenderDTO object from a Gender object
     *
     * @param gender the Gender object to use for construction
     */
    InstitutionDTO(Institution institution) {
        this.id = institution.id;
        this.name = institution.name;
        this.alias = institution.alias;
        this.availableCourses = AvailableCourseDTO.mapFromList(institution?.availableCourses);
        this.minCourses = institution.minCourses;
        this.maxCourses = institution.maxCourses;
        this.courseSelectionText = institution.courseSelectionText;
    }
    
    @Override
    public String toString() {
        return "InstitutionDTO [id=" + id + ", name=" + name + ", alias=" + alias + ", availableCourses=" + availableCourses + ", minCourses=" + minCourses + ", maxCourses=" + maxCourses + ", courseSelectionText=" + courseSelectionText + "]";
    }
    
    public static InstitutionDTO mapFromEntity(Institution institution) {
        return new InstitutionDTO(institution);
    }
    
    public static List<InstitutionDTO> mapFromList(List<Institution> institutions) {
        return institutions.collect { institution ->  new InstitutionDTO(institution) };
    }
}
