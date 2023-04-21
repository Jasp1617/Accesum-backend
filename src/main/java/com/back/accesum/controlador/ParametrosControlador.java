package com.back.accesum.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import com.back.accesum.modelo.entity.Parametros;
import com.back.accesum.services.IParametrosService;

@RestController
@RequestMapping("/accesum")
@CrossOrigin(origins = "*")
public class ParametrosControlador {
        @Autowired
        private IParametrosService parametrosService;

        // @Autowired
        // private IUploadFileService uploadService;

        // This is for get all datas of tbl user
        @GetMapping("/parametros")
        public List<Parametros> findAll() {
                return parametrosService.findAll();
        }

        // this is for pagination

        // this is for search by id
        @GetMapping("/parametros/{id}")
        public ResponseEntity<?> show(@PathVariable Long id) {

                Parametros parametros = null;
                Map<String, Object> response = new HashMap<>();

                try {
                        parametros = parametrosService.findById(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar la consulta en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                if (parametros == null) {
                        response.put("mensaje", "El centro ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<Parametros>(parametros, HttpStatus.OK);
        }

        // This is for create new user
        @PostMapping("/parametros")
        public ResponseEntity<?> create(@Valid @RequestBody Parametros parametros, BindingResult result) {

                Parametros parametrosNew = null;
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
                        parametrosNew = parametrosService.save(parametros);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar el insertar en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "El parametros ha sido creado con éxito!");
                response.put("usuario", parametrosNew);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }

        // This is for Update a user
        @PutMapping("/parametros/{id}")
        public ResponseEntity<?> update(@Valid @RequestBody Parametros parametros, BindingResult result,
                        @PathVariable Long id) {

                Parametros parametrosActual = parametrosService.findById(id);

                Parametros parametrosUpdated = null;

                Map<String, Object> response = new HashMap<>();

                if (result.hasErrors()) {

                        List<String> errors = result.getFieldErrors()
                                        .stream()
                                        .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                                        .collect(Collectors.toList());

                        response.put("errors", errors);
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
                }

                if (parametrosActual == null) {
                        response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                try {

                        parametrosActual.setId_sedes(parametros.getId_sedes());
                        parametrosActual.setId_user(parametros.getId_user());
                        parametrosActual.setId_rol(parametros.getId_rol());

                        parametrosActual = parametrosService.save(parametrosActual);

                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al actualizar el usuario en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "parametros ha sido actualizado con éxito!");
                response.put("usuario", parametrosUpdated);

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }

        // Metodo para eliminar usuarios
        @DeleteMapping("/parametros/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {

                Map<String, Object> response = new HashMap<>();

                try {
                        // se puede utulizar o implementar para codigo QR
                        //Parametros parametros = parametrosService.findById(id);
                        // String nombreFotoAnterior = user.get();

                        // uploadService.eliminar(nombreFotoAnterior);

                        parametrosService.delete(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al eliminar el centros de la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "el parametros ha sido eliminado con éxito!");

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
}
