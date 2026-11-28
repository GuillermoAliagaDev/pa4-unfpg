package pe.edu.isil.plaza_ventas_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.isil.plaza_ventas_service.dto.ProductoDTO;

@FeignClient(
    name = "plaza-producto-service",
    url = "${feign.client.producto-service.url}"
)
public interface ProductoClient {

    @GetMapping("/api/productos/{id}")
    ProductoDTO buscarPorId(@PathVariable("id") Integer id);
}