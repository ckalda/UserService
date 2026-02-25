package com.capgemini.user_service.repository;

import com.capgemini.user_service.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"role"})
    Page<User> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"role"})
    Optional<User> findById(Long id);
}
