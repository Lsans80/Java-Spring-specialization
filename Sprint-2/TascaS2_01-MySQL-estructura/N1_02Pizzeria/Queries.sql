USE pizzeria;

-- Lista cuántos productos de categoría 'Bebidas' se han vendido en una determinada localidad.

SELECT cp.idProducto,
		SUM(cantidad) AS totalCantidad, -- Se necesita el GROUP BY para que funcione.
        nombre,
        nombreLocalidad
FROM cantidadproducto cp
JOIN producto p ON p.idProducto = cp.idProducto
JOIN pedido pe ON pe.idPedido = cp.idPedido
JOIN tienda t ON t.idTienda = pe.idTienda
JOIN localidad l ON l.idLocalidad = t.idLocalidad
WHERE p.nombre != 'Hamburguesa' AND p.nombre != 'Pizza'
GROUP BY cp.idProducto,
        nombre,
        nombreLocalidad
ORDER BY nombre;

-- Lista cuántos pedidos ha efectuado un determinado empleado/a.

SELECT COUNT(idPedido) AS totalPedidos,
		e.nombre
FROM pedido p
JOIN empleado e ON e.idEmpleado = p.idEmpleado
GROUP BY e.nombre