package kr.hhplus.be.server.order.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderResponse {
    public record Details(
            @Schema(description = "주문 ID")
            Long id,
            @Schema(description = "상품 ID")
            Long productId,
            @Schema(description = "상품 옵션 ID")
            Long productOptionId,
            @Schema(description = "상품 이름")
            String name,
            @Schema(description = "상품 수량")
            Long quantity,
            @Schema(description = "주문 상태")
            String status,
            @Schema(description = "결제 금액")
            BigDecimal price,
            @Schema(description = "주문 일자")
            LocalDateTime orderDate
    ) {
    }
}