package com.management.system.demo.repository;

import com.management.system.demo.model.Role;
import com.management.system.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {

//    Role findByIdWithUsers(Long id, List<User> users);

}
