package com.academia2.deportes.service;

import com.academia2.deportes.dto.DeportistaRequestDTO;
import com.academia2.deportes.dto.DeportistaResponseDTO;
import com.academia2.deportes.entity.Categoria;
import com.academia2.deportes.entity.Deporte;
import com.academia2.deportes.entity.Deportista;
import com.academia2.deportes.repository.CategoriaRepository;
import com.academia2.deportes.repository.DeporteRepository;
import com.academia2.deportes.repository.DeportistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeportistaService {

    private final DeportistaRepository deportistaRepository;
    private final DeporteRepository deporteRepository;
    private final CategoriaRepository categoriaRepository;

    private DeportistaResponseDTO mapearADTO(Deportista deportista){
        DeportistaResponseDTO dto = new DeportistaResponseDTO();
        dto.setId(deportista.getId());
        dto.setNombre(deportista.getNombre());
        dto.setApellido(deportista.getApellido());
        dto.setEdad(deportista.getEdad());

        dto.setDeporteId(deportista.getDeporte().getId());
        dto.setDeporteNombre(deportista.getDeporte().getNombre());

        dto.setCategoriaId(deportista.getCategoria().getId());
        dto.setCategoriaNombre(deportista.getCategoria().getNombre());

        return dto;

    }

    public DeportistaResponseDTO crearDeportista(DeportistaRequestDTO dto) {
        Deporte deporte = deporteRepository.findById(dto.getDeporteId())
                .orElseThrow(() -> new RuntimeException("Deporte no encontrado con ID: " + dto.getDeporteId()));

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + dto.getCategoriaId()));

        Deportista deportista = new Deportista();
        deportista.setNombre(dto.getNombre());
        deportista.setApellido(dto.getApellido());
        deportista.setEdad(dto.getEdad());
        deportista.setDeporte(deporte);
        deportista.setCategoria(categoria);

        Deportista guardado = deportistaRepository.save(deportista);
        return mapearADTO(guardado);
    }

  public List<DeportistaResponseDTO> obtenerTodos() {
    return deportistaRepository.findAll()
            .stream()                  // Abre la tubería
            .map(this::mapearADTO)     // Transforma cada elemento Entidad -> DTO
            .toList();                 // Recolecta todo en una lista inmutable
}

    public DeportistaResponseDTO obtenerPorId(Long id) {
        Deportista deportista = deportistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deportista no encontrado con ID: " + id));
        return mapearADTO(deportista);
    }


    public DeportistaResponseDTO actualizarDeportista(Long id, DeportistaRequestDTO dto) {
        Deportista deportistaExistente = deportistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deportista no encontrado con ID: " + id));

        Deporte deporte = deporteRepository.findById(dto.getDeporteId())
                .orElseThrow(() -> new RuntimeException("Deporte no encontrado con ID: " + dto.getDeporteId()));

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + dto.getCategoriaId()));

        deportistaExistente.setNombre(dto.getNombre());
        deportistaExistente.setApellido(dto.getApellido());
        deportistaExistente.setEdad(dto.getEdad());
        deportistaExistente.setDeporte(deporte);
        deportistaExistente.setCategoria(categoria);

        Deportista actualizado = deportistaRepository.save(deportistaExistente);
        return mapearADTO(actualizado);
    }

public void eliminarDeportista(Long id) {
        Deportista deportistaExistente = deportistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deportista no encontrado con ID: " + id));
        deportistaRepository.delete(deportistaExistente);
    }

    // --- MÉTODOS DE BÚSQUEDA ---

    public List<DeportistaResponseDTO> obtenerPorDeporte(Long deporteId) {
        return deportistaRepository.findByDeporteId(deporteId)
                .stream()
                .map(this::mapearADTO)
                .toList();
    }

    public List<DeportistaResponseDTO> obtenerPorCategoria(Long categoriaId) {
        return deportistaRepository.findByCategoriaId(categoriaId)
                .stream()
                .map(this::mapearADTO)
                .toList();
    }

    public List<DeportistaResponseDTO> obtenerPorDeporteYCategoria(Long deporteId, Long categoriaId) {
        return deportistaRepository.findByDeporteIdAndCategoriaId(deporteId, categoriaId)
                .stream()
                .map(this::mapearADTO)
                .toList();
    }
}