
package com.back.accesum.services.Impl;

import com.back.accesum.modelo.entity.Centros;
import com.back.accesum.modelo.entity.Parametros;
import com.back.accesum.modelo.entity.Sedes;
import com.back.accesum.modelo.entity.tbl_coordinacions;
import com.back.accesum.services.ISedesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.back.accesum.repositorio.SedesRepository;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class SedesServiceImpl implements ISedesService {

    private final SedesRepository sedesRepo;

    @Override
    public List<Sedes> findAll() {
        return (List<Sedes>) sedesRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Sedes findById(Long id) {
        return sedesRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Sedes save(Sedes sedes) {
        return sedesRepo.save(sedes); 
    }

    @Override
    @Transactional
    public void delete(Long id) {
        sedesRepo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Centros> findAllCentros() {
        return sedesRepo.findAllCentros();
    }

    @Override
    @Transactional(readOnly = true)
    public List<tbl_coordinacions> findAllCordinacion() {
         return sedesRepo.findAllCoordinacions();
    }

    @Override
    public Page<Parametros> findAll(SpringDataWebProperties.Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
