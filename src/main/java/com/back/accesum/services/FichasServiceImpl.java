package com.back.accesum.services;

import com.back.accesum.modelo.dao.IFichasDao;
import com.back.accesum.modelo.tbl_coordinacions;
import com.back.accesum.modelo.tbl_fichas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FichasServiceImpl implements IFichasService{

    
    @Autowired
    private IFichasDao fichasDao;
    
    @Override
    public List<tbl_fichas> findAll() {
        return (List<tbl_fichas>) fichasDao.findAll();    }

    @Override
    public tbl_fichas findById(Long id) {
        return fichasDao.findById(id).orElse(null);
    }

    @Override
    public tbl_fichas save(tbl_fichas tbl_fichas) {
        return fichasDao.save(tbl_fichas);
    }

    @Override
    public void delete(Long id) {
        fichasDao.deleteById(id);
    }

    @Override
    public List<tbl_coordinacions> findAlltbl_coordinacions() {
        return fichasDao.findAlltbl_coordinacions();
    }

    @Override
    public Page<tbl_fichas> findAll(Pageable pageable) {
       return fichasDao.findAll(pageable);
    }


    
}
