package uk.ac.reigate.oas.domain

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntityIdentity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id
    
    /**
     * No Args constructor for all BaseEntity classes
     */
    BaseEntityIdentity() { }
}
