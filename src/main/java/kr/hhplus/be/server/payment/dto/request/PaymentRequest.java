package kr.hhplus.be.server.payment.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public class PaymentRequest {
    public record Create(

            @Schema(description = "ID", requiredMode = RequiredMode.REQUIRED)
            String id,
            @Schema(description = "주문 ID", requiredMode = RequiredMode.REQUIRED)
            String orderId
    ) {
    }
}
