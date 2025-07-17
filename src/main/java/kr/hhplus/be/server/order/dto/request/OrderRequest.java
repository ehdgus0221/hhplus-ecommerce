package kr.hhplus.be.server.order.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public class OrderRequest {
    public record Create(

            @Schema(description = "상품 ID", requiredMode = RequiredMode.REQUIRED)
            String productId,
            @Schema(description = "상품옵션 ID", requiredMode = RequiredMode.REQUIRED)
            String productOptionId,
            @Schema(description = "상품 수량", requiredMode = RequiredMode.REQUIRED)
            Long quantity,
            @Schema(description = "사용자 ID", requiredMode = RequiredMode.NOT_REQUIRED)
            String userId,
            @Schema(description = "쿠폰 ID", requiredMode = RequiredMode.NOT_REQUIRED)
            String couponId
    ) {
    }
}
