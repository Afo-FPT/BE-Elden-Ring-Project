package com.isp392.ecommerce.controller;

import com.isp392.ecommerce.dto.request.HandleRefundRequestRequest;
import com.isp392.ecommerce.dto.request.RefundRequestRequest;
import com.isp392.ecommerce.dto.response.ApiResponse;
import com.isp392.ecommerce.dto.response.RefundRequestResponse;
import com.isp392.ecommerce.enums.Status;
import com.isp392.ecommerce.service.RefundRequestService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refund")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RefundRequestController {
    RefundRequestService refundRequestService;

    @PostMapping("/create")
    ResponseEntity<ApiResponse<RefundRequestResponse>> makeARefund(@RequestBody RefundRequestRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<RefundRequestResponse>builder()
                        .message("Make a refund request successfully!")
                        .result(refundRequestService.makeARefund(request))
                        .build());
    }

    @PostMapping("/approved")
    ApiResponse<RefundRequestResponse> approveRefund(@RequestBody HandleRefundRequestRequest request) {
        return ApiResponse.<RefundRequestResponse>builder()
                .message("Approve a refund request successfully!")
                .result(refundRequestService.handleRefund(request, Status.APPROVED.name()))
                .build();
    }

    @PostMapping("/rejected")
    ApiResponse<RefundRequestResponse> rejectRefund(@RequestBody HandleRefundRequestRequest request) {
        return ApiResponse.<RefundRequestResponse>builder()
                .message("Reject a refund request successfully!")
                .result(refundRequestService.handleRefund(request, Status.REJECTED.name()))
                .build();
    }

    @GetMapping("/get-all-refund-requests")
    ApiResponse<List<RefundRequestResponse>> getAllRefundRequests() {
        return ApiResponse.<List<RefundRequestResponse>>builder()
                .message("Get all refund requests Successfully!")
                .result(refundRequestService.getAllRefundRequests())
                .build();
    }

    //    @PostAuthorize("hasRole('ADMIN') or returnObject.")
    @GetMapping("/{refundRequestId}")
    ApiResponse<RefundRequestResponse> getRefundRequest(@PathVariable String refundRequestId) {
        return ApiResponse.<RefundRequestResponse>builder()
                .message("Get refund request Successfully!")
                .result(refundRequestService.getRefundRequestById(refundRequestId))
                .build();
    }

}