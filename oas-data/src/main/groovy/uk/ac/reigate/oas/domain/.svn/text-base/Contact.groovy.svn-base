package uk.ac.reigate.oas.domain

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ForeignKey
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.oas.domain.lookup.ContactType
import uk.ac.reigate.oas.domain.lookup.Title

@Entity
@Table(name = "contact")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "contact_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Contact extends BaseEntityIdentity implements Serializable {
    
    /**
     * The ContactType of this particular contact
     */
    @OneToOne
    @JoinColumn(name = "contactType_id", nullable = false, foreignKey = @ForeignKey(name = "FK_contact__contact_type"))
    ContactType type
    
    /**
     * This field is contactable status of the contact.
     */
    @Column(name = "contactable", nullable = false, columnDefinition = "bit default 1")
    Boolean contactable = true
    
    /**
     * This field is preferred status of the contact.
     */
    @Column(name = "preferred", nullable = false, columnDefinition = "bit default 1")
    Boolean preferred = true
    
    /**
     * This field is the title of the contact.
     */
    @OneToOne
    @JoinColumn(name='title_id', foreignKey = @ForeignKey(name = "FK_contact__title"))
    Title title
    
    /**
     * This field is the first name of the contact.
     */
    @Column(name = "first_name")
    String firstName
    
    /**
     * This field is the surname of the contact.
     */
    @Column(name = "surname", nullable = false)
    String surname
    
    /**
     * This field is the home telephone number of the contact.
     */
    @Column(name = "home")
    String home
    
    /**
     * This field is the mobile telephone number of the contact.
     */
    @Column(name = "mobile")
    String mobile
    
    /**
     * This field is the email address of the contact.
     */
    @Column(name = "email")
    String email
    
    /**
     * This field is the address of the contact if they do not live with the applicant.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "FK_contact__address"))
    Address address
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "application_id", nullable = false, foreignKey = @ForeignKey(name = "FK_contact__application"))
    Application application
    
    /**
     * Default NoArgs constructor.    
     */
    Contact(){}
    
    /**
     * This method is the string representation of the contact.
     */
    String toString() {
        return this.surname + ', ' + this.firstName
    }
}
