package kr.hhplus.be.server.coupon.controller;

import kr.hhplus.be.server.coupon.api.CouponApiSpec;
import kr.hhplus.be.server.coupon.dto.request.CouponRequest;
import kr.hhplus.be.server.coupon.dto.response.CouponResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/coupons")
public class CouponController implements CouponApiSpec {
    // 쿠폰 조회
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CouponResponse.Details> getDetails(@PathVariable Long id) {
        // 예시 데이터 반환
        CouponResponse.Details response = new CouponResponse.Details(
                id,
                "쿠폰 1",
                30L,
                "2025-07-18"
        );
        return ResponseEntity.ok(response);
    }

    // 선착순 쿠폰 발급
    @PostMapping("/issue")
    @Override
    public ResponseEntity<Void> issue(@RequestBody CouponRequest.Charge request) {
        return ResponseEntity.ok().build();
    }
}