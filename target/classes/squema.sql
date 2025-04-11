CREATE DATABASE IF NOT EXISTS botiga;
USE botiga;

CREATE TABLE categoria (
  id_categoria BIGINT AUTO_INCREMENT PRIMARY KEY,
  desc_categoria VARCHAR(255),
  status_categoria VARCHAR(50),
  creation_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE subcategoria (
  id_subcategoria BIGINT AUTO_INCREMENT PRIMARY KEY,
  desc_subcategoria VARCHAR(255),
  status_subcategoria VARCHAR(50),
  id_categoria BIGINT,
  creation_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_subcategoria_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE products (
  product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  company VARCHAR(255),
  creation_at DATETIME(6) DEFAULT NULL,
  description VARCHAR(255),
  name VARCHAR(255),
  price FLOAT,
  units BIGINT,
  updated_at DATETIME(6) DEFAULT NULL,
  id_categoria BIGINT,
  id_subcategoria BIGINT,
  CONSTRAINT fk_product_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
  CONSTRAINT fk_product_subcategoria FOREIGN KEY (id_subcategoria) REFERENCES subcategoria(id_subcategoria)
);
