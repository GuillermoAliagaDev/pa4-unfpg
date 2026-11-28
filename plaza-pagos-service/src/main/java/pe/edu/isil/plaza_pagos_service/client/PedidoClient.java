package pe.edu.isil.plaza_pagos_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.isil.plaza_pagos_service.dto.PedidoDTO;

@FeignClient(
    name = "plaza-ventas-service",
    url = "${feign.client.ventas-service.url}"
)
public interface PedidoClient {

    @GetMapping("/api/pedidos/{id}")
    PedidoDTO buscarPorId(@PathVariable("id") Integer id);
}