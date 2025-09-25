package com.capgemini.user_service.controller;

import com.capgemini.user_service.client.ScheduleClient;
import com.capgemini.user_service.dto.UserDoctorUpdateDTO;
import com.capgemini.user_service.model.AppointmentModel;
import com.capgemini.user_service.model.Doctor;
import com.capgemini.user_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private ScheduleClient scheduleClient;

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/create-doctor")
    public ResponseEntity<Doctor> savePatient(@RequestBody Doctor doctor){
        doctorService.saveDoctor(doctor);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/get-doctors")
    public ResponseEntity<List<Doctor>> getDoctors(){
        return ResponseEntity.ok(doctorService.getDoctors());
    }
    @GetMapping("/get-doctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getDoctor(id));
    }

    @PatchMapping("/update-doctor/{id}")
    public ResponseEntity<UserDoctorUpdateDTO> updateDoctor(@PathVariable Long id, @RequestBody UserDoctorUpdateDTO doctorDto){
        doctorService.updateDoctor(id, doctorDto);
        return ResponseEntity.accepted().body(doctorDto);
    }

    @GetMapping("/api/appointments/get-appointments-by-doc-id/{doctorId}")
    public ResponseEntity<List<AppointmentModel>> getAppointments(@PathVariable Long doctorId){
        List<AppointmentModel> listAppointmentModels = scheduleClient.getAppointments(doctorId);
        return ResponseEntity.ok(listAppointmentModels);
    }
}
