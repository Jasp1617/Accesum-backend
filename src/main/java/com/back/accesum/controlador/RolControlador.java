package com.back.accesum.controlador;

import com.back.accesum.modelo.entity.Rol;
import com.back.accesum.repositorio.RolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//This is controller of sedes
@RestController
@RequestMapping("/accesum")
@CrossOrigin(origins = "*")
public class RolControlador {
    @Autowired
    RolRepository rolRepository;
    // this is for get all datas from rol table
    @GetMapping("/roles")
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }
    // this is for create new rol on our table
    @PostMapping("/rol")
    public Rol findById(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }
}
