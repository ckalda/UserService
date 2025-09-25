package com.capgemini.user_service.exceptionHandler;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String msg){
        super(msg);
    }
}
