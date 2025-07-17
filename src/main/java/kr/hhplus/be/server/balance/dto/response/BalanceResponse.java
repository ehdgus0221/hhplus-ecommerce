package kr.hhplus.be.server.balance.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;


public class BalanceResponse {
    public record Details(
            @Schema(description = "잔액 ID")
            Long id,
            @Schema(description = "잔액")
            BigDecimal balance
            ) {
    }
}