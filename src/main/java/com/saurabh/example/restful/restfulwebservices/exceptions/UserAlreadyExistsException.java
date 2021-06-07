package com.saurabh.example.restful.restfulwebservices.exceptions;

import com.saurabh.example.restful.restfulwebservices.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UserAlreadyExistsException extends Throwable {
    public UserAlreadyExistsException(String s, User user) {
        super(s);
    }
}
