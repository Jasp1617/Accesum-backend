package com.back.accesum.services;

import com.back.accesum.modelo.User;
import com.back.accesum.modelo.tbl_coordinacions;
import com.back.accesum.modelo.tbl_fichas;
import java.util.List;

public interface IFichasService {
        public List<tbl_fichas> findAll();
	
	public tbl_fichas findById(Long id);
	
	public tbl_fichas save(tbl_fichas tbl_fichas);
	
	public void delete(Long id);

        public List<tbl_coordinacions> findAlltbl_coordinacions();
}
