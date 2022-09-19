package kulish.webapp.services;

import kulish.webapp.models.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RoleService {

    void addRole(Role role);


    Role getRoleByName(String name);

    Set<Role> getRolesByName(Set<Role> roles);


    Set<Role> getAllRoles();
}
