package com.academia2.deportes.controller;

import com.academia2.deportes.dto.DeportistaRequestDTO;
import com.academia2.deportes.dto.DeportistaResponseDTO;
import com.academia2.deportes.service.DeportistaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deportistas")
@RequiredArgsConstructor
public class DeportistaController {

    private final DeportistaService deportistaService;

    @PostMapping
    public DeportistaResponseDTO crearDeportista(@Valid @RequestBody DeportistaRequestDTO dto) {
        return deportistaService.crearDeportista(dto);
    }

    @GetMapping
    public List<DeportistaResponseDTO> listarDeportistas() {
        return deportistaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public DeportistaResponseDTO obtenerPorId(@PathVariable Long id) {
        return deportistaService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public DeportistaResponseDTO actualizarDeportista(@PathVariable Long id, @Valid @RequestBody DeportistaRequestDTO dto) {
        return deportistaService.actualizarDeportista(id, dto);
    }

    @DeleteMapping("/{id}")
    public String eliminarDeportista(@PathVariable Long id) {
        deportistaService.eliminarDeportista(id);
        return "Deportista con ID " + id + " eliminado correctamente.";
    }

    // --- FILTROS Y BÚSQUEDAS ---

    @GetMapping("/deporte/{deporteId}")
    public List<DeportistaResponseDTO> listarPorDeporte(@PathVariable Long deporteId) {
        return deportistaService.obtenerPorDeporte(deporteId);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<DeportistaResponseDTO> listarPorCategoria(@PathVariable Long categoriaId) {
        return deportistaService.obtenerPorCategoria(categoriaId);
    }

    @GetMapping("/buscar")
    public List<DeportistaResponseDTO> buscarPorDeporteYCategoria(
            @RequestParam Long deporteId,
            @RequestParam Long categoriaId) {
        return deportistaService.obtenerPorDeporteYCategoria(deporteId, categoriaId);
    }
}
