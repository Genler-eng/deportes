package com.academia2.deportes.repository;

import com.academia2.deportes.entity.Deportista;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface DeportistaRepository extends JpaRepository<Deportista, Long> {

    // Búsqueda por ID del Deporte asociado
    List<Deportista> findByDeporteId(Long deporteId);

    // Búsqueda por ID de la Categoría asociada
    List<Deportista> findByCategoriaId(Long categoriaId);

    // Búsqueda combinada: Por Deporte Y Categoría
    List<Deportista> findByDeporteIdAndCategoriaId(Long deporteId, Long categoriaId);
}