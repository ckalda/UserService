package com.capgemini.user_service.controller;


import com.capgemini.user_service.model.AppointmentModel;
import com.capgemini.user_service.service.RemoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final RemoteService remoteService;

    public TestController(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    @GetMapping("/test-circuit")
    public String testCircuitBreaker() {
        return remoteService.callExternalService();
    }
}

