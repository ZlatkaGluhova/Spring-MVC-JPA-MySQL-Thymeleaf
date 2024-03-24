package com.management.system.demo.repository;

import com.management.system.demo.model.Role;
import com.management.system.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRolesIn(List<Role> roles);

    // all CRUD database methods

}
