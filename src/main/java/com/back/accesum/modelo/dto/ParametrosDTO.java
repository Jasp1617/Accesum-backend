package com.back.accesum.modelo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "id_sedes", "id_user", "id_rol"})
public class ParametrosDTO {
    @NotEmpty
    @JsonAlias("tbl_regionals_codigo")
        private Integer tbl_regionals_codigo;
    
    @NotEmpty
    @JsonAlias("id_sedes")
        private Integer id_sedes;
    
    @NotEmpty
    @JsonAlias("id_rol")
        private Integer id_rol;
    
    
}
