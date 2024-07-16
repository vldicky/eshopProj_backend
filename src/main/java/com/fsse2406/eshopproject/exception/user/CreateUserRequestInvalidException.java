package com.fsse2406.eshopproject.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreateUserRequestInvalidException extends RuntimeException {

}
