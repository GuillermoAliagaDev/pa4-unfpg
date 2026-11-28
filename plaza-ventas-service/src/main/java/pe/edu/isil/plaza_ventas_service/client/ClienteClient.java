package pe.edu.isil.plaza_ventas_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.isil.plaza_ventas_service.dto.ClienteDTO;

@FeignClient(
    name = "plaza-cliente-service",
    url = "${feign.client.cliente-service.url}"
)
public interface ClienteClient {

    @GetMapping("/api/clientes/{id}")
    ClienteDTO buscarPorId(@PathVariable("id") Integer id);
}