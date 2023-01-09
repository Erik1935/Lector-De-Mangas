package com.mangas.LectorMangas.controlador;

import com.mangas.LectorMangas.entidad.datosManga;
import com.mangas.LectorMangas.servicios.MangasServicioDatosManga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controladorDatosManga {
    @Autowired
    private MangasServicioDatosManga mangas;

    @GetMapping("/Datos-Mangas")
    public List<datosManga>obtenerMangas(){
        return mangas.listarDatosManga();
    }

    @GetMapping("/Obtener-Datos/{id}")
    public datosManga obtenerPorId(@PathVariable Integer id){
        return mangas.obtenerPorId(id);
    }

    @PostMapping("/Guardar-Mangas")
    public void guardar(@RequestBody datosManga datosmanga){
        mangas.guardar(datosmanga);
    }

    @PutMapping("/Actualizar-Datos-Mangas/{id}")
    public ResponseEntity<?> actualizarDatos(@RequestBody datosManga datos, @PathVariable Integer id){
        try{
            datosManga mangaExistente = mangas.obtenerPorId(id);
            mangaExistente.setNombre(datos.getNombre());
            mangaExistente.setFoto(datos.getFoto());
            mangaExistente.setUltimoCapLeido(datos.getUltimoCapLeido());
            mangas.guardar(mangaExistente);
            return new ResponseEntity<datosManga>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<datosManga>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Borrar-Manga/{id}")
    public void borrarManga(@PathVariable Integer id){
        mangas.eliminarProducto(id);
    }

}
