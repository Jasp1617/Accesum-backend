package com.back.accesum.controlador;

import com.back.accesum.modelo.tbl_fichas;
import com.back.accesum.services.IFichasService;
import com.back.accesum.services.IUploadFileService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge Silva Helmunt Urueta Jordan Hernandez Equipo Back-end
 */

@RestController
@RequestMapping("/accesum")
@CrossOrigin( origins = "*")
public class FichasControlador {
    @Autowired
    private IFichasService fichasService;
    
    @Autowired
	private IUploadFileService uploadService;
    // This is for get all datas of tbl user
    @GetMapping("/fichas")
    public List<tbl_fichas> findAll() {
        return fichasService.findAll();
    }
    // this is for pagination
    @GetMapping("/fichas/page/{page}")
    public Page<tbl_fichas> index(@PathVariable Integer page) {
            Pageable pageable = PageRequest.of(page, 4);
            return fichasService.findAll(pageable);
    }
    
    // this is for search by id 
    @GetMapping("/fichas/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

            tbl_fichas fichas = null;
            Map<String, Object> response = new HashMap<>();

            try {
                    fichas = fichasService.findById(id);
            } catch(DataAccessException e) {
                    response.put("mensaje", "Error al realizar la consulta en la base de datos");
                    response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if(fichas == null) {
                    response.put("mensaje", "El usuario ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<tbl_fichas>(fichas, HttpStatus.OK);
    }
    // This is for create new user 
    @PostMapping("/fichas")
    public ResponseEntity<?> create(@Valid @RequestBody tbl_fichas fichas, BindingResult result) {

            tbl_fichas fichasNew = null;
            Map<String, Object> response = new HashMap<>();

            if(result.hasErrors()) {

                    List<String> errors = result.getFieldErrors()
                                    .stream()
                                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                                    .collect(Collectors.toList());

                    response.put("errors", errors);
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
            }

            try {
                    fichasNew = fichasService.save(fichas);
            } catch(DataAccessException e) {
                    response.put("mensaje", "Error al realizar el insert en la base de datos");
                    response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            response.put("mensaje", "El usuario ha sido creado con éxito!");
            response.put("usuario", fichasNew);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
   
    // This is for Update a user
    @PutMapping("/fichas/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody tbl_fichas fichas, BindingResult result, @PathVariable Long id) {

		tbl_fichas fichasActual = fichasService.findById(id);

		tbl_fichas fichasUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (fichasActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			fichasActual.setTbl_fichas_codigo(fichas.getTbl_fichas_codigo());
                        fichasActual.setFichas_grupo(fichas.getFichas_grupo());
			fichasActual.setPrograma(fichas.getPrograma());
                        fichasActual.setTbl_fichas_tbl_coordinacions(fichas.getTbl_fichas_tbl_coordinacions());


			fichasUpdated = fichasService.save(fichasActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "ficha ficha ha sido actualizado con éxito!");
		response.put("usuario", fichasUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
        
        // Metodo para eliminar usuarios
        @DeleteMapping("/fichas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
                    // se puede utulizar o implementar para codigo QR
			tbl_fichas fichas = fichasService.findById(id);
			//String nombreFotoAnterior = user.get();
			
			//uploadService.eliminar(nombreFotoAnterior);
			
		    fichasService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la ficha de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La ficha ha sido eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
