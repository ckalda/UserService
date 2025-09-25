package com.capgemini.user_service.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "doctor_data")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    @Column(name = "gender")
    private String gender;
    @Column(name = "specializtion")
    private String specialization;
    @Column(name = "experience")
    private Long experience;
    @Column(name = "qualification")
    private String qualification;

    public Doctor() {
    }

    public Doctor(Long doctorId, LocalDate dateOfBirth, User user, String gender, String specialization, Long experience, String qualification) {
        this.doctorId = doctorId;
        this.dateOfBirth = dateOfBirth;
        this.user = user;
        this.gender = gender;
        this.specialization = specialization;
        this.experience = experience;
        this.qualification = qualification;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
