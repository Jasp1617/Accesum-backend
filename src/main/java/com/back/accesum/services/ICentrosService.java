package com.back.accesum.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.back.accesum.modelo.Centros;
import com.back.accesum.modelo.regionales;

public interface ICentrosService {
    public List<Centros> findAll();

    public Page<Centros> findAll(Pageable pageable);

    public Centros findById(Long id);

    public Centros save(Centros Centros);

    public void delete(Long id);

    public List<regionales> findAllRegionales();

    public Page<Centros> findAll(PageRequest pageable);

    public Page<Centros> findAll(org.springframework.data.domain.Pageable pageable);
}
