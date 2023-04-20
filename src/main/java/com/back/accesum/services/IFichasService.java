package com.back.accesum.services;

import com.back.accesum.modelo.entity.tbl_coordinacions;
import com.back.accesum.modelo.entity.tbl_fichas;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFichasService {
        public List<tbl_fichas> findAll();

        public Page<tbl_fichas> findAll(Pageable pageable);

        public tbl_fichas findById(Long id);

        public tbl_fichas save(tbl_fichas tbl_fichas);

        public void delete(Long id);

        public List<tbl_coordinacions> findAlltbl_coordinacions();
}
