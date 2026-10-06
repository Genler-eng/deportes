package com.academia2.deportes.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeportistaRequestDTO {

    @NotBlank(message = "El nombre es obligatorio y no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 3, message = "El deportista debe tener al menos 3 años")
    private Integer edad;

    @NotNull(message = "El ID del deporte es obligatorio")
    private Long deporteId;

    @NotNull(message = "El ID de la categoría es obligatorio")
    private Long categoriaId;
}