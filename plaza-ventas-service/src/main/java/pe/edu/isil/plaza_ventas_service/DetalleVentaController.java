package pe.edu.isil.plaza_ventas_service;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

import feign.FeignException;
import pe.edu.isil.plaza_ventas_service.client.ProductoClient;
import pe.edu.isil.plaza_ventas_service.dto.ProductoDTO;

@RestController
@RequestMapping("/api/detalles-venta")
public class DetalleVentaController {

    private final DetalleVentaRepository repo;
    private final ProductoClient productoClient;

    public DetalleVentaController(
            DetalleVentaRepository repo,
            ProductoClient productoClient) {
        this.repo = repo;
        this.productoClient = productoClient;
    }

    @GetMapping
    public List<DetalleVenta> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public DetalleVenta buscar(@PathVariable Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleVenta crear(@RequestBody DetalleVenta body) {

        validarProducto(body.codpro, body.candetv);

        body.coddetv = null;
        body.estdetv = true;

        return repo.save(body);
    }

    @PutMapping("/{id}")
    public DetalleVenta actualizar(
            @PathVariable Integer id,
            @RequestBody DetalleVenta body) {

        var actual = buscar(id);

        validarProducto(body.codpro, body.candetv);

        actual.codven = body.codven;
        actual.codpro = body.codpro;
        actual.candetv = body.candetv;
        actual.preundetv = body.preundetv;
        actual.subdetv = body.subdetv;

        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public DetalleVenta baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public DetalleVenta alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private DetalleVenta estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estdetv = activo;
        return repo.save(actual);
    }

    // Validacion mediante OpenFeign
    private void validarProducto(Integer codpro, Integer cantidad) {

        if (codpro == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El codigo del producto es obligatorio");
        }

        if (cantidad == null || cantidad <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La cantidad debe ser mayor a cero");
        }

        try {

            ProductoDTO producto =
                    productoClient.buscarPorId(codpro);

            if (producto == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El producto no existe");
            }

            if (!Boolean.TRUE.equals(producto.getEstpro())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El producto esta deshabilitado");
            }

            if (producto.getStopro() == null
                    || producto.getStopro() < cantidad) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Stock insuficiente");
            }

        } catch (FeignException.NotFound e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El producto no existe");

        } catch (FeignException e) {

            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    "No se pudo consultar el microservicio Producto");
        }
    }
}