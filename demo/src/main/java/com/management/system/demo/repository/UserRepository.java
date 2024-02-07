package com.management.system.demo.repository;

import com.management.system.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // all CRUD database methods

}
