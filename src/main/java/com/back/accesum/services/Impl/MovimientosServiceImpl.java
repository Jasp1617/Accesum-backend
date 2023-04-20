package com.back.accesum.services.Impl;

import com.back.accesum.modelo.entity.Movimientos;
import com.back.accesum.modelo.entity.Sedes;
import com.back.accesum.modelo.entity.User;
import com.back.accesum.repositorio.MovimientosRepositorty;
import com.back.accesum.services.IMovimientosService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class MovimientosServiceImpl implements IMovimientosService{

    private final MovimientosRepositorty movimientosRepo;
    
    @Override
    public List<Movimientos> findAll() {
        return (List<Movimientos>) movimientosRepo.findAll();
    }

    @Override
    public List<User> findAllUser() {
        return movimientosRepo.findAllUsers();
    }

    @Override
    public List<Sedes> findAllSedes() {
        return movimientosRepo.findAllSedes();
    }

    @Override
    public Movimientos findById(Integer id) {
         return movimientosRepo.findById(id).orElse(null);
    }
    
    @Override
    public Movimientos save(Movimientos movimientos) {
        return movimientosRepo.save(movimientos);
    }

    @Override
    public void delete(Integer id) {
        movimientosRepo.deleteById(id);
    }


    
}
