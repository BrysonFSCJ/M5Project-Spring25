package edu.fscj.cen3024c.taskmanager.repository;

import edu.fscj.cen3024c.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Additional query methods can be defined here if necessary
    User findByUsername(String username);
    User findByEmail(String email);
}
