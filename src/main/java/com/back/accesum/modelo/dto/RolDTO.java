
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
@JsonPropertyOrder({ "rol_nombre"})
public class RolDTO {
    @NotBlank
    private String rol_nombre;
    
}
