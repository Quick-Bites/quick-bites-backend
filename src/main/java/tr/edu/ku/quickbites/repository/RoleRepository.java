package tr.edu.ku.quickbites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.ku.quickbites.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
