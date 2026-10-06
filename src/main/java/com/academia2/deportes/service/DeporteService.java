package com.academia2.deportes.service;
import com.academia2.deportes.entity.Deporte;
import com.academia2.deportes.repository.DeporteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeporteService {

    private final DeporteRepository deporteRepository;

    public Deporte crear(Deporte deporte) {
        return deporteRepository.save(deporte);
    }

    public List<Deporte> obtenerTodos() {
        return deporteRepository.findAll();
    }

    public Deporte obtenerPorId(Long id) {
        return deporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deporte no encontrado con ID: " + id));
    }
}