CREATE TABLE orders
(
    id BIGINT NOT NULL
    AUTO_INCREMENT,

    order_number VARCHAR
    (255) NOT NULL,
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
    (id)
) ENGINE=InnoDB;