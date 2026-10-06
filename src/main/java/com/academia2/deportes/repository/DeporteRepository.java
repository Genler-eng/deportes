package com.academia2.deportes.repository;

import com.academia2.deportes.entity.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeporteRepository extends JpaRepository<Deporte, Long> {
}