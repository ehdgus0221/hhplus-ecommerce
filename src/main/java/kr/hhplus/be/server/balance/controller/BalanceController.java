package kr.hhplus.be.server.balance.controller;

import kr.hhplus.be.server.balance.api.BalanceApiSpec;
import kr.hhplus.be.server.balance.dto.request.BalanceRequest;
import kr.hhplus.be.server.balance.dto.response.BalanceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/balances")
public class BalanceController implements BalanceApiSpec {
    // 잔액 조회
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<BalanceResponse.Details> getDetails(@PathVariable Long id) {
        // 예시 데이터 반환
        BalanceResponse.Details response = new BalanceResponse.Details(
                id,
                BigDecimal.valueOf(10000.00)
        );
        return ResponseEntity.ok(response);
    }

    // 잔액 충전
    @PostMapping("/charge")
    @Override
    public ResponseEntity<Void> charge(@RequestBody BalanceRequest.Charge request) {
        return ResponseEntity.ok().build();
    }
}