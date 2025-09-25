package com.capgemini.user_service.controller;

import com.capgemini.user_service.model.Patient;
import com.capgemini.user_service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/get-patient/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatient(id));
    }

    @PostMapping("/create-patient")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
        return ResponseEntity.ok(patient);
    }

}
