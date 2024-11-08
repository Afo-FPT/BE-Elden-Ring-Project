package com.isp392.ecommerce.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateDeliveryStatusRequest {
    String orderId;
    String status;
}
