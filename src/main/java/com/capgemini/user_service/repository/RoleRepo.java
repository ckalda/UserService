package com.capgemini.user_service.repository;

import com.capgemini.user_service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
