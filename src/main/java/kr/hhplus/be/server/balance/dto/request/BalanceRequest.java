package kr.hhplus.be.server.balance.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.math.BigDecimal;

public class BalanceRequest {
    public record Charge(

            @Schema(description = "사용자 ID", requiredMode = RequiredMode.REQUIRED)
            String userId,
            @Schema(description = "충전 금액", requiredMode = RequiredMode.REQUIRED)
            BigDecimal amount
    ) {
    }
}
