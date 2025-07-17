package kr.hhplus.be.server.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public class ProductResponse {
    public record Details(
            @Schema(description = "상품 ID")
            Long id,
            @Schema(description = "상품 이름")
            String name,
            @Schema(description = "상품 가격")
            BigDecimal price,
            @Schema(description = "상품 설명")
            String description
    ) {
    }
}