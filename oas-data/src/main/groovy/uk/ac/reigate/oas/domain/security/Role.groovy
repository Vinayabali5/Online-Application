package uk.ac.reigate.oas.domain.security

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

import org.springframework.security.core.GrantedAuthority

import uk.ac.reigate.oas.domain.BaseEntity

@Entity
@Table(name = "role")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "role_id"))
])
@EqualsAndHashCode(includeFields=true)
class Role extends BaseEntity implements GrantedAuthority {
    
    @Column(name = "name", nullable = false)
    String name
    
    @ManyToMany(mappedBy = "roles")
    List<User> users
    
    @Override
    public String getAuthority() {
        return name;
    }
}
