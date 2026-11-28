-- Verificacion de resultados despues de las pruebas en Postman.
-- En MySQL Workbench: poner el cursor en una consulta y presionar Ctrl+Enter.
-- La columna "habilitado" muestra 1 (habilitado) o 0 (deshabilitado).
USE universidad_unfpg;

-- Academico
SELECT t.*, t.estmat + 0 AS habilitado FROM matricula t ORDER BY t.nummat DESC LIMIT 5;

-- Financiero
SELECT t.*, t.estordpag + 0 AS habilitado FROM ordenpago t ORDER BY t.codordpag DESC LIMIT 5;

-- Biblioteca
SELECT t.*, t.estlib + 0 AS habilitado FROM libro t ORDER BY t.codlib DESC LIMIT 5;

-- Aula Virtual
SELECT t.*, t.esteval + 0 AS habilitado FROM evaluacionlms t ORDER BY t.codeval DESC LIMIT 5;

-- Persona
SELECT t.*, t.estalu + 0 AS habilitado FROM alumno t ORDER BY t.codalu DESC LIMIT 5;

-- Seguridad
SELECT t.*, t.estrol + 0 AS habilitado FROM rol t ORDER BY t.codrol DESC LIMIT 5;

-- Catalogo
SELECT t.*, t.estestp + 0 AS habilitado FROM estadopago t ORDER BY t.codestp DESC LIMIT 5;

-- OpenFeign: prestamos
SELECT t.*, t.estpre + 0 AS habilitado FROM prestamolibro t ORDER BY t.numpre DESC LIMIT 5;
