package com.capgemini.user_service.dto;

public class UserDoctorUpdateDTO {
    private String status;
    private Long experience;

    public UserDoctorUpdateDTO(String status, Long experience) {
        this.status = status;
        this.experience = experience;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }
}
