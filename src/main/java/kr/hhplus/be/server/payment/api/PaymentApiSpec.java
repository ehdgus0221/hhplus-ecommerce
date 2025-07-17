package kr.hhplus.be.server.payment.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.payment.dto.request.PaymentRequest;
import kr.hhplus.be.server.payment.dto.response.PaymentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "결제", description = "결제 관련 API")
public interface PaymentApiSpec {

    @Operation(summary = "전체 내역 조회")
    ResponseEntity<List<PaymentResponse.Details>> getAllPayments();

    @Operation(summary = "상세 내역 조회")
    ResponseEntity<PaymentResponse.Details> getDetails(Long id);

    @Operation(summary = "생성")
    ResponseEntity<Void> create(PaymentRequest.Create request);


}
