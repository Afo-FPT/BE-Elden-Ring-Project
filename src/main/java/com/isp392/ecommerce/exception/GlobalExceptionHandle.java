package com.isp392.ecommerce.exception;

import com.isp392.ecommerce.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception){
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception){
        String enumkey = exception.getFieldError().getDefaultMessage();


        ErrorCode errorCode = ErrorCode.INVALIDKEY;
        try {
            errorCode = ErrorCode.valueOf(enumkey);
        }catch (IllegalArgumentException e){

        }
        ApiResponse apiResponse= new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage((errorCode.getMessage()));
        return ResponseEntity.badRequest().body(apiResponse);
    }

/*    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlingValidation(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        e.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, List<String>> results = new HashMap<>();
        results.put("List of Validation Errors", errors);

        return new ResponseEntity<>(results, HttpStatus.BAD_REQUEST);
    }*/
}
