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
@JsonPropertyOrder({ "tbl_fichas_codigo", "fichas_grupo", "programa", "tbl_fichas_tbl_coordinacions"})    
public class FichasDTO {
    @NotBlank
    private String tbl_fichas_codigo;
    
    @NotBlank
    private String fichas_grupo;
        
    @NotBlank
    private String programa;
    
    @NotEmpty
    @JsonAlias("tbl_fichas_tbl_coordinacions")
    private Integer tbl_fichas_tbl_coordinacions;
}
