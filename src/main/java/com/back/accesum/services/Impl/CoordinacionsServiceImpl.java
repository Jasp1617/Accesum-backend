package com.back.accesum.services.Impl;

import java.util.List;

import com.back.accesum.modelo.entity.Centros;
import com.back.accesum.modelo.entity.tbl_coordinacions;
import com.back.accesum.repositorio.CoordinacionsRepository;
import com.back.accesum.services.ICoordinacionsService;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class CoordinacionsServiceImpl implements ICoordinacionsService {

    private final CoordinacionsRepository coordinacionsRepo;

    @Override
    public List<tbl_coordinacions> findAll() {
        return (List<tbl_coordinacions>) coordinacionsRepo.findAll();
    }

    @Override
    public tbl_coordinacions findById(Long id) {
        return coordinacionsRepo.findById(id).orElse(null);
    }

    @Override
    public tbl_coordinacions save(tbl_coordinacions tbl_coordinacions) {
        return coordinacionsRepo.save(tbl_coordinacions);
    }

    @Override
    public void delete(Long id) {
        coordinacionsRepo.deleteById(id);
    }

    @Override
    public List<Centros> findAllCentros() {
        return coordinacionsRepo.findAllCentros();
    }

    @Override
    public Page<tbl_coordinacions> findAll(Pageable pageable) {
        return coordinacionsRepo.findAll(pageable);
    }

    @Override
    public Page<tbl_coordinacions> findAll(SpringDataWebProperties.Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<tbl_coordinacions> findAll(PageRequest pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
