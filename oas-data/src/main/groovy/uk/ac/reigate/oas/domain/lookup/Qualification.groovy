package uk.ac.reigate.oas.domain.lookup

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.oas.domain.BaseEntity

@Entity
@Table(name = 'qualification')
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "qualification_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@ToString
class Qualification extends BaseEntity {
    
    @Column(name = "title", nullable = false)
    String title
    
    @Column(name = "level", nullable = false)
    Integer level
}
