-- =============================================================================
-- BASE DE DATOS EMPRESARIAL: PLAZA MEGACENTÍMETROS S.A.C.
-- Curso: Integración de Aplicaciones (SRM) - ISIL
-- Evaluación: PA4 - Caso B: Plaza Megacentímetros S.A.C.
-- =============================================================================

DROP DATABASE IF EXISTS plaza_megacentimetros;
CREATE DATABASE plaza_megacentimetros CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE plaza_megacentimetros;

-- 1. TIPODOCUMENTO (Cliente / Personal)
CREATE TABLE tipodocumento (
    codtipd INT AUTO_INCREMENT PRIMARY KEY,
    nomtipd VARCHAR(50) NOT NULL UNIQUE,
    esttipd BIT NOT NULL DEFAULT 1
) ENGINE=InnoDB;

-- 2. CATEGORIA (Productos)
CREATE TABLE categoria (
    codcat INT AUTO_INCREMENT PRIMARY KEY,
    nomcat VARCHAR(50) NOT NULL UNIQUE,
    descat VARCHAR(255) NULL,
    estcat BIT NOT NULL DEFAULT 1
) ENGINE=InnoDB;

-- 3. PROVEEDOR (Compras)
CREATE TABLE proveedor (
    codprv INT AUTO_INCREMENT PRIMARY KEY,
    razprv VARCHAR(100) NOT NULL,
    rucprv VARCHAR(11) NOT NULL UNIQUE,
    telprv VARCHAR(15) NULL,
    corprv VARCHAR(100) NOT NULL UNIQUE,
    dirprv VARCHAR(150) NULL,
    estprv BIT NOT NULL DEFAULT 1
) ENGINE=InnoDB;

-- 4. METODOPAGO (Pagos)
CREATE TABLE metodopago (
    codmetp INT AUTO_INCREMENT PRIMARY KEY,
    nommetp VARCHAR(40) NOT NULL UNIQUE,
    estmetp BIT NOT NULL DEFAULT 1
) ENGINE=InnoDB;

-- 5. SUCURSAL (Logística)
CREATE TABLE sucursal (
    codsuc INT AUTO_INCREMENT PRIMARY KEY,
    nomsuc VARCHAR(100) NOT NULL,
    dirsuc VARCHAR(200) NOT NULL,
    telsuc VARCHAR(15) NULL,
    estsuc BIT NOT NULL DEFAULT 1
) ENGINE=InnoDB;

-- 6. ALMACEN (Logística)
CREATE TABLE almacen (
    codalm INT AUTO_INCREMENT PRIMARY KEY,
    nomalm VARCHAR(100) NOT NULL,
    ubialm VARCHAR(200) NOT NULL,
    codsuc INT NOT NULL,
    estalm BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_alm_sucursal FOREIGN KEY (codsuc) REFERENCES sucursal(codsuc)
) ENGINE=InnoDB;

-- 7. CLIENTE (Clientes)
CREATE TABLE cliente (
    codcli INT AUTO_INCREMENT PRIMARY KEY,
    nomcli VARCHAR(60) NOT NULL,
    apecli VARCHAR(60) NOT NULL,
    numdoc VARCHAR(15) NOT NULL UNIQUE,
    codtipd INT NOT NULL,
    telcli VARCHAR(15) NULL,
    corcli VARCHAR(100) NOT NULL UNIQUE,
    dircli VARCHAR(150) NULL,
    estcli BIT NOT NULL DEFAULT 1,
    crecli TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_cli_tipodocumento FOREIGN KEY (codtipd) REFERENCES tipodocumento(codtipd)
) ENGINE=InnoDB;

-- 8. PRODUCTO (Inventario)
CREATE TABLE producto (
    codpro INT AUTO_INCREMENT PRIMARY KEY,
    nompro VARCHAR(100) NOT NULL,
    despro VARCHAR(255) NULL,
    prepro DECIMAL(10,2) NOT NULL,
    stopro INT NOT NULL DEFAULT 0,
    codcat INT NOT NULL,
    codprv INT NOT NULL,
    estpro BIT NOT NULL DEFAULT 1,
    crepro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_pro_categoria FOREIGN KEY (codcat) REFERENCES categoria(codcat),
    CONSTRAINT fk_pro_proveedor FOREIGN KEY (codprv) REFERENCES proveedor(codprv)
) ENGINE=InnoDB;

-- 9. INVENTARIO (Logística)
CREATE TABLE inventario (
    codinv INT AUTO_INCREMENT PRIMARY KEY,
    codpro INT NOT NULL,
    codalm INT NOT NULL,
    caninv INT NOT NULL DEFAULT 0,
    estinv BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_inv_producto FOREIGN KEY (codpro) REFERENCES producto(codpro),
    CONSTRAINT fk_inv_almacen FOREIGN KEY (codalm) REFERENCES almacen(codalm)
) ENGINE=InnoDB;

-- 10. EMPLEADO (Personal)
CREATE TABLE empleado (
    codemp INT AUTO_INCREMENT PRIMARY KEY,
    numdoc VARCHAR(15) NOT NULL UNIQUE,
    nomemp VARCHAR(100) NOT NULL,
    apeemp VARCHAR(100) NOT NULL,
    caremp VARCHAR(50) NOT NULL,
    codsuc INT NOT NULL,
    estemp BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_emp_sucursal FOREIGN KEY (codsuc) REFERENCES sucursal(codsuc)
) ENGINE=InnoDB;

-- 11. USUARIO (Personal / Seguridad)
CREATE TABLE usuario (
    codusu INT AUTO_INCREMENT PRIMARY KEY,
    nomusu VARCHAR(50) NOT NULL UNIQUE,
    clausu VARCHAR(100) NOT NULL,
    codemp INT NOT NULL,
    rolusu VARCHAR(30) NOT NULL DEFAULT 'OPERADOR',
    estusu BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_usu_empleado FOREIGN KEY (codemp) REFERENCES empleado(codemp)
) ENGINE=InnoDB;

-- 12. AUDITORIA (Personal / Seguridad)
CREATE TABLE auditoria (
    codaud INT AUTO_INCREMENT PRIMARY KEY,
    codusu INT NOT NULL,
    accaud VARCHAR(200) NOT NULL,
    fecaud DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estaud BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_aud_usuario FOREIGN KEY (codusu) REFERENCES usuario(codusu)
) ENGINE=InnoDB;

-- 13. PEDIDO (Ventas)
CREATE TABLE pedido (
    codped INT AUTO_INCREMENT PRIMARY KEY,
    numped VARCHAR(20) NOT NULL UNIQUE,
    fecped DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    codcli INT NOT NULL,
    codpro INT NOT NULL,
    codmetp INT NOT NULL,
    canped INT NOT NULL,
    preuni DECIMAL(10,2) NOT NULL,
    subtot DECIMAL(10,2) NOT NULL,
    igv DECIMAL(10,2) NOT NULL,
    totped DECIMAL(10,2) NOT NULL,
    obsped VARCHAR(255) NULL,
    estped BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_ped_cliente FOREIGN KEY (codcli) REFERENCES cliente(codcli),
    CONSTRAINT fk_ped_producto FOREIGN KEY (codpro) REFERENCES producto(codpro),
    CONSTRAINT fk_ped_metodopago FOREIGN KEY (codmetp) REFERENCES metodopago(codmetp)
) ENGINE=InnoDB;

-- 14. VENTA (Ventas)
CREATE TABLE venta (
    codven INT AUTO_INCREMENT PRIMARY KEY,
    numcom VARCHAR(20) NOT NULL UNIQUE,
    fecven DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    codcli INT NOT NULL,
    codemp INT NOT NULL,
    codmetp INT NOT NULL,
    totven DECIMAL(10,2) NOT NULL,
    estven BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_ven_cliente FOREIGN KEY (codcli) REFERENCES cliente(codcli),
    CONSTRAINT fk_ven_empleado FOREIGN KEY (codemp) REFERENCES empleado(codemp),
    CONSTRAINT fk_ven_metodopago FOREIGN KEY (codmetp) REFERENCES metodopago(codmetp)
) ENGINE=InnoDB;

-- 15. DETALLE_VENTA (Ventas)
CREATE TABLE detalle_venta (
    coddetv INT AUTO_INCREMENT PRIMARY KEY,
    codven INT NOT NULL,
    codpro INT NOT NULL,
    candetv INT NOT NULL,
    preundetv DECIMAL(10,2) NOT NULL,
    subdetv DECIMAL(10,2) NOT NULL,
    estdetv BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_detv_venta FOREIGN KEY (codven) REFERENCES venta(codven),
    CONSTRAINT fk_detv_producto FOREIGN KEY (codpro) REFERENCES producto(codpro)
) ENGINE=InnoDB;

-- 16. ORDEN_COMPRA (Compras)
CREATE TABLE orden_compra (
    codordc INT AUTO_INCREMENT PRIMARY KEY,
    numordc VARCHAR(20) NOT NULL UNIQUE,
    fecordc DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    codprv INT NOT NULL,
    totordc DECIMAL(10,2) NOT NULL,
    obsordc VARCHAR(255) NULL,
    estordc BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_ordc_proveedor FOREIGN KEY (codprv) REFERENCES proveedor(codprv)
) ENGINE=InnoDB;

-- 17. DESPACHO (Logística)
CREATE TABLE despacho (
    coddes INT AUTO_INCREMENT PRIMARY KEY,
    codped INT NOT NULL,
    vehdes VARCHAR(50) NOT NULL,
    fecdes DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dirent VARCHAR(200) NOT NULL,
    estdes BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_des_pedido FOREIGN KEY (codped) REFERENCES pedido(codped)
) ENGINE=InnoDB;

-- 18. PAGO (Pagos)
CREATE TABLE pago (
    codpag INT AUTO_INCREMENT PRIMARY KEY,
    numpag VARCHAR(20) NOT NULL UNIQUE,
    codped INT NOT NULL,
    codmetp INT NOT NULL,
    monpag DECIMAL(10,2) NOT NULL,
    fecpag DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estpag BIT NOT NULL DEFAULT 1,
    CONSTRAINT fk_pag_pedido FOREIGN KEY (codped) REFERENCES pedido(codped),
    CONSTRAINT fk_pag_metodopago FOREIGN KEY (codmetp) REFERENCES metodopago(codmetp)
) ENGINE=InnoDB;

-- =============================================================================
-- INSERCIÓN DE DATOS DE PRUEBA REALISTAS
-- =============================================================================

INSERT INTO tipodocumento (nomtipd, esttipd) VALUES
('DNI', 1),
('RUC', 1),
('Carnet de Extranjería', 1),
('Pasaporte', 1);

INSERT INTO categoria (nomcat, descat, estcat) VALUES
('Abarrotes', 'Productos básicos de despensa y consumo diario', 1),
('Lácteos y Huevos', 'Leche, quesos, mantequillas y huevos frescos', 1),
('Carnes y Aves', 'Cortes frescos y congelados de res, cerdo y pollo', 1),
('Bebidas y Licores', 'Gaseosas, jugos, aguas y licores nacionales e importados', 1),
('Limpieza y Hogar', 'Detergentes, desinfectantes y artículos del hogar', 1),
('Frutas y Verduras', 'Frutas frescas y verduras seleccionadas del día', 1);

INSERT INTO proveedor (razprv, rucprv, telprv, corprv, dirprv, estprv) VALUES
('Gloria S.A.', '20100190797', '01-4707170', 'ventas@gloria.com.pe', 'Av. República de Panamá 2461, Santa Catalina', 1),
('Alicorp S.A.A.', '20100055237', '01-3150800', 'atencion@alicorp.com.pe', 'Av. Argentina 4793, Callao', 1),
('San Fernando S.A.', '20100154308', '01-2135300', 'contacto@san-fernando.com.pe', 'Av. República de Panamá 4295, Surquillo', 1),
('Backus y Johnston S.A.A.', '20100113610', '01-3113000', 'pedidos@backus.pe', 'Av. Nicolás Ayllón 3986, Ate', 1),
('Procter & Gamble Perú', '20100127157', '01-6115000', 'ventas@pg.com.pe', 'Av. Canaval y Moreyra 480, San Isidro', 1);

INSERT INTO metodopago (nommetp, estmetp) VALUES
('Efectivo', 1),
('Tarjeta de Crédito', 1),
('Tarjeta de Débito', 1),
('Yape', 1),
('Plin', 1);

INSERT INTO sucursal (nomsuc, dirsuc, telsuc, estsuc) VALUES
('Sucursal Central San Isidro', 'Av. Los Innovadores 1250, Parque Industrial', '01-5123400', 1),
('Sucursal Miraflores', 'Av. Larco 850, Miraflores', '01-4458920', 1),
('Sucursal San Miguel', 'Av. La Marina 2100, San Miguel', '01-6284700', 1);

INSERT INTO almacen (nomalm, ubialm, codsuc, estalm) VALUES
('Almacén General Secos', 'Nave A - Piso 1', 1, 1),
('Almacén Refrigerados', 'Nave B - Cámara Fría 2', 1, 1),
('Almacén Tránsito Miraflores', 'Sótano 1 - Módulo 3', 2, 1);

INSERT INTO cliente (nomcli, apecli, numdoc, codtipd, telcli, corcli, dircli, estcli) VALUES
('Carlos Alberto', 'Mendoza Rojas', '45871234', 1, '987654321', 'carlos.mendoza@gmail.com', 'Av. Benavides 1230, Miraflores', 1),
('María Fernanda', 'Quispe Huamán', '72349812', 1, '976543210', 'maria.quispe@hotmail.com', 'Jr. Las Flores 450, San Borja', 1),
('Jorge Luis', 'Paredes Cáceres', '10482931', 1, '965432109', 'jorge.paredes@outlook.com', 'Calle Los Sauces 210, Surco', 1),
('Ana Lucía', 'Torres Benítez', '44128935', 1, '954321098', 'ana.torres@gmail.com', 'Av. Javier Prado Este 3200, San Isidro', 1),
('Roberto Carlos', 'Silva Vásquez', '09871234', 1, '943210987', 'roberto.silva@yahoo.com', 'Av. La Marina 1540, San Miguel', 1),
('Comercializadora San Juan S.A.C.', 'Empresa', '20601234567', 2, '01-4458920', 'compras@sanjuan.pe', 'Av. Universitaria 1820, Los Olivos', 1);

INSERT INTO producto (nompro, despro, prepro, stopro, codcat, codprv, estpro) VALUES
('Leche Evaporada Gloria Azul 400g', 'Lata de leche evaporada entera tradicional', 4.20, 150, 2, 1, 1),
('Yogurt Gloria Fresa 1kg', 'Botella de yogurt batido sabor fresa', 6.80, 80, 2, 1, 1),
('Arroz Costeño Extra 5kg', 'Bolsa de arroz extra seleccionado grano largo', 21.50, 100, 1, 2, 1),
('Aceite Primor Premium 900ml', 'Botella de aceite vegetal 100% puro de soya', 9.90, 120, 1, 2, 1),
('Pollo Entero San Fernando con Menudencia', 'Pollo fresco beneficiado por kilogramo', 9.50, 60, 3, 3, 1),
('Cerveza Pilsen Callao 355ml Six Pack', 'Pack de 6 latas de cerveza rubia nacional', 26.90, 45, 4, 4, 1),
('Detergente Ariel Doble Poder 2.6kg', 'Bolsa de detergente en polvo para ropa', 29.90, 70, 5, 5, 1),
('Filete de Atún Primor en Aceite 170g', 'Lata de filete de atún en aceite vegetal', 6.50, 110, 1, 2, 1);

INSERT INTO inventario (codpro, codalm, caninv, estinv) VALUES
(1, 1, 100, 1),
(2, 2, 80, 1),
(3, 1, 70, 1),
(4, 1, 90, 1);

INSERT INTO empleado (numdoc, nomemp, apeemp, caremp, codsuc, estemp) VALUES
('47895612', 'Juan Carlos', 'Flores Ramos', 'Jefe de Almacén', 1, 1),
('48962314', 'Rosa Elena', 'Vargas Castro', 'Cajera Principal', 1, 1),
('46321589', 'Luis Miguel', 'Pérez Salazar', 'Supervisor de Ventas', 2, 1);

INSERT INTO usuario (nomusu, clausu, codemp, rolusu, estusu) VALUES
('jflores', '123456', 1, 'ALMACENERO', 1),
('rvargas', '123456', 2, 'CAJERO', 1),
('lperez', '123456', 3, 'SUPERVISOR', 1);

INSERT INTO auditoria (codusu, accaud, estaud) VALUES
(1, 'Inicio de sesión en el sistema', 1),
(2, 'Apertura de caja diaria', 1),
(3, 'Actualización de precios de productos', 1);

INSERT INTO pedido (numped, fecped, codcli, codpro, codmetp, canped, preuni, subtot, igv, totped, obsped, estped) VALUES
('PED-2026-0001', '2026-11-01 10:15:00', 1, 1, 4, 5, 4.20, 21.00, 3.78, 24.78, 'Pedido pagado con Yape en caja rápida', 1),
('PED-2026-0002', '2026-11-02 11:30:00', 2, 3, 3, 2, 21.50, 43.00, 7.74, 50.74, 'Pago con tarjeta de débito BCP', 1),
('PED-2026-0003', '2026-11-03 15:45:00', 3, 4, 2, 3, 9.90, 29.70, 5.35, 35.05, 'Pago con tarjeta de crédito VISA', 1),
('PED-2026-0004', '2026-11-04 18:20:00', 4, 7, 1, 1, 29.90, 29.90, 5.38, 35.28, 'Pago en efectivo en caja central', 1),
('PED-2026-0005', '2026-11-04 19:10:00', 5, 2, 5, 4, 6.80, 27.20, 4.90, 32.10, 'Pago con Plin en módulo de atención', 1);

INSERT INTO venta (numcom, fecven, codcli, codemp, codmetp, totven, estven) VALUES
('B001-00001254', '2026-11-01 10:20:00', 1, 2, 4, 24.78, 1),
('F001-00000842', '2026-11-02 11:35:00', 6, 2, 2, 50.74, 1);

INSERT INTO detalle_venta (codven, codpro, candetv, preundetv, subdetv, estdetv) VALUES
(1, 1, 5, 4.20, 21.00, 1),
(2, 3, 2, 21.50, 43.00, 1);

INSERT INTO orden_compra (numordc, fecordc, codprv, totordc, obsordc, estordc) VALUES
('OC-2026-001', '2026-10-25 09:00:00', 1, 1500.00, 'Reposición semanal de leche evaporada', 1),
('OC-2026-002', '2026-10-26 14:30:00', 2, 3200.00, 'Compra mensual de arroz y aceite', 1);

INSERT INTO despacho (codped, vehdes, dirent, estdes) VALUES
(1, 'Furgón Hyundai H100 - Placa ABC-123', 'Av. Benavides 1230, Miraflores', 1),
(2, 'Camioneta Toyota Hilux - Placa XYZ-789', 'Jr. Las Flores 450, San Borja', 1);

INSERT INTO pago (numpag, codped, codmetp, monpag, estpag) VALUES
('PAG-2026-0001', 1, 4, 24.78, 1),
('PAG-2026-0002', 2, 3, 50.74, 1);
