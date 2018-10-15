package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.oas.domain.Contact
import uk.ac.reigate.oas.repositories.ContactRepository

@Service
class ContactService {
    
    @Autowired
    ContactRepository contactRepository
    
    /**
     * Default NoArgs constructor
     */
    ContactService() {}
    
    /**
     * Autowired Constructor
     *
     * @param contactRepository
     */
    ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    
    /**
     * Find an individual contact using the contacts ID fields
     *
     * @param id the ID fields to search for
     * @return the Contact object that matches the ID supplied, or null if not found
     */
    Contact findById(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }
    
    /**
     * Find all contacts
     *
     * @return a SearchResult set with the list of Contacts
     */
    List<Contact> findAll() {
        return contactRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Contact object in the database
     *
     * @param contact the new Contact object to be saved
     * @return the saved version of the Contact object
     */
    public Contact save(Contact contact) {
        return contactRepository.save(contact)
    }
    
    /**
     * Saves a list of Contact objects to the database
     *
     * @param contacts a list of Contacts to be saved to the database
     * @return the list of save Contact objects
     */
    @Transactional
    public List<Contact> saveContacts(List<Contact> contacts) {
        return contacts.collect { contact -> save(contact) };
    }
    
    
}
