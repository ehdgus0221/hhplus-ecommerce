erDiagram
USER ||--o{ ORDER : has
USER ||--o{ POINT_HISTORY : owns
USER ||--o{ USER_COUPON : receives

    USER {
        BIGINT id PK
        VARCHAR name
        VARCHAR email
        INT point_balance
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
        INT extra_price
        INT stock_quantity
        BOOLEAN is_active
    }

    COUPON ||--o{ USER_COUPON : issued_to

    COUPON {
        BIGINT id PK
        VARCHAR name
        INT discount_amount
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
        VARCHAR payment_method
    }

    STATISTICS {
        BIGINT product_id PK FK
        INT sold_quantity
        DATE calculated_date
    }
