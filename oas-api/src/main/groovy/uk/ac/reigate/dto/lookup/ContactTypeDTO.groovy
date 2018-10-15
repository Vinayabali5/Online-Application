package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.oas.domain.lookup.ContactType

/**
 *
 * JSON serializable DTO containing ContactType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ContactTypeDTO implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String name;
    
    /**
     * Default No Args constructor
     */
    public ContactTypeDTO() {
    }
    
    /**
     * Constructor to create a ContactTypeDto object from a ContactType object
     *
     * @param contactType the ContactType object to use for construction
     */
    ContactTypeDTO(ContactType contactType) {
        this.id = contactType.id;
        this.name = contactType.name;
    }
    
    @Override
    public String toString() {
        return "ContactTypeDto [id=" + id + ", name=" + name + "]";
    }
    
    public ContactType toContactType() {
        return new ContactType(id: this.id, name: this.name);
    }
    
    public static ContactTypeDTO mapFromEntity(ContactType contactType) {
        return new ContactTypeDTO(contactType);
    }
    
    public static List<ContactTypeDTO> mapFromList(List<ContactType> contactTypes) {
        return contactTypes.collect { contactType ->  new ContactTypeDTO(contactType) };
    }
}
