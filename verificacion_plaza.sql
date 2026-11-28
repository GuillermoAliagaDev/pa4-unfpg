-- Verificacion de resultados despues de las pruebas en Postman.
-- En MySQL Workbench: poner el cursor en una consulta y presionar Ctrl+Enter.
-- La columna "habilitado" muestra 1 (habilitado) o 0 (deshabilitado).
USE plaza_megacentimetros;

-- Cliente
SELECT t.*, t.estcli + 0 AS habilitado FROM cliente t ORDER BY t.codcli DESC LIMIT 5;

-- Cliente
SELECT t.*, t.esttipd + 0 AS habilitado FROM tipodocumento t ORDER BY t.codtipd DESC LIMIT 5;

-- Producto
SELECT t.*, t.estpro + 0 AS habilitado FROM producto t ORDER BY t.codpro DESC LIMIT 5;

-- Producto
SELECT t.*, t.estcat + 0 AS habilitado FROM categoria t ORDER BY t.codcat DESC LIMIT 5;

-- Ventas
SELECT t.*, t.estped + 0 AS habilitado FROM pedido t ORDER BY t.codped DESC LIMIT 5;

-- Ventas
SELECT t.*, t.estven + 0 AS habilitado FROM venta t ORDER BY t.codven DESC LIMIT 5;

-- Ventas
SELECT t.*, t.estdetv + 0 AS habilitado FROM detalle_venta t ORDER BY t.coddetv DESC LIMIT 5;

-- Compras
SELECT t.*, t.estprv + 0 AS habilitado FROM proveedor t ORDER BY t.codprv DESC LIMIT 5;

-- Compras
SELECT t.*, t.estordc + 0 AS habilitado FROM orden_compra t ORDER BY t.codordc DESC LIMIT 5;

-- Logistica
SELECT t.*, t.estdes + 0 AS habilitado FROM despacho t ORDER BY t.coddes DESC LIMIT 5;

-- Logistica
SELECT t.*, t.estalm + 0 AS habilitado FROM almacen t ORDER BY t.codalm DESC LIMIT 5;

-- Logistica
SELECT t.*, t.estsuc + 0 AS habilitado FROM sucursal t ORDER BY t.codsuc DESC LIMIT 5;

-- Logistica
SELECT t.*, t.estinv + 0 AS habilitado FROM inventario t ORDER BY t.codinv DESC LIMIT 5;

-- Pagos
SELECT t.*, t.estpag + 0 AS habilitado FROM pago t ORDER BY t.codpag DESC LIMIT 5;

-- Pagos
SELECT t.*, t.estmetp + 0 AS habilitado FROM metodopago t ORDER BY t.codmetp DESC LIMIT 5;

-- Personal
SELECT t.*, t.estemp + 0 AS habilitado FROM empleado t ORDER BY t.codemp DESC LIMIT 5;

-- Personal
SELECT t.*, t.estusu + 0 AS habilitado FROM usuario t ORDER BY t.codusu DESC LIMIT 5;

-- Personal
SELECT t.*, t.estaud + 0 AS habilitado FROM auditoria t ORDER BY t.codaud DESC LIMIT 5;
