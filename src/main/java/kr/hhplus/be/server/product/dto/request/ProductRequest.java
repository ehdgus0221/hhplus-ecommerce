package kr.hhplus.be.server.product.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.math.BigDecimal;

public class ProductRequest{
    public record Create(

            @Schema(description = "상품 이름", requiredMode = RequiredMode.REQUIRED)
            String name,
            @Schema(description = "상품 가격", requiredMode = RequiredMode.REQUIRED)
            BigDecimal price,
            @Schema(description = "상품 설명", requiredMode = RequiredMode.NOT_REQUIRED)
            String description
    ) {
    }
}
