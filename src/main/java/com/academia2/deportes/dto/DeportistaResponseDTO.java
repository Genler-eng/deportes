package com.academia2.deportes.dto;

import lombok.Data;

@Data 
public class DeportistaResponseDTO {
    
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;

    // Datos simplificados del Deporte
    private Long deporteId;
    private String deporteNombre;

    // Datos simplificados de la Categoría
    private Long categoriaId;
    private String categoriaNombre;
}
