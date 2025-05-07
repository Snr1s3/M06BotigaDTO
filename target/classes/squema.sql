CREATE DATABASE IF NOT EXISTS botiga;
USE botiga;

CREATE TABLE categoria (
  id_categoria BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre_categoria VARCHAR(255),
  desc_categoria VARCHAR(255),
  status_categoria VARCHAR(50),
  creation_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE subcategoria (
  id_subcategoria BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre_subcategoria VARCHAR(255),
  desc_subcategoria VARCHAR(255),
  status_subcategoria VARCHAR(50),
  id_categoria BIGINT,
  creation_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_subcategoria_categoria FOREIGN KEY (nombre_categoria) REFERENCES categoria(nombre_categoria)
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
  CONSTRAINT fk_product_categoria FOREIGN KEY (product_categoria) REFERENCES categoria(product_categoria),
  CONSTRAINT fk_product_subcategoria FOREIGN KEY (product_subcategoria) REFERENCES subcategoria(product_subcategoria)
);

-- Insertar categorías
INSERT INTO categoria (desc_categoria, status_categoria) 
VALUES ('Electrónica', 'Activa');

INSERT INTO categoria (desc_categoria, status_categoria) 
VALUES ('Hogar', 'Activa');

-- Insertar subcategorías
INSERT INTO subcategoria (desc_subcategoria, status_subcategoria, id_categoria) 
VALUES ('Teléfonos', 'Activa', 1);

INSERT INTO subcategoria (desc_subcategoria, status_subcategoria, id_categoria) 
VALUES ('Electrodomésticos', 'Activa', 2);

-- Insertar productos
INSERT INTO products (company, description, name, price, units, id_categoria, id_subcategoria) 
VALUES ('Samsung', 'Teléfono inteligente Galaxy S21', 'Galaxy S21', 799.99, 50, 1, 1);

INSERT INTO products (company, description, name, price, units, id_categoria, id_subcategoria) 
VALUES ('LG', 'Refrigerador de alta capacidad', 'LG Fridge', 1200.00, 20, 2, 2);
