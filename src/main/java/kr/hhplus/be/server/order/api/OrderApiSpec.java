package kr.hhplus.be.server.order.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.order.dto.request.OrderRequest;
import kr.hhplus.be.server.order.dto.response.OrderResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "주문", description = "주문 관련 API")
public interface OrderApiSpec {

    @Operation(summary = "전체 조회")
    ResponseEntity<List<OrderResponse.Details>> getAllOrders();

    @Operation(summary = "상세 조회")
    ResponseEntity<OrderResponse.Details> getDetails(Long id);

    @Operation(summary = "생성")
    ResponseEntity<Void> create(OrderRequest.Create request);


}
