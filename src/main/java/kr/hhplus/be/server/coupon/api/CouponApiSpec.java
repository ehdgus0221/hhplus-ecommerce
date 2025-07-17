package kr.hhplus.be.server.coupon.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.coupon.dto.request.CouponRequest;
import kr.hhplus.be.server.coupon.dto.response.CouponResponse;
import org.springframework.http.ResponseEntity;

@Tag(name = "쿠폰", description = "쿠폰 관련 API")
public interface CouponApiSpec {

    @Operation(summary = "조회")
    ResponseEntity<CouponResponse.Details> getDetails(Long id);

    @Operation(summary = "선착순 쿠폰")
    ResponseEntity<Void> issue(CouponRequest.Charge request);
}
