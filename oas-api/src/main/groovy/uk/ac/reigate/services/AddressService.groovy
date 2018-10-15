package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.oas.domain.Address
import uk.ac.reigate.oas.repositories.AddressRepository

@Service
class AddressService {
    
    @Autowired
    AddressRepository addressRepository
    
    /**
     * Default NoArgs constructor
     */
    AddressService() { }
    
    /**
     * Autowired Constructor
     *
     * @param addressRepository
     */
    AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository
    }
    
    /**
     * Find an individual address using the addresses ID fields
     *
     * @param id the ID fields to search for
     * @return the Address object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    Address findById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }
    
    /**
     * Find all addresses
     *
     * @return a SearchResult set with the list of Addresses
     */
    @Transactional(readOnly = true)
    List<Address> findAll() {
        return addressRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Address object in the database
     *
     * @param address the new Address object to be saved
     * @return the saved version of the Address object
     */
    @Transactional
    public Address save(Address address) {
        return addressRepository.save(address)
    }
    
    
    /**
     * Saves a list of Address objects to the database
     *
     * @param sddresses a list of Addresses to be saved to the database
     * @return the list of save Address objects
     */
    @Transactional
    public List<Address> saveAddresses(List<Address> addresses) {
        return addresses.collect { address -> save( address) };
    }
    
}
