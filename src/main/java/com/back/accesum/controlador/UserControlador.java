package com.back.accesum.controlador;

import com.back.accesum.modelo.entity.User;
import com.back.accesum.services.IUserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

//this is the user controller with its endpoints
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/accesum")
@CrossOrigin(origins = "*")
public class UserControlador {

        private final IUserService userService;
        //private final IFichasService fichasService;
        //private final IUploadFileService uploadService;

        // This is for get all datas of tbl user
        @GetMapping("/usuarios")
        public List<User> findAll() {
                return userService.findAll();
        }

        // this is for pagination
        @GetMapping("/usuarios/page/{page}")
        public Page<User> index(@PathVariable Integer page) {
                Pageable pageable = PageRequest.of(page, 4);
                return userService.findAll(pageable);
        }

        // this is for search by id
        @GetMapping("/usuarios/{id}")
        public ResponseEntity<?> show(@PathVariable Long id) {

                User user = null;
                Map<String, Object> response = new HashMap<>();

                try {
                        user = userService.findById(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar la consulta en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                if (user == null) {
                        response.put("mensaje", "El usuario ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<User>(user, HttpStatus.OK);
        }

        // This is for create new user
        @PostMapping("/usuarios")
        public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {

                User userNew = null;
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
                        userNew = userService.save(user);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al realizar el insert en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "El usuario ha sido creado con éxito!");
                response.put("usuario", userNew);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }

        // This is for Update a user
        @PutMapping("/usuarios/{id}")
        public ResponseEntity<?> update(@Valid @RequestBody User user, BindingResult result, @PathVariable Long id) {

                User userActual = userService.findById(id);

                User userUpdated = null;

                Map<String, Object> response = new HashMap<>();

                if (result.hasErrors()) {

                        List<String> errors = result.getFieldErrors()
                                        .stream()
                                        .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                                        .collect(Collectors.toList());

                        response.put("errors", errors);
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
                }

                if (userActual == null) {
                        response.put("mensaje", "Error: no se pudo editar, el Usuario ID: "
                                        .concat(id.toString().concat(" no existe en la base de datos!")));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }

                try {

                        userActual.setNombre(user.getNombre());
                        userActual.setDocument(user.getDocument());
                        userActual.setEmail(user.getEmail());
                        userActual.setPassword(user.getPassword());
                        userActual.setTbl_fichas(user.getTbl_fichas());
                        userActual.setDetalles(user.getDetalles());

                        userUpdated = userService.save(userActual);

                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al actualizar el usuario en la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "El usuario ha sido actualizado con éxito!");
                response.put("usuario", userUpdated);

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }

        // Metodo para eliminar usuarios
        @DeleteMapping("/usuarios/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id) {

                Map<String, Object> response = new HashMap<>();

                try {
                        // se puede utulizar o implementar para codigo QR
                        //User user = userService.findById(id);
                        // String nombreFotoAnterior = user.get();

                        // uploadService.eliminar(nombreFotoAnterior);

                        userService.delete(id);
                } catch (DataAccessException e) {
                        response.put("mensaje", "Error al eliminar el usuario de la base de datos");
                        response.put("error",
                                        e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "El usuario ha sido eliminado con éxito!");

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        /*
         * // this is for get all datas of tbl_fichas
         * 
         * @GetMapping("/usuarios/fichas")
         * public List<tbl_fichas> listartbl_fichas(){
         * return fichasService.findAll();
         * }
         */
}
