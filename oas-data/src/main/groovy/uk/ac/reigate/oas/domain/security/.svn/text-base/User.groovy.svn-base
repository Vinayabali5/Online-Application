package uk.ac.reigate.oas.domain.security

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ForeignKey
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToOne
import javax.persistence.Table

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

import uk.ac.reigate.oas.domain.Application
import uk.ac.reigate.oas.domain.BaseEntityIdentity
import uk.ac.reigate.oas.domain.lookup.School

@Entity
@Table(name = "user")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
])
@EqualsAndHashCode(includeFields=true)
class User extends BaseEntityIdentity implements UserDetails {
    
    @Column(name = "username")
    String username
    
    @Column(name = "legal_first_name")
    String legalFirstName
    
    @Column(name = "legal_surname")
    String legalSurname
    
    @Column(name = "dob")
    Date dob
    
    @OneToOne
    @JoinColumn(name = "school_id", foreignKey = @ForeignKey(name = "FK_user__school"))
    School school
    
    @Column(name = "password")
    String password
    
    @Column(name = "enabled")
    boolean enabled
    
    @Column(name = "expired")
    boolean expired
    
    @Column(name = "locked")
    boolean locked
    
    @Column(name = "confirmation_code")
    String confirmationCode
    
    @OneToOne(fetch = FetchType.EAGER, mappedBy = 'user')
    Application application
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "FK_user_role__user")),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id", foreignKey = @ForeignKey(name = "FK_user_role__role"))
    )
    List<Role> roles
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public String getUsername() {
        return username;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return !expired;
    }
    
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
