USE optica;

-- Lista el total de facturas de un cliente/a en un período determinado.

SELECT c.nombre, 
		idVenta, 
        fechaVenta, 
        empleado, 
        idGafa
FROM cliente c
JOIN venta v ON v.idCliente = c.idCliente
WHERE nombre='Manolo' AND v.fechaVenta >=2020-01-01 OR v.fechaVenta <= 2025-01-01;

-- Lista los diferentes modelos de gafas que ha vendido un empleado durante un año.

SELECT idVenta,
		fechaVenta,
        empleado,
        g.idGafa,
        marca
FROM venta v
JOIN gafa g ON g.idGafa = v.idGafa
WHERE empleado = 'Maria' AND (v.fechaVenta BETWEEN '2023-01-01' AND '2023-12-31');

-- Lista a los diferentes proveedores que han suministrado gafas vendidas con éxito por la óptica.

SELECT idProveedor,
		g.idGafa,
        marca,
		idVenta			
FROM venta v
JOIN gafa g ON g.idGafa = v.idGafa;

-- Prueba de consulta de datos del cliente que recomienda
-- SELF JOIN

SELECT *
FROM cliente c1
JOIN cliente c2 ON c1.recomendadoPor = c2.idCliente;

