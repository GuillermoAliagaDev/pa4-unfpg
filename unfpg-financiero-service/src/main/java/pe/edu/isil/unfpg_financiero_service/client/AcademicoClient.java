package pe.edu.isil.unfpg_financiero_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.isil.unfpg_financiero_service.dto.MatriculaDTO;

@FeignClient(
    name = "unfpg-academico-service",
    url = "${feign.client.academico-service.url}"
)
public interface AcademicoClient {

    @GetMapping("/api/matriculas/{id}")
    MatriculaDTO buscarPorId(@PathVariable("id") Integer id);
}