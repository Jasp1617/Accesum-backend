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
@JsonPropertyOrder({ "id_user", "fecha", "hora_entrada", "hora_salida", "sede_id" })
public class MovimientoDTO {
    
    @NotEmpty
    @JsonAlias("id_user")
    private Integer user_id;
    
    @NotEmpty
    @JsonAlias("sede_id")
    private Integer sede_id;
}
