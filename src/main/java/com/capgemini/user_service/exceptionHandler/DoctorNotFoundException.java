package com.capgemini.user_service.exceptionHandler;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(String msg){ super(msg); }
}
