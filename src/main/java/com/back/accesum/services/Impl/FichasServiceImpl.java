package com.back.accesum.services.Impl;

import java.util.List;
import com.back.accesum.services.IFichasService;
import com.back.accesum.modelo.entity.tbl_coordinacions;
import com.back.accesum.modelo.entity.tbl_fichas;
import com.back.accesum.repositorio.FichasRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class FichasServiceImpl implements IFichasService {


    private final FichasRepository fichasRepo;

    @Override
    public List<tbl_fichas> findAll() {
        return (List<tbl_fichas>) fichasRepo.findAll();
    }

    @Override
    public tbl_fichas findById(Long id) {
        return fichasRepo.findById(id).orElse(null);
    }

    @Override
    public tbl_fichas save(tbl_fichas tbl_fichas) {
        return fichasRepo.save(tbl_fichas);
    }

    @Override
    public void delete(Long id) {
        fichasRepo.deleteById(id);
    }

    @Override
    public List<tbl_coordinacions> findAlltbl_coordinacions() {
        return fichasRepo.findAlltbl_coordinacions();
    }

    @Override
    public Page<tbl_fichas> findAll(Pageable pageable) {
        return fichasRepo.findAll(pageable);
    }
}
