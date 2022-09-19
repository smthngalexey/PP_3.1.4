package kulish.webapp.services;


import kulish.webapp.models.Role;
import kulish.webapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }


    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByRolename(name);
    }

    @Override
    public Set<Role> getRolesByName(Set<Role> roles) {
        Set<Role> userRoles = new HashSet<>();
        for (Role role : roles) {
            userRoles.add(getRoleByName(role.getRolename()));
        }
        return userRoles;
    }

    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(roleRepository.findAll());
    }
}
