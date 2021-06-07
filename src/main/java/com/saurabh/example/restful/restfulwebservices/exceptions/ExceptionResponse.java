package com.saurabh.example.restful.restfulwebservices.exceptions;

import java.sql.Timestamp;
import java.util.Date;

public class ExceptionResponse {

    private Date errorTimeStamp;
    private String errorDetails;
    private String errorMessage;

    public ExceptionResponse(Date errorTimeStamp, String errorDetails, String errorMessage) {

        this.errorTimeStamp = errorTimeStamp;
        this.errorDetails = errorDetails;
        this.errorMessage = errorMessage;
    }

    public Date getErrorTimeStamp() {
        return errorTimeStamp;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "errorTimeStamp=" + errorTimeStamp +
                ", errorDetails='" + errorDetails + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}

