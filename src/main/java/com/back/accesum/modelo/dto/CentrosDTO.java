
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
@JsonPropertyOrder({ "tbl_centros_codigo", "tbl_centros_nombre", "tbl_centros_tbl_regionals_id"})   
public class CentrosDTO {
     @NotBlank
    private String tbl_centros_codigo;
    
    @NotBlank
    private String tbl_centros_nombre;
    
    @NotEmpty
    @JsonAlias("tbl_centros_tbl_regionals_id")
    private Integer tbl_centros_tbl_regionals_id;
    
}
