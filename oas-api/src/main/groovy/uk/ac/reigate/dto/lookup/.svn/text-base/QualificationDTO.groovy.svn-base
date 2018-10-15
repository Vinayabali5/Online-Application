package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.oas.domain.lookup.Qualification

/**
 *
 * JSON serializable DTO containing Title data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class QualificationDTO implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String title;
    
    @JsonProperty
    private Integer level;
    
    /**
     * Default No Args constructor
     */
    QualificationDTO() {
    }
    
    /**
     * Constructor to create a TitleDto object from a Title object
     *
     * @param title the Title object to use for construction
     */
    QualificationDTO (Qualification qualification) {
        if (qualification == null) return null
        if (qualification.id == null) return null
        this.id = qualification.id;
        this.title = qualification.title;
        this.level = qualification.level;
    }
    
    @Override
    public String toString() {
        return "TitleDto [id=" + id + ", title=" + title + ", level=" + level + "]";
    }
    
    public Qualification toQualification() {
        return new Qualification(id: this.id, title: this.title, level: this.level);
    }
    
    public static QualificationDTO mapFromEntity(Qualification qualification) {
        return new QualificationDTO(qualification);
    }
    
    public static List<QualificationDTO> mapFromList(List<Qualification> qualifications) {
        return qualifications.collect { qualification ->
            new QualificationDTO(qualification)
        };
    }
}
