package uk.ac.reigate.oas.domain

import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity implements Serializable {
    
    @Id
    Integer id
    
    /**
     * No Args constructor for all BaseEntity classes
     */
    BaseEntity() { }
}
