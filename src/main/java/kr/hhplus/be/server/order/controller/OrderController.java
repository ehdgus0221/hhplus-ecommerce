package kr.hhplus.be.server.order.controller;

import kr.hhplus.be.server.order.api.OrderApiSpec;
import kr.hhplus.be.server.order.dto.request.OrderRequest;
import kr.hhplus.be.server.order.dto.response.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController implements OrderApiSpec {

    // 주문 전체 조회
    @GetMapping
    @Override
    public ResponseEntity<List<OrderResponse.Details>> getAllOrders() {
        // 예시 데이터 반환
        List<OrderResponse.Details> response = List.of(
                new OrderResponse.Details(1L, 1L, 1L, "phone", 3L, "E", BigDecimal.valueOf(10000.00), LocalDateTime.of(2025, 7, 17, 23, 45, 0)),
                new OrderResponse.Details(2L, 2L, 2L, "food", 5L, "I", BigDecimal.valueOf(7000.00), LocalDateTime.of(2025, 6, 18, 23, 45, 0))

        );
        return ResponseEntity.ok(response);
    }

    // 주문 상세 조회
    @GetMapping("/orders/{id}")
    @Override
    public ResponseEntity<OrderResponse.Details> getDetails(@PathVariable Long id) {
        // 예시 데이터 반환
        OrderResponse.Details response = new OrderResponse.Details(
                id, 1L, 1L, "phone", 3L, "E", BigDecimal.valueOf(10000.00),
                LocalDateTime.of(2025, 7, 17, 23, 45, 0)
        );
        return ResponseEntity.ok(response);
    }


    // 주문 요청
    @PostMapping
    @Override
    public ResponseEntity<Void> create(@RequestBody OrderRequest.Create request) {
        return ResponseEntity.ok().build();
    }
}
