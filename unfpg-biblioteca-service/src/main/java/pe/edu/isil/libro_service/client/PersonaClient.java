package pe.edu.isil.libro_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.isil.libro_service.dto.AlumnoDTO;

@FeignClient(
    name = "unfpg-persona-service",
    url = "${feign.client.persona-service.url}"
)
public interface PersonaClient {

    @GetMapping("/api/alumnos/{id}")
    AlumnoDTO buscarPorId(@PathVariable("id") Integer id);
}