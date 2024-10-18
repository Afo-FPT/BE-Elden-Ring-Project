//package com.isp392.ecommerce.exception;
//
//import com.isp392.ecommerce.dto.response.ApiResponse;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandle {
//    @ExceptionHandler(value = Exception.class)
//    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception){
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
//        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
//        return ResponseEntity.badRequest().body(apiResponse);
//    }
//
//    @ExceptionHandler(value = AppException.class)
//    ResponseEntity<ApiResponse> handlingAppException(AppException exception){
//        ErrorCode errorCode = exception.getErrorCode();
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setCode(errorCode.getCode());
//        apiResponse.setMessage(errorCode.getMessage());
//        return ResponseEntity.badRequest().body(apiResponse);
//    }
//
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception){
//        String enumkey = exception.getFieldError().getDefaultMessage();
//
//
//        ErrorCode errorCode = ErrorCode.INVALID_MESSAGE_KEY;
//        try {
//            errorCode = ErrorCode.valueOf(enumkey);
//        }catch (IllegalArgumentException e){
//
//        }
//        ApiResponse apiResponse= new ApiResponse();
//        apiResponse.setCode(errorCode.getCode());
//        apiResponse.setMessage((errorCode.getMessage()));
//        return ResponseEntity.badRequest().body(apiResponse);
//    }
//}
