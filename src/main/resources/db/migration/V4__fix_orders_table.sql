CREATE TABLE orders
(
    id CHAR(36) NOT NULL,

    order_number INT NOT NULL
    AUTO_INCREMENT,

    title VARCHAR
    (255) NOT NULL,
    description VARCHAR
    (255) NOT NULL,

    status VARCHAR
    (50) NOT NULL,

    created_at DATETIME NOT NULL,
    updated_at DATETIME NULL,
    deleted_at DATETIME NULL,

    PRIMARY KEY
    (id),
    UNIQUE KEY uk_orders_order_number
    (order_number)
) ENGINE=InnoDB;