package tr.edu.ku.quickbites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.ku.quickbites.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
