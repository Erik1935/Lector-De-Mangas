package com.mangas.LectorMangas.controlador;

import com.mangas.LectorMangas.entidad.datosManga;
import com.mangas.LectorMangas.entidad.enlacesManga;
import com.mangas.LectorMangas.servicios.MangasServicioEnlacesManga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controladorEnlacesManga {
    @Autowired
    private MangasServicioEnlacesManga servicioEnlaces;

    @GetMapping("/Obtener-Enlaces")
    public List<enlacesManga> obtenerTodo(){
        return servicioEnlaces.todo();
    }


    @GetMapping("/Obtener-Enlaces/{id}")
    public List<enlacesManga> obtener(@PathVariable Integer id){
        return servicioEnlaces.enlacesDeUnManga(id);
    }

    @PutMapping("/Actualizar-Enlace/{id}")
    public ResponseEntity<?> actualizar(@RequestBody enlacesManga enlace, @PathVariable Integer id){
     return servicioEnlaces.actualizarEnlace(enlace,id);
    }

    @PutMapping("/Actualizar-Fecha/{id}")
    public ResponseEntity<?> actualizarFecha(@PathVariable int id){
        try{
            servicioEnlaces.actualizarFechaEnlace(id);
            return new ResponseEntity<enlacesManga>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<enlacesManga>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Guardar-Enlace")
    public ResponseEntity<?> guardar(@RequestBody enlacesManga enlace) {
       return servicioEnlaces.guardarEnlace(enlace);
    }

    @DeleteMapping("/Borrar-Enlace/{id}")
    public void borrar(@PathVariable Integer id){
        servicioEnlaces.eliminarEnlace(id);
    }
}
