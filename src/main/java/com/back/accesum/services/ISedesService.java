
package com.back.accesum.services;

import com.back.accesum.modelo.entity.Centros;
import com.back.accesum.modelo.entity.Parametros;
import com.back.accesum.modelo.entity.Rol;
import com.back.accesum.modelo.entity.Sedes;
import com.back.accesum.modelo.entity.tbl_coordinacions;

import java.util.List;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;


public interface ISedesService {
    
    public List<Sedes> findAll();

    public Sedes findById(Long id);

    public Sedes save(Sedes sedes);

    public void delete(Long id);

    public List<Centros> findAllCentros();
    public List<tbl_coordinacions> findAllCordinacion();

    public Page<Parametros> findAll(SpringDataWebProperties.Pageable pageable);
}
