package com.erocha.person.commons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Response {

    private int status;
    private String code;
    private String message;

    public Response(HttpStatus httpStatus, String code, String message) {
        this.status = httpStatus.value();
        this.code = code;
        this.message = message;
    }
}
