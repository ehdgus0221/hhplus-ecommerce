package kr.hhplus.be.server.product.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.product.dto.request.ProductRequest;
import kr.hhplus.be.server.product.dto.response.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "상품", description = "상품 관련 API")
public interface ProductApiSpec {

    @Operation(summary = "전체 조회")
    ResponseEntity<List<ProductResponse.Details>> getAllProducts();

    @Operation(summary = "상세 조회")
    ResponseEntity<ProductResponse.Details> getDetails(Long id);

    @Operation(summary = "인기상품 조회")
    ResponseEntity<List<ProductResponse.Details>> getPopularProducts();

    @Operation(summary = "생성")
    ResponseEntity<Void> create(ProductRequest.Create request);


}
