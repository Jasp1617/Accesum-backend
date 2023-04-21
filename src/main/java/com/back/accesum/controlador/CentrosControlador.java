package com.back.accesum.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.accesum.modelo.entity.Centros;
import com.back.accesum.services.ICentrosService;

// @author Jorge Silva Helmunt Urueta Jordan Hernandez Equipo Back-end

// This is a api controller from table Centros
@RestController
@RequestMapping("/accesum")
@CrossOrigin(origins = "*")
public class CentrosControlador {
        @Autowired
        private ICentrosService centrosService;

        // @Autowired
        // private IUploadFileService uploadService;

        // This is for get all datas of tbl user
        @GetMapping("/centros")
        public List<Centros> findAll() {
                return centrosService.findAll();
        }

        // this is for pagination
        @GetMapping("/centros/page/{page}")
        public Page<Centros> index(@PathVariable Integer page) {
                Pageable pageable = PageRequest.of(page, 4);
                return centrosService.findAll(pageable);
        }

        // this is for search by id
        @GetMapping("/centros/{id}")
        public ResponseEntity<?> show(@PathVariable Long id) {

                Centros centros = null;
                Map<String, Object> response = new HashMap<>();

                try {
                        centros = centrosService.findById(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar la consulta en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                if (centros == null) {
                        response.put("mensaje", "El centro ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<Centros>(centros, HttpStatus.OK);
        }

        // This is for create new user
        @PostMapping("/centros")
        public ResponseEntity<?> create(@Valid @RequestBody Centros centros, BindingResult result) {

                Centros centrosNew = null;
                Map<String, Object> response = new HashMap<>();

                if (result.hasErrors()) {

                        List<String> errors = result.getFieldErrors()
                                        .stream()
                                        .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                                        .collect(Collectors.toList());

                        response.put("errors", errors);
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
                }

                try {
                        centrosNew = centrosService.save(centros);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar el insertar en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "El centro ha sido creado con éxito!");
                response.put("usuario", centrosNew);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }

        // This is for Update a user
        @PutMapping("/centros/{id}")
        public ResponseEntity<?> update(@Valid @RequestBody Centros centros, BindingResult result,
                        @PathVariable Long id) {

                Centros centrosActual = centrosService.findById(id);

                Centros centrosUpdated = null;

                Map<String, Object> response = new HashMap<>();

                if (result.hasErrors()) {

                        List<String> errors = result.getFieldErrors()
                                        .stream()
                                        .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                                        .collect(Collectors.toList());

                        response.put("errors", errors);
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
                }

                if (centrosActual == null) {
                        response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                try {

                        centrosActual.setTbl_centros_codigo(centros.getTbl_centros_codigo());
                        centrosActual.setTbl_centros_nombre(centros.getTbl_centros_nombre());
                        centrosActual.setTbl_centros_tbl_regionals_id(centros.getTbl_centros_tbl_regionals_id());

                        centrosUpdated = centrosService.save(centrosActual);

                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al actualizar el usuario en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "centros ha sido actualizado con éxito!");
                response.put("usuario", centrosUpdated);

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }

        // Metodo para eliminar usuarios
        @DeleteMapping("/centros/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {

                Map<String, Object> response = new HashMap<>();

                try {
                        // se puede utulizar o implementar para codigo QR
                        //Centros coordinacions = centrosService.findById(id);
                        // String nombreFotoAnterior = user.get();

                        // uploadService.eliminar(nombreFotoAnterior);

                        centrosService.delete(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al eliminar el centros de la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "el centros ha sido eliminado con éxito!");

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
}
