package com.back.accesum.controlador;

import com.back.accesum.modelo.entity.Sedes;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.back.accesum.repositorio.SedesRepository;
import com.back.accesum.services.ISedesService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

//this is the sedes controller, with its endpoints
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/accesum")
@CrossOrigin(origins = "*")
public class SedesControllador {

    private final ISedesService sedesService;
    private final SedesRepository sedesRespository;
    
    @GetMapping("/sedes")
    public List<Sedes> findAll() {
        return sedesService.findAll();
    }
    
     @GetMapping("/sedes/{id}")
        public ResponseEntity<?> show(@PathVariable Long id) {

                Sedes sedes = null;
                Map<String, Object> response = new HashMap<>();

                try {
                        sedes = sedesService.findById(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar la consulta en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                if (sedes == null) {
                        response.put("mensaje", "La sede ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<Sedes>(sedes, HttpStatus.OK);
        }
    @PostMapping("/sede")
    public Sedes findById(@RequestBody Sedes sedes) {
        return sedesRespository.save(sedes);
    }
}
