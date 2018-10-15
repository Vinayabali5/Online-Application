package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.oas.domain.Address

/**
 *
 * JSON serializable DTO containing Address data
 *
 */
@JsonSerialize
public class AddressDTO implements Serializable {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    String line1
    
    @JsonProperty
    String line2
    
    @JsonProperty
    String line3
    
    @JsonProperty
    String line4
    
    @JsonProperty
    String line5
    
    @JsonProperty
    String town
    
    @JsonProperty
    String county
    
    @JsonProperty
    String postcode
    
    /**
     * Default No Args constructor
     */
    AddressDTO() {
    }
    
    /**
     * Constructor to create an AddressDto object from an Address object
     *
     * @param address the Address object to use for construction
     */
    AddressDTO(Address address) {
        this.id = address?.id
        this.line1 = address?.line1
        this.line2 = address?.line2
        this.line3 = address?.line3
        this.line4 = address?.line4
        this.line5 = address?.line5
        this.town = address?.town
        this.county = address?.county
        this.postcode = address?.postcode
    }
    
    @Override
    public String toString() {
        return "AddressDTO [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", line4=" + line4 + ", line5=" + line5 + ",county=" + county + ", postcode=" + postcode + "]"
    }
    
    public Address toAddress() {
        if (this.postcode == null) return null
        return new Address(
                id: this.id,
                line1: this.line1,
                line2: this.line2,
                line3: this.line3,
                line4: this.line4,
                line5: this.line5,
                town: this.town,
                county: this.county,
                postcode: this.postcode
                )
    }
    
    public static AddressDTO mapFromEntity(Address address) {
        return new AddressDTO(address)
    }
    
    public static List<AddressDTO> mapFromList(List<Address> addresses) {
        List<AddressDTO> output = addresses.collect { address ->  new AddressDTO(address) }
        return output
    }
}
