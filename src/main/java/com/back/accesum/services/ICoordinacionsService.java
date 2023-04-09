package com.back.accesum.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.back.accesum.modelo.Centros;
import com.back.accesum.modelo.tbl_coordinacions;
import org.springframework.data.domain.PageRequest;

public interface ICoordinacionsService {
    public List<tbl_coordinacions> findAll();

    public Page<tbl_coordinacions> findAll(Pageable pageable);

    public tbl_coordinacions findById(Long id);

    public tbl_coordinacions save(tbl_coordinacions tbl_coordinacions);

    public void delete(Long id);

    public List<Centros> findAllCentros();

    public Page<tbl_coordinacions> findAll(PageRequest pageable);

    public Page<tbl_coordinacions> findAll(org.springframework.data.domain.Pageable pageable);
}
