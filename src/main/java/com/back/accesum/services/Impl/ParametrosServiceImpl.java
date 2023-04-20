package com.back.accesum.services.Impl;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.back.accesum.modelo.entity.Parametros;
import com.back.accesum.modelo.entity.Rol;
import com.back.accesum.modelo.entity.Sedes;
import com.back.accesum.modelo.entity.User;
import com.back.accesum.repositorio.ParametrosRepository;
import com.back.accesum.services.IParametrosService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class ParametrosServiceImpl implements IParametrosService {

    private final ParametrosRepository parametrosRepo;

    @Override
    public List<Parametros> findAll() {
        return (List<Parametros>) parametrosRepo.findAll();
    }

    @Override
    public Parametros findById(Long id) {
        return parametrosRepo.findById(id).orElse(null);
    }

    @Override
    public Parametros save(Parametros parametros) {
        return parametrosRepo.save(parametros);
    }

    @Override
    public void delete(Long id) {
        parametrosRepo.deleteById(id);
    }

    @Override
    public List<User> findAllUser() {
        return parametrosRepo.findAllUsers();
    }

    @Override
    public List<Rol> findAllRols() {
        return parametrosRepo.findAllRols();
    }

    @Override
    public List<Sedes> findAllSedes() {
        return parametrosRepo.findAllSedes();
    }

    @Override
    public Page<Parametros> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
