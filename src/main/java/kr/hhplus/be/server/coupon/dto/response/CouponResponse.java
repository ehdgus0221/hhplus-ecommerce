package kr.hhplus.be.server.coupon.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.math.BigDecimal;


public class CouponResponse {
    public record Details(
            @Schema(description = "ID")
            Long id,
            @Schema(description = "이름")
            String name,
            @Schema(description = "할인율")
            Long discount,
            @Schema(description = "만료일")
            String expired
            ) {
    }
}