package pe.edu.isil.alumno_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.isil.alumno_service.exception.DuplicateResourceException;
import pe.edu.isil.alumno_service.exception.ResourceNotFoundException;
import pe.edu.isil.alumno_service.model.Alumno;
import pe.edu.isil.alumno_service.model.AlumnoRequestDTO;
import pe.edu.isil.alumno_service.model.AlumnoResponseDTO;
import pe.edu.isil.alumno_service.repository.AlumnoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // ---- Listar todos ----
    public List<AlumnoResponseDTO> listarTodos() {
        return alumnoRepository.findAll()
                .stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    // ---- Buscar por id ----
    public AlumnoResponseDTO buscarPorId(Integer id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el alumno con id " + id));
        return convertirAResponseDTO(alumno);
    }

    // ---- Crear ----
    public AlumnoResponseDTO crear(AlumnoRequestDTO dto) {
        if (alumnoRepository.existsByNumdoc(dto.getNumdoc())) {
            throw new DuplicateResourceException(
                    "Ya existe un alumno con el documento " + dto.getNumdoc());
        }
        if (alumnoRepository.existsByCoralu(dto.getCoralu())) {
            throw new DuplicateResourceException(
                    "Ya existe un alumno con el correo " + dto.getCoralu());
        }

        Alumno alumno = new Alumno();
        copiarDatos(dto, alumno);
        alumno.setEstalu(true);

        Alumno guardado = alumnoRepository.save(alumno);
        return convertirAResponseDTO(guardado);
    }

    // ---- Actualizar ----
    public AlumnoResponseDTO actualizar(Integer id, AlumnoRequestDTO dto) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el alumno con id " + id));

        copiarDatos(dto, alumno);

        Alumno actualizado = alumnoRepository.save(alumno);
        return convertirAResponseDTO(actualizado);
    }

    // ---- Deshabilitar (baja logica) ----
    public AlumnoResponseDTO deshabilitar(Integer id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el alumno con id " + id));

        alumno.setEstalu(false);
        Alumno actualizado = alumnoRepository.save(alumno);
        return convertirAResponseDTO(actualizado);
    }

    // ---- Habilitar ----
    public AlumnoResponseDTO habilitar(Integer id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el alumno con id " + id));

        alumno.setEstalu(true);
        Alumno actualizado = alumnoRepository.save(alumno);
        return convertirAResponseDTO(actualizado);
    }

    // ---- Metodos auxiliares ----
    private void copiarDatos(AlumnoRequestDTO dto, Alumno alumno) {
        alumno.setNomalu(dto.getNomalu());
        alumno.setApepalu(dto.getApepalu());
        alumno.setApemalu(dto.getApemalu());
        alumno.setFecnac(dto.getFecnac());
        alumno.setNumdoc(dto.getNumdoc());
        alumno.setNacalu(dto.getNacalu());
        alumno.setDiralu(dto.getDiralu());
        alumno.setTelalu(dto.getTelalu());
        alumno.setCelalu(dto.getCelalu());
        alumno.setCoralu(dto.getCoralu());
        alumno.setCoddis(dto.getCoddis());
        alumno.setCodsex(dto.getCodsex());
        alumno.setCodtipd(dto.getCodtipd());
        alumno.setCodestc(dto.getCodestc());
    }

    private AlumnoResponseDTO convertirAResponseDTO(Alumno alumno) {
        AlumnoResponseDTO dto = new AlumnoResponseDTO();
        dto.setCodalu(alumno.getCodalu());
        dto.setNomalu(alumno.getNomalu());
        dto.setApepalu(alumno.getApepalu());
        dto.setApemalu(alumno.getApemalu());
        dto.setFecnac(alumno.getFecnac());
        dto.setNumdoc(alumno.getNumdoc());
        dto.setNacalu(alumno.getNacalu());
        dto.setDiralu(alumno.getDiralu());
        dto.setTelalu(alumno.getTelalu());
        dto.setCelalu(alumno.getCelalu());
        dto.setCoralu(alumno.getCoralu());
        dto.setEstalu(alumno.getEstalu());
        dto.setCrealu(alumno.getCrealu());
        dto.setCoddis(alumno.getCoddis());
        dto.setCodsex(alumno.getCodsex());
        dto.setCodtipd(alumno.getCodtipd());
        dto.setCodestc(alumno.getCodestc());
        return dto;
    }
}