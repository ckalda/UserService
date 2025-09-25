package com.capgemini.user_service.client;

import com.capgemini.user_service.model.AppointmentModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "schedule-service", url = "http://localhost:8082/")
public interface ScheduleClient {

    @GetMapping("/api/appointments/get-appointments-by-doc-id/{doctorId}")
    public List<AppointmentModel> getAppointments(@PathVariable Long doctorId);
}
