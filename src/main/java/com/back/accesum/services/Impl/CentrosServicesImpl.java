package com.back.accesum.services.Impl;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.back.accesum.modelo.entity.Centros;
import com.back.accesum.modelo.entity.regionales;
import com.back.accesum.repositorio.CentrosRepository;
import com.back.accesum.services.ICentrosService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class CentrosServicesImpl implements ICentrosService {

    private final CentrosRepository centrosRepo;

    @Override
    public List<Centros> findAll() {
        return (List<Centros>) centrosRepo.findAll();
    }

    @Override
    public Centros findById(Long id) {
        return centrosRepo.findById(id).orElse(null);
    }

    @Override
    public Centros save(Centros Centros) {
        return centrosRepo.save(Centros);
    }

    @Override
    public void delete(Long id) {
        centrosRepo.deleteById(id);
    }

    @Override
    public List<regionales> findAllRegionales() {
        return centrosRepo.findAllRegionales();
    }

    @Override
    public Page<Centros> findAll(Pageable pageable) {
        return centrosRepo.findAll(pageable);
    }

    @Override
    public Page<Centros> findAll(SpringDataWebProperties.Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<Centros> findAll(PageRequest pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
