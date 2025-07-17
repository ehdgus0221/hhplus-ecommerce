package kr.hhplus.be.server.balance.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.balance.dto.request.BalanceRequest;
import kr.hhplus.be.server.balance.dto.response.BalanceResponse;
import org.springframework.http.ResponseEntity;

@Tag(name = "잔액", description = "잔액 관련 API")
public interface BalanceApiSpec {

    @Operation(summary = "조회")
    ResponseEntity<BalanceResponse.Details> getDetails(Long id);

    @Operation(summary = "충전")
    ResponseEntity<Void> charge(BalanceRequest.Charge request);
}
