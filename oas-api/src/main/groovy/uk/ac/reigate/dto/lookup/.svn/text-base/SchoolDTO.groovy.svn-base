package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.oas.domain.lookup.School

/**
 *
 * JSON serializable DTO containing School data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SchoolDTO implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String name;
    
    @JsonProperty
    private Integer ukprn;
    
    /**
     * Default No Args constructor
     */
    public SchoolDTO() {
    }
    
    /**
     * Constructor to create a SchoolDto object
     *
     * @param id the Id for the School
     * @param code the code for the School
     * @param ukprn the ukprn for the School
     */
    public SchoolDTO(Integer id, String name, String ukprn) {
        this.id = id;
        this.name = name;
        this.ukprn = ukprn;
    }
    
    /**
     * Constructor to create a SchoolDto object from a School object
     *
     * @param school the School object to use for construction
     */
    SchoolDTO(School school) {
        if (school == null) return null
        if (school.id == null) return null
        this.id = school.id;
        this.name = school.name;
        this.ukprn = school.ukprn;
    }
    
    @Override
    public String toString() {
        return "SchoolDto [id=" + id + ", name=" + name + ", ukprn=" + ukprn + "]";
    }
    
    public School toSchool() {
        return new School(id: this.id, name: this.name, ukprn: this.ukprn);
    }
    
    public static SchoolDTO mapFromEntity(School school) {
        return new SchoolDTO(school);
    }
    
    public static List<SchoolDTO> mapFromList(List<School> schools) {
        List<SchoolDTO> output = schools.collect { school ->  new SchoolDTO(school) };
        return output
    }
}
