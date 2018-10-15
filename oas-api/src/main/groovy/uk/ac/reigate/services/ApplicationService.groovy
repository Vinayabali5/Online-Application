package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.exceptions.UserApplicationExistsException
import uk.ac.reigate.exceptions.UserNotSuppliedException
import uk.ac.reigate.oas.domain.Application
import uk.ac.reigate.oas.domain.security.User
import uk.ac.reigate.oas.repositories.ApplicationRepository
import uk.ac.reigate.services.security.UserService


@Service
class ApplicationService{
    
    @Autowired
    ApplicationRepository applicationRepository
    
    @Autowired
    UserService userService
    
    /**
     * Default NoArgs constructor
     */
    ApplicationService() {}
    
    /**
     * Autowired Constructor
     *
     * @param applicationRepository
     */
    ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }
    
    /**
     * Find an individual application using the applications ID fields
     *
     * @param id the ID fields to search for
     * @return the Application object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    Application findById(Integer id) {
        return applicationRepository.findById(id).orElse(null);
    }
    
    /**
     * Find all applications
     *
     * @return a SearchResult set with the list of Applications
     */
    @Transactional(readOnly = true)
    List<Application> findAll() {
        return applicationRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Application object in the database
     *
     * @param application the new Application object to be saved
     * @return the saved version of the Application object
     */
    @Transactional
    public Application save(Application application) {
        return applicationRepository.save(application)
    }
    
    /**
     * Saves a list of Application objects to the database
     *
     * @param applications a list of Applications to be saved to the database
     * @return the list of save Application objects
     */
    @Transactional
    public List<Application> saveApplications(List<Application> applications) {
        return applications.collect { application -> save( application ) };
    }
    
    /**
     * This method is used to create a new application for a given user object. The method will take a User object if 
     * the User does not already have an application then a new one will be created. 
     *  
     * @param user A User object to create an application for
     * @return A new application for the given User
     */
    Application createNewApplication(User user) throws UserNotSuppliedException, UserApplicationExistsException {
        if (user == null) {
            throw new UserNotSuppliedException()
        }
        if (user.application != null) {
            throw new UserApplicationExistsException()
        }
        Application application = new Application()
        application.legalFirstName = user.legalFirstName
        application.legalSurname = user.legalSurname
        application.dateOfBirth = user.dob
        application.email = user.username
        application.user = user
        application.school = user.school
        return save(application)
    }
}
