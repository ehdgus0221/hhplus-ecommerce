
```mermaid
erDiagram
    USER ||--o{ ORDER : has
    USER ||--o{ POINT_HISTORY : owns
    USER ||--o{ USER_COUPON : receives

    USER {
        BIGINT id PK
        VARCHAR name
        VARCHAR email
        INT point
        DATETIME created_at
    }

    POINT_HISTORY {
        BIGINT id PK
        BIGINT user_id FK
        INT amount
        STRING type
        VARCHAR description
        DATETIME created_at
    }

    ORDER ||--o{ ORDER_ITEM : includes
    ORDER ||--|| PAYMENT : has
    ORDER }o--|| USER_COUPON : uses

    ORDER {
        BIGINT id PK
        BIGINT user_id FK
        BIGINT user_coupon_id FK
        INT total_price
        STRING status
        DATETIME ordered_at
    }

    ORDER_ITEM {
        BIGINT id PK
        BIGINT order_id FK
        BIGINT product_option_id FK
        INT quantity
        INT unit_price
    }

    PRODUCT ||--o{ PRODUCT_OPTION : has

    PRODUCT {
        BIGINT id PK
        VARCHAR name
        INT base_price
        TEXT description
        BOOLEAN is_active
    }

    PRODUCT_OPTION {
        BIGINT id PK
        BIGINT product_id FK
        VARCHAR option_name
        INT price
        INT quantity
        BOOLEAN is_active
    }

    COUPON ||--o{ USER_COUPON : issued_to

    COUPON {
        BIGINT id PK
        VARCHAR name
        INT discount_rate
        INT quantity
        DATE expired_at
    }

    USER_COUPON {
        BIGINT id PK
        BIGINT user_id FK
        BIGINT coupon_id FK
        BOOLEAN used
        DATETIME issued_at
    }

    PAYMENT {
        BIGINT id PK
        BIGINT order_id FK
        INT amount
        DATETIME paid_at
    }

```

### 관계 표현
| 관계 표현   | 관계 형태    | 설명 (관계의 의미)                 |
|-------------|--------------|----------------------------------|
| has         | 1:N 또는 1:1 | ~을 가진다 (소유 또는 포함 의미)   |
| owns        | 1:N          | ~을 소유한다 (소유권 또는 관리 의미)|
| receives    | 1:N          | ~을 받는다 (수신, 지급받음 의미)   |
| includes    | 1:N          | ~을 포함한다 (포함 관계)           |
| uses        | 0..1:1       | ~을 사용한다 (선택적 사용)         |
| issued_to   | 1:N          | ~에게 발급된다 (발급 대상 관계)     |

### 인기 상품 데이터는 redis에 저장하여 관리한다.