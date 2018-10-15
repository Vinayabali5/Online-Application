package uk.ac.reigate.dto.lookup

import uk.ac.reigate.oas.domain.lookup.Ethnicity

class EthnicityDTO {
    
    Integer id
    
    String code
    
    String description
    
    String _ethnicity_group_description
    
    /**
     * Default NoArgs constructor
     */
    EthnicityDTO() {
    }
    
    /**
     * Constructor to create a EthnicityDTO object from a Ethnicity object
     *
     * @param ethnicity the Ethnicity object to use for construction
     */
    EthnicityDTO(Ethnicity ethnicity) {
        if (ethnicity == null) return null
        if (ethnicity.id == null) return null
        this.id = ethnicity.id
        this.code = ethnicity.code
        this.description = ethnicity.description
        this._ethnicity_group_description = ethnicity?.group?.description
    }
    
    @Override
    public String toString() {
        return "EthnicityDTO [id=" + id + ", code=" + code + ", description=" + description + "]";
    }
    
    public Ethnicity toEthnicity() {
        return new Ethnicity(id: this.id, code: this.code, description: this.description)
    }
    
    public static EthnicityDTO mapFromEntity(Ethnicity ethnicity) {
        return new EthnicityDTO(ethnicity);
    }
    
    public static List<EthnicityDTO> mapFromList(List<Ethnicity> ethnicities) {
        return ethnicities.collect { ethnicity ->  new EthnicityDTO(ethnicity) };
    }
}
