# 목차

- [상품 조회 API Flowchart](#상품-조회-api-flowchart)
- [잔액 조회 API Flowchart](#잔액-조회-api-flowchart)
- [잔액 충전 API Flowchart](#잔액-충전-api-flowchart)
- [선착순 쿠폰 발급 API Flowchart](#선착순-쿠폰-발급-api-flowchart)
- [주문 API Flowchart](#주문-api-flowchart)
- [결제 API Flowchart](#결제-api-flowchart)
- [인기 상품 조회 API (배치 기반) Flowchart](#인기-상품-조회-api-배치기반-flowchart)

### 상품 조회 API Flowchart
   mermaid

```mermaid
   flowchart TD
   A[클라이언트] -->|상품 조회 요청| B[ProductAPI]
   B -->|상품 + 옵션 목록 조회| C[ProductService]
   C -->|상품, 옵션, 재고 조회| D[ProductRepository]
   D -->|상품 목록 반환| C
   C -->|상품 DTO 반환| B
   B -->|상품 목록 응답| A
```
### 잔액 조회 API Flowchart

```mermaid
   flowchart TD
   A[클라이언트] -->|잔액 조회 요청| B[BalanceAPI]
   B -->|사용자 잔액 조회| C[BalanceService]
   C -->|SELECT 잔액| D[BalanceRepository]

   D -->|잔액 데이터 있음| C
   D -.->|잔액 데이터 없음| E[잔액 0원 반환]

   C -->|잔액 응답| B
   B -->|잔액 응답| A
```   

### 잔액 충전 API Flowchart
```mermaid
   flowchart TD
   A[클라이언트] -->|잔액 충전 요청| B[BalanceAPI]
   B -->|충전 처리 요청| C[BalanceService]

   C -->|충전 금액 0 이하?| D{예외 발생}
   D -- 예 --> E[InvalidChargeAmountException]
   E --> B
   B -->|0 이하 금액 불가 응답| A

   D -- 아니오 --> F[SELECT 잔액 FOR UPDATE]
   F --> G{잔액 존재 여부}
   G -- 없음 --> H[INSERT 초기 잔액 생성]
   G -- 있음 --> I[UPDATE 기존 잔액 + 충전]

   H --> J[충전 이력 기록]
   I --> J

   J --> C
   C -->|충전 완료| B
   B -->|충전 성공 응답| A
```  
### 선착순 쿠폰 발급 API Flowchart
```mermaid
   flowchart TD
   A[클라이언트] -->|쿠폰 발급 요청| B[CouponAPI]
   B -->|쿠폰 발급 요청| C[CouponService]
   C -->|쿠폰 유효성 확인| D[CouponRepository]

   D -->|쿠폰 만료?| E{예외}
   E -- 예 --> F[쿠폰 기간 만료 예외]
   F --> B
   B -->|쿠폰 기간 만료 응답| A

   E -- 아니오 --> G{수량 부족?}
   G -- 예 --> H[수량 부족 예외]
   H --> B
   B -->|수량 부족 응답| A

   G -- 아니오 --> I{중복 발급?}
   I -- 예 --> J[중복 발급 예외]
   J --> B
   B -->|중복 발급 응답| A

   I -- 아니오 --> K[쿠폰 발급 INSERT]
   K --> C
   C --> B
   B -->|발급 성공 응답| A
```

### 주문 API Flowchart

```mermaid
   flowchart TD
   A[클라이언트] -->|주문 요청| B[OrderAPI]
   B -->|주문 처리 요청| C[OrderService]
   C -->|재고 확인 - SELECT FOR UPDATE| D[ProductRepository]

   D -->|재고 부족?| E{예외 발생}
   E -- 예 --> F[재고 부족 예외]
   F --> B
   B -->|재고 부족 응답| A

   E -- 아니오 --> G[쿠폰 유효성 확인 - SELECT FOR UPDATE]
   G -->|쿠폰 무효?| H{예외 발생}
   H -- 예 --> I[쿠폰 무효 예외]
   I --> B
   B -->|쿠폰 무효 응답| A

   H -- 아니오 --> J[주문 INSERT, 재고 차감, 쿠폰 사용 처리]
   J --> C
   C --> B
   B -->|주문 ID 반환| A
```

### 결제 API Flowchart

```mermaid
   flowchart TD
   A[클라이언트] -->|결제 요청| B[PaymentAPI]
   B -->|결제 처리 요청| C[PaymentService]
   C -->|주문 정보 조회| D[OrderRepository]

   D -->|주문 존재?| E{예외}
   E -- 아니오 --> F[주문 없음 예외]
   F --> B
   B -->|주문 없음 응답| A

   E -- 예 --> G[총 금액 계산]
   G --> H[쿠폰 할인 적용]
   H --> I[잔액 확인 - SELECT FOR UPDATE]

   I -->|잔액 부족?| J{예외}
   J -- 예 --> K[잔액 부족 예외]
   K --> B
   B -->|잔액 부족 응답| A

   J -- 아니오 --> L[트랜잭션 시작]
   L --> M[잔액 차감, 재고 차감, 쿠폰 사용, 결제 정보 저장]
   L --> N[외부 전송 - 재시도 또는 로깅]
   M & N --> O[결제 성공]
   O --> B
   B -->|결제 성공 응답| A
```   

### 인기 상품 조회 API 배치기반 Flowchart

```mermaid
   flowchart TD
   A[BatchScheduler] -->|배치 시간마다 인기 상품 요청| B[ProductService]
   B -->|최근 3일 주문 내역 조회| C[OrderRepository]
   B -->|상품 정보 조인| D[ProductRepository]
   B -->|상위 5개 상품 캐싱 처리| B
   B -->|캐시된 인기 상품 조회| E[ProductAPI]

   F[클라이언트] -->|GET /products/rank| E
   E -->|상위 5개 상품 리스트 응답| F
```