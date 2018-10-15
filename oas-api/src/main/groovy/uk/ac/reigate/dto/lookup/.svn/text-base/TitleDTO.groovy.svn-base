package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.oas.domain.lookup.Title

/**
 *
 * JSON serializable DTO containing Title data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class TitleDTO implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public TitleDTO() {
    }
    
    /**
     * Constructor to create a TitleDto object from a Title object
     *
     * @param title the Title object to use for construction
     */
    TitleDTO(Title title) {
        this.id = title?.id;
        this.code = title?.code;
        this.description = title?.description;
    }
    
    @Override
    public String toString() {
        return "TitleDto [id=" + id + ", code=" + code + ", description=" + description + "]";
    }
    
    public Title toTitle() {
        if (this.id == null) return null
        return new Title(id: this.id, code: this.code, description: this.description);
    }
    
    public static TitleDTO mapFromEntity(Title title) {
        return new TitleDTO(title);
    }
    
    public static List<TitleDTO> mapFromList(List<Title> titles) {
        List<TitleDTO> output = titles.collect { title ->  new TitleDTO(title) };
        return output
    }
}
