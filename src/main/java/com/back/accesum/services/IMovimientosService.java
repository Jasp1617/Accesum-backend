package com.back.accesum.services;


import com.back.accesum.modelo.entity.Movimientos;
import com.back.accesum.modelo.entity.Sedes;
import com.back.accesum.modelo.entity.User;
import java.util.List;


public interface IMovimientosService {
    public List<Movimientos> findAll();
    
    public List<User> findAllUser();
    
    public List<Sedes> findAllSedes();
    
    public Movimientos findById(Integer id);
    
    public Movimientos save(Movimientos movimientos);
    
    public void delete(Integer id);
}
