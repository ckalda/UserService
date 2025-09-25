package com.capgemini.user_service.service;

import com.capgemini.user_service.dto.UserDoctorUpdateDTO;
import com.capgemini.user_service.exceptionHandler.DoctorNotFoundException;
import com.capgemini.user_service.exceptionHandler.UserNotFoundException;
import com.capgemini.user_service.model.Doctor;
import com.capgemini.user_service.model.User;
import com.capgemini.user_service.repository.DoctorRepo;
import com.capgemini.user_service.repository.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepo doctorRepo;
    private final UserRepo userRepo;

    public DoctorService(DoctorRepo doctorRepo, UserRepo userRepo) {
        this.doctorRepo = doctorRepo;
        this.userRepo = userRepo;
    }

    public void saveDoctor(Doctor doctor){
        doctorRepo.save(doctor);
    }

    public List<Doctor> getDoctors(){ return doctorRepo.findAll(); };

    public Doctor getDoctor(Long id){
        return doctorRepo.findById(id).orElseThrow(() -> new DoctorNotFoundException("Doctor " + id + " is not found"));
    };

    public UserDoctorUpdateDTO updateDoctor(Long id, UserDoctorUpdateDTO doctorDto){
        Doctor doctor = doctorRepo.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found"));

        User user = userRepo.findById(doctor.getUser().getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        // Update User fields
        if (doctorDto.getExperience() != null) doctor.setExperience(doctorDto.getExperience());
        if (doctorDto.getStatus() != null) user.setStatus(doctorDto.getStatus());

        userRepo.save(user);
        doctorRepo.save(doctor);
        return doctorDto;
    }
}
