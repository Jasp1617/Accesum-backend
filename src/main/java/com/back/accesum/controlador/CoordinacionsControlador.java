package com.back.accesum.controlador;

import com.back.accesum.modelo.entity.tbl_coordinacions;
import com.back.accesum.services.ICoordinacionsService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
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


// @author Jorge Silva Helmunt Urueta Jordan Hernandez Equipo Back-end

// This is a api controller from table Coordinacions
@RestController
@RequestMapping("/accesum")
@CrossOrigin(origins = "*")
public class CoordinacionsControlador {
        @Autowired
        private ICoordinacionsService coordinacionsService;

       //@Autowired
        //private IUploadFileService uploadService;

        // This is for get all datas of tbl user
        @GetMapping("/coordinacion")
        public List<tbl_coordinacions> findAll() {
                return coordinacionsService.findAll();
        }

        // this is for pagination
        @GetMapping("/coordinacions/page/{page}")
        public Page<tbl_coordinacions> index(@PathVariable Integer page) {
                Pageable pageable = PageRequest.of(page, 4) ;
                return coordinacionsService.findAll(pageable);
        }

        // this is for search by id
        @GetMapping("/coordinacions/{id}")
        public ResponseEntity<?> show(@PathVariable Long id) {

                tbl_coordinacions coordinacions = null;
                Map<String, Object> response = new HashMap<>();

                try {
                        coordinacions = coordinacionsService.findById(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar la consulta en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                if (coordinacions == null) {
                        response.put("mensaje", "El usuario ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<tbl_coordinacions>(coordinacions, HttpStatus.OK);
        }

        // This is for create new user
        @PostMapping("/coordinacions")
        public ResponseEntity<?> create(@Valid @RequestBody tbl_coordinacions coordinacions, BindingResult result) {

                tbl_coordinacions coordinacionsNew = null;
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
                        coordinacionsNew = coordinacionsService.save(coordinacions);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar el insertar en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "El usuario ha sido creado con éxito!");
                response.put("usuario", coordinacionsNew);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }

        // This is for Update a user
        @PutMapping("/coordinacions/{id}")
        public ResponseEntity<?> update(@Valid @RequestBody tbl_coordinacions coordinacions, BindingResult result,
                        @PathVariable Long id) {

                tbl_coordinacions coordinacionsActual = coordinacionsService.findById(id);

                tbl_coordinacions coordinacionsUpdated = null;

                Map<String, Object> response = new HashMap<>();

                if (result.hasErrors()) {

                        List<String> errors = result.getFieldErrors()
                                        .stream()
                                        .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                                        .collect(Collectors.toList());

                        response.put("errors", errors);
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
                }

                if (coordinacionsActual == null) {
                        response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                try {

                        coordinacionsActual.setTbl_coordinacions_codigo(coordinacions.getTbl_coordinacions_codigo());
                        coordinacionsActual.setTbl_coordinacions_nombre(coordinacions.getTbl_coordinacions_nombre());
                        coordinacionsActual.setTbl_coordinacions_coordinador(coordinacions.getTbl_coordinacions_coordinador());
                        coordinacionsActual.setTbl_coordinacions_tbl_centros_id(coordinacions.getTbl_coordinacions_tbl_centros_id());

                        coordinacionsUpdated = coordinacionsService.save(coordinacionsActual);

                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al actualizar el usuario en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "Coordinacion ha sido actualizado con éxito!");
                response.put("usuario", coordinacionsUpdated);

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }

        // Metodo para eliminar usuarios
        @DeleteMapping("/coordinacions/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {

                Map<String, Object> response = new HashMap<>();

                try {
                        // se puede utulizar o implementar para codigo QR
                        //tbl_coordinacions coordinacions = coordinacionsService.findById(id);
                        // String nombreFotoAnterior = user.get();

                        // uploadService.eliminar(nombreFotoAnterior);

                        coordinacionsService.delete(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al eliminar la ficha de la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "La coordinacions ha sido eliminado con éxito!");

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
}
