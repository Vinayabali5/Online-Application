package uk.ac.reigate.dto;

import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotNull

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.dto.lookup.ContactTypeDTO
import uk.ac.reigate.dto.lookup.TitleDTO
import uk.ac.reigate.oas.domain.Contact

/**
 *
 * JSON serializable DTO containing Address data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ContactDTO implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @NotNull
    @JsonProperty
    private ContactTypeDTO type;
    
    @JsonProperty
    private TitleDTO title;
    
    @NotNull
    @JsonProperty
    private String firstName
    
    @NotNull
    @JsonProperty
    private String surname
    
    @JsonProperty
    private String home
    
    @JsonProperty
    private String mobile
    
    @JsonProperty
    private String email
    
    @JsonProperty
    private boolean contactable
    
    @JsonProperty
    private boolean preferred
    
    @JsonProperty
    private AddressDTO address
    
    /**
     * Default No Args constructor
     */
    public ContactDTO() {
    }
    
    /**
     * Constructor to create a ContactDto object from a Contact object
     *
     * @param contact the Contact object to use for construction
     */
    public ContactDTO(Contact contact) {
        this.id = contact.id;
        this.type = ContactTypeDTO.mapFromEntity(contact.type)
        this.title = TitleDTO.mapFromEntity(contact.title)
        this.firstName = contact.firstName;
        this.surname = contact.surname;
        this.home = contact.home;
        this.mobile = contact.mobile;
        this.email = contact.email;
        this.contactable = contact.contactable;
        this.preferred = contact.preferred;
        this.address = contact.address != null ? new AddressDTO(contact.address) : null;
    }
    
    @Override
    public String toString() {
        return "ContactDto [id=" + id + ", title=" + title + ", type=" + type + ", firstName=" + firstName + ", surname=" + surname +", home=" + home + ", mobile=" + mobile + ", email=" + email + ", contactable=" + contactable + ", preferred=" + preferred + ", address=" + address + "]"
    }
    
    public toContact() {
        return new Contact(
                id: this.id,
                title: this?.title?.toTitle(),
                type: this?.type?.toContactType(),
                firstName: this.firstName,
                surname: this.surname,
                home: this.home,
                mobile: this.mobile,
                email: this.email,
                contactable: this.contactable,
                preferred: this.preferred,
                address: this?.address?.toAddress()
                );
    }
    
    public static ContactDTO mapFromEntity(Contact contact) {
        return new ContactDTO(contact);
    }
    
    public static List<ContactDTO> mapFromList(List<Contact> contacts) {
        return contacts.collect { contact ->  new ContactDTO(contact) };
    }
}
