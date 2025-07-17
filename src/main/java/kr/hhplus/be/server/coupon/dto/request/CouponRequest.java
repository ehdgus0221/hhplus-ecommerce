package kr.hhplus.be.server.coupon.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.math.BigDecimal;

public class CouponRequest {
    public record Charge(

            @Schema(description = "쿠폰 ID", requiredMode = RequiredMode.REQUIRED)
            BigDecimal amount,
            @Schema(description = "사용자 ID", requiredMode = RequiredMode.REQUIRED)
            String userId

    ) {
    }
}
