package uk.ac.reigate.oas.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import uk.ac.reigate.oas.domain.BaseEntityIdentity

/**
 * This data entity is used to store the various pieces of text that will appear throughout the site. 
 * 
 * @author Michael Horgan
 *
 */
@Entity
@Table(name="site_text")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "site_text_id"))
])
@EqualsAndHashCode(includeFields=true)
class SiteText extends BaseEntityIdentity {
    
    /**
     * This fields is a unique name for the specific site text.
     */
    @Column(name = "name", unique = true, nullable = false)
    String name
    
    /**
     * This fields is the text that should appear on the site where a site text reference is used.
     */
    @Column(name = "text", nullable = false)
    String text
}
