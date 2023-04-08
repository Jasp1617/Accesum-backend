package com.back.accesum.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jorge Silva
 */
@Getter
@Setter
@Entity
@Table(name = "tbl_fichas")
public class tbl_fichas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id ")
    private Long id;
    
    @Column(name = "tbl_fichas_codigo")
    private String tbl_fichas_codigo;
        
    @Column(name = "fichas_grupo")
    private String fichas_grupo;
    
    @Column(name = "programa")
    private String programa;
    
    @NotNull(message="Este campo no puede estar vacio")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tbl_fichas_tbl_coordinacions")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private tbl_coordinacions tbl_fichas_tbl_coordinacions ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTbl_fichas_codigo() {
        return tbl_fichas_codigo;
    }

    public void setTbl_fichas_codigo(String tbl_fichas_codigo) {
        this.tbl_fichas_codigo = tbl_fichas_codigo;
    }

    public String getFichas_grupo() {
        return fichas_grupo;
    }

    public void setFichas_grupo(String fichas_grupo) {
        this.fichas_grupo = fichas_grupo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    
    private static final long serialVersionUID = 1L;

}
