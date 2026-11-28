package pe.edu.isil.plaza_pagos_service;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.math.BigDecimal;

import feign.FeignException;
import pe.edu.isil.plaza_pagos_service.client.PedidoClient;
import pe.edu.isil.plaza_pagos_service.dto.PedidoDTO;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoRepository repo;
    private final PedidoClient pedidoClient;

    public PagoController(
            PagoRepository repo,
            PedidoClient pedidoClient) {
        this.repo = repo;
        this.pedidoClient = pedidoClient;
    }

    @GetMapping
    public List<Pago> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Pago buscar(@PathVariable Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pago crear(@RequestBody Pago body) {

        validarPedido(body.codped, body.monpag);

        body.codpag = null;
        body.estpag = true;

        return repo.save(body);
    }

    @PutMapping("/{id}")
    public Pago actualizar(
            @PathVariable Integer id,
            @RequestBody Pago body) {

        var actual = buscar(id);

        validarPedido(body.codped, body.monpag);

        actual.numpag = body.numpag;
        actual.codped = body.codped;
        actual.codmetp = body.codmetp;
        actual.monpag = body.monpag;
        actual.fecpag = body.fecpag;

        return repo.save(actual);
    }

    @DeleteMapping("/{id}")
    public Pago baja(@PathVariable Integer id) {
        return estado(id, false);
    }

    @PatchMapping("/{id}/habilitar")
    public Pago alta(@PathVariable Integer id) {
        return estado(id, true);
    }

    private Pago estado(Integer id, boolean activo) {
        var actual = buscar(id);
        actual.estpag = activo;
        return repo.save(actual);
    }

    // Validacion mediante OpenFeign
    private void validarPedido(
            Integer codped,
            BigDecimal monto) {

        if (codped == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El codigo del pedido es obligatorio");
        }

        if (monto == null
                || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El monto debe ser mayor a cero");
        }

        try {

            PedidoDTO pedido =
                    pedidoClient.buscarPorId(codped);

            if (pedido == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El pedido no existe");
            }

            if (!Boolean.TRUE.equals(pedido.getEstped())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El pedido esta deshabilitado");
            }

            if (pedido.getTotped() == null
                    || monto.compareTo(pedido.getTotped()) > 0) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El monto supera el total del pedido o el total no es valido");
            }

        } catch (FeignException.NotFound e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El pedido no existe");

        } catch (FeignException e) {

            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    "No se pudo consultar el microservicio Ventas");
        }
    }
}