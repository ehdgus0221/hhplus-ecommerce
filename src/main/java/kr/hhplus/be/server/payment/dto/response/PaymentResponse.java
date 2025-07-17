package kr.hhplus.be.server.payment.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponse {
    public record Details(
            @Schema(description = "ID")
            Long id,
            @Schema(description = "주문 ID")
            Long OrderId,
            @Schema(description = "사용자 ID")
            Long userId,
            @Schema(description = "결제 금액")
            BigDecimal price,
            @Schema(description = "결제 일자")
            LocalDateTime date
    ) {
    }
}