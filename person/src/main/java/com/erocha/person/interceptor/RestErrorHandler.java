package com.erocha.person.interceptor;

import com.erocha.person.commons.model.Response;
import com.erocha.person.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;


@ControllerAdvice
@Slf4j
public class RestErrorHandler extends DefaultHandlerExceptionResolver {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(value = UNPROCESSABLE_ENTITY)
    public Response businessException(BusinessException ex,final HttpServletRequest request){
        return new Response(UNPROCESSABLE_ENTITY,ex.getCode(),ex.getMessage());
    }
}
