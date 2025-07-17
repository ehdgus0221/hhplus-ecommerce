package kr.hhplus.be.server.product.controller;

import kr.hhplus.be.server.product.api.ProductApiSpec;
import kr.hhplus.be.server.product.dto.request.ProductRequest;
import kr.hhplus.be.server.product.dto.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController implements ProductApiSpec {

    // 상품 전체 조회
    @GetMapping
    @Override
    public ResponseEntity<List<ProductResponse.Details>> getAllProducts() {
        List<ProductResponse.Details> response = List.of(
                new ProductResponse.Details(1L,"phone", BigDecimal.valueOf(100.00), "상품 1"),
                new ProductResponse.Details(2L,"food", BigDecimal.valueOf(100.00), "상품 2")
        );
        return ResponseEntity.ok(response);
    }

    // 상품 상세 조회
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ProductResponse.Details> getDetails(@PathVariable Long id) {
        // 예시 데이터 반환
        ProductResponse.Details response = new ProductResponse.Details(
                id,
                "phone",
                BigDecimal.valueOf(100.00),
                "상품 1"
        );
        return ResponseEntity.ok(response);
    }

    // 인기 상품  조회
    @GetMapping("/rank")
    @Override
    public ResponseEntity<List<ProductResponse.Details>> getPopularProducts() {
        // 예시 데이터 반환
        List<ProductResponse.Details> response = List.of(
                new ProductResponse.Details(1L,"phone", BigDecimal.valueOf(100.00), "인기상품 1"),
                new ProductResponse.Details(2L,"food", BigDecimal.valueOf(200.00), "인기상품 2"),
                new ProductResponse.Details(3L,"fan", BigDecimal.valueOf(300.00), "인기상품 3")
        );
        return ResponseEntity.ok(response);
    }


    // 상품 생성
    @PostMapping
    @Override
    public ResponseEntity<Void> create(@RequestBody ProductRequest.Create request) {
        return ResponseEntity.ok().build();
    }
}
