package com.example.taskmanager.Repository;

import com.example.taskmanager.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteUserById (Long id);
    Optional<User> getUserById(Long id);

}
