package com.back.accesum.modelo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "name", "document", "email", "detalles", "fichas_id" ,"rol_id"})
public class UserDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String document;

    @NotBlank
    private String email;

    @NotBlank
    private String detalles;

    @NotEmpty
    @JsonAlias("fichas_id")
    private Integer fichas_id;

    @NotEmpty
    @JsonAlias("rol_id")
    private Integer rol_id;
}
