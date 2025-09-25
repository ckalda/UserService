package com.capgemini.user_service.service;

import com.capgemini.user_service.exceptionHandler.PatientNotFoundException;
import com.capgemini.user_service.model.Patient;
import com.capgemini.user_service.repository.PatientRepo;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public void savePatient(Patient patient){
        patientRepo.save(patient);
    }

    public Patient getPatient(Long id){
        return patientRepo.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient " + id + " Not Found"));
    }
}
