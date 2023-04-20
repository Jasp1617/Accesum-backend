
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
@JsonPropertyOrder({ "tbl_sedes_codigo", "sedes_nombre", "sedes_ciudad", "sede_direccion", "sede_centros_id", "sede_cordinacions"})
public class SedesDTO {
    
    @NotBlank
    private String tbl_sedes_codigo;

    @NotBlank
    private String sedes_nombre;

    @NotBlank
    private String sedes_ciudad;

    @NotBlank
    private String sede_direccion;
    
    @NotBlank
    @JsonAlias("sede_centros_id")
    private String sede_centros_id;

    @NotEmpty
    @JsonAlias("sede_cordinacions")
    private Integer sede_cordinacions;
}
