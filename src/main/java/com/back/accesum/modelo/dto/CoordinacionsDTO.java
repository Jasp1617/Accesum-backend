
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
@JsonPropertyOrder({ "tbl_coordinacions_codigo", "tbl_coordinacions_nombre", "tbl_coordinacions_coordinador", "tbl_coordinacions_tbl_centros_id"})  
public class CoordinacionsDTO {
    @NotBlank
    private Long tbl_coordinacions_codigo;
    
    @NotBlank
    private String tbl_coordinacions_nombre;
        
    @NotBlank
    private String tbl_coordinacions_coordinador;
    
    @NotEmpty
    @JsonAlias("tbl_coordinacions_tbl_centros_id")
    private Integer tbl_coordinacions_tbl_centros_id;
}
