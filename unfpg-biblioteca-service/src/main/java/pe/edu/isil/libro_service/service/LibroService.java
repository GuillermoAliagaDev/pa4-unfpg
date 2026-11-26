package pe.edu.isil.libro_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.isil.libro_service.exception.DuplicateResourceException;
import pe.edu.isil.libro_service.exception.ResourceNotFoundException;
import pe.edu.isil.libro_service.model.Libro;
import pe.edu.isil.libro_service.model.LibroRequestDTO;
import pe.edu.isil.libro_service.model.LibroResponseDTO;
import pe.edu.isil.libro_service.repository.LibroRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // ---- Listar todos ----
    public List<LibroResponseDTO> listarTodos() {
        return libroRepository.findAll()
                .stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    // ---- Buscar por id ----
    public LibroResponseDTO buscarPorId(Integer id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el libro con id " + id));
        return convertirAResponseDTO(libro);
    }

    // ---- Crear ----
    public LibroResponseDTO crear(LibroRequestDTO dto) {
        if (dto.getIsbnlib() != null && !dto.getIsbnlib().isBlank()
                && libroRepository.existsByIsbnlib(dto.getIsbnlib())) {
            throw new DuplicateResourceException(
                    "Ya existe un libro con el ISBN " + dto.getIsbnlib());
        }

        Libro libro = new Libro();
        copiarDatos(dto, libro);
        libro.setEstlib(true);

        Libro guardado = libroRepository.save(libro);
        return convertirAResponseDTO(guardado);
    }

    // ---- Actualizar ----
    public LibroResponseDTO actualizar(Integer id, LibroRequestDTO dto) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el libro con id " + id));

        copiarDatos(dto, libro);

        Libro actualizado = libroRepository.save(libro);
        return convertirAResponseDTO(actualizado);
    }

    // ---- Deshabilitar (baja logica) ----
    public LibroResponseDTO deshabilitar(Integer id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el libro con id " + id));

        libro.setEstlib(false);
        Libro actualizado = libroRepository.save(libro);
        return convertirAResponseDTO(actualizado);
    }

    // ---- Habilitar ----
    public LibroResponseDTO habilitar(Integer id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No se encontro el libro con id " + id));

        libro.setEstlib(true);
        Libro actualizado = libroRepository.save(libro);
        return convertirAResponseDTO(actualizado);
    }

    // ---- Metodos auxiliares ----
    private void copiarDatos(LibroRequestDTO dto, Libro libro) {
        libro.setIsbnlib(dto.getIsbnlib());
        libro.setTitlib(dto.getTitlib());
        libro.setAutlib(dto.getAutlib());
        libro.setDeslib(dto.getDeslib());
        libro.setCodcatl(dto.getCodcatl());
        libro.setCodedi(dto.getCodedi());
    }

    private LibroResponseDTO convertirAResponseDTO(Libro libro) {
        LibroResponseDTO dto = new LibroResponseDTO();
        dto.setCodlib(libro.getCodlib());
        dto.setIsbnlib(libro.getIsbnlib());
        dto.setTitlib(libro.getTitlib());
        dto.setAutlib(libro.getAutlib());
        dto.setDeslib(libro.getDeslib());
        dto.setEstlib(libro.getEstlib());
        dto.setCodcatl(libro.getCodcatl());
        dto.setCodedi(libro.getCodedi());
        return dto;
    }
}