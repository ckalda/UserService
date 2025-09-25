package com.capgemini.user_service.service;

import com.capgemini.user_service.client.ScheduleClient;
import com.capgemini.user_service.model.AppointmentModel;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class RemoteService {

    @Autowired
    private ScheduleClient scheduleClient;

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallback")
    public String callExternalService() {
        // Simulate remote call

        if(ResponseEntity.ok(scheduleClient.getAppointments(Long.valueOf(1))).getStatusCode().is2xxSuccessful())
            return "Success";
        else
            throw new RuntimeException("Failed call");

    }

    public String fallback(Throwable t) {
        return "Fallback response: Service is temporarily unavailable.";
    }

}
