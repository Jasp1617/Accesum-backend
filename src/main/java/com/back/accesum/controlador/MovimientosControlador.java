package com.back.accesum.controlador;

import com.back.accesum.modelo.entity.Movimientos;
import com.back.accesum.services.IMovimientosService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/accesum")
@CrossOrigin(origins = "*")
public class MovimientosControlador {
    
      private final IMovimientosService movServices;
      //private final IUserService userService;
      //private final ISedesService sedesService;
      
      
      @GetMapping("/movimiento")
        public List<Movimientos> findAll() {
                return movServices.findAll();
        }


        // this is for search by id
        @GetMapping("/movimiento/{id}")
        public ResponseEntity<?> show(@PathVariable Integer id) {

                Movimientos movimientos = null;
                Map<String, Object> response = new HashMap<>();

                try {
                        movimientos = movServices.findById(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar la consulta en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                if (movimientos == null) {
                        response.put("mensaje", "El usuario ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<Movimientos>(movimientos, HttpStatus.OK);
        }

        // This is for create new user
        @PostMapping("/movimiento")
        public ResponseEntity<?> create(@Valid @RequestBody Movimientos movimientos, BindingResult result) {

                Movimientos movimientoNew = null;
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
                        movimientoNew = movServices.save(movimientos);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar el insert en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "El movimineto ha sido registrado con éxito!");
                response.put("movimiento", movimientoNew);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }

        // This is for Update a user
        @PutMapping("/movimiento/{id}")
        public ResponseEntity<?> update(@Valid @RequestBody Movimientos movimientos, BindingResult result, @PathVariable Integer id) {

                Movimientos movimientoActual = movServices.findById(id);

                Movimientos movimientosUpdated = null;

                Map<String, Object> response = new HashMap<>();

                if (result.hasErrors()) {

                        List<String> errors = result.getFieldErrors()
                                        .stream()
                                        .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                                        .collect(Collectors.toList());

                        response.put("errors", errors);
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
                }

                if (movimientoActual == null) {
                        response.put("mensaje", "Error: no se pudo editar, el movimiento ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                try {

                        //movimientoActual.setId_user(movimientos.getId_user());
                        movimientoActual.setFecha(movimientos.getFecha());
                        movimientoActual.setHora_entrada(movimientos.getHora_entrada());
                        movimientoActual.setHora_salida(movimientos.getHora_salida());
                        //movimientoActual.setId_sedes(movimientos.getId_sedes());

                        movimientosUpdated = movServices.save(movimientoActual);

                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al actualizar el usuario en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "El usuario ha sido actualizado con éxito!");
                response.put("usuario", movimientosUpdated);

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }

        // Metodo para eliminar usuarios
        @DeleteMapping("/movimientos/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {

                Map<String, Object> response = new HashMap<>();

                try {
                        // se puede utulizar o implementar para codigo QR
                        //Movimientos movimientos = movServices.findById(id);
                        // String nombreFotoAnterior = user.get();

                        // uploadService.eliminar(nombreFotoAnterior);

                        movServices.delete(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al eliminar el usuario de la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "El usuario ha sido eliminado con éxito!");

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
      

}
