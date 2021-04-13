package com.tripaneer.catalog.exceptionhandlers;

import com.tripaneer.catalog.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.SocketTimeoutException;

import static com.tripaneer.catalog.constants.CatalogServiceDefaultExceptionCodes.INTERNAL_SERVER;


@ControllerAdvice
public class CatalogExceptionHandlers {

    @ExceptionHandler(value = SocketTimeoutException.class)
    public ResponseEntity<BaseResponse> handleSocketTimeoutException(SocketTimeoutException ex) {
        BaseResponse response = new BaseResponse(INTERNAL_SERVER.errCode(), INTERNAL_SERVER.errMsg());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
