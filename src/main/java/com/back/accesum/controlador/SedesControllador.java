package com.back.accesum.controlador;

import com.back.accesum.modelo.Sedes;
import com.back.accesum.repositorio.SedesRespository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//this is the sedes controller, with its endpoints
@RestController
@RequestMapping("/accesum")
@CrossOrigin(origins = "*")
public class SedesControllador {
    @Autowired
    SedesRespository sedesRespository;
    
    @GetMapping("/sedes")
    public List<Sedes> findAll() {
        return sedesRespository.findAll();
    }
    
    @PostMapping("/sede")
    public Sedes findById(@RequestBody Sedes sedes) {
        return sedesRespository.save(sedes);
    }
}
