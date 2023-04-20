
package com.back.accesum.modelo.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "tbl_regionals_codigo", "tbl_regionals_nombre", "tbl_regionals_nombre"})
public class RegionalesDTO {
     @NotBlank
    private long tbl_regionals_codigo;

    @NotBlank
    private String tbl_regionals_nombre;

    @NotBlank
    private String tbl_regionals_director;


}
