package com.capgemini.user_service.repository;

import com.capgemini.user_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
