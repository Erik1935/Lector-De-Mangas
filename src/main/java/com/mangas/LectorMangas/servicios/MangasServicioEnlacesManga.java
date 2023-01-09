package com.mangas.LectorMangas.servicios;
import com.mangas.LectorMangas.entidad.datosManga;
import com.mangas.LectorMangas.entidad.enlacesManga;
import com.mangas.LectorMangas.repositorio.MangasRepositorioDatosManga;
import com.mangas.LectorMangas.repositorio.MangasRepositorioEnlacesManga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class MangasServicioEnlacesManga {
    @Autowired
    private MangasRepositorioEnlacesManga repositorioEnlace;

    public List<enlacesManga> enlacesDeUnManga(Integer id) {
        return repositorioEnlace.enlacesmanga(id);
    }

    //Guardar
    public ResponseEntity<?> guardarEnlace(enlacesManga enlace) {
        try {
            repositorioEnlace.save(enlace);
            return new ResponseEntity<enlacesManga>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("e = " + e);
            return new ResponseEntity<enlacesManga>(HttpStatus.NOT_FOUND);
        }
    }

    public void eliminarEnlace(Integer id) {
        repositorioEnlace.deleteById(id);
    }

    public enlacesManga obtenerPorId(Integer id) {
        return repositorioEnlace.findById(id).get();
    }

    public ResponseEntity<?> actualizarEnlace(enlacesManga enlace,Integer id) {
        try {
            enlacesManga nuevoEnlace = repositorioEnlace.findById(id).get();
            nuevoEnlace.setEnlace(enlace.getEnlace());
            nuevoEnlace.setFechalectura(enlace.getFechalectura());
            repositorioEnlace.save(nuevoEnlace);
            return new ResponseEntity<enlacesManga>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<enlacesManga>(HttpStatus.NOT_FOUND);
        }
    }
    public void actualizarFechaEnlace(int id) {
            enlacesManga enlaceConFechaActualizada = repositorioEnlace.objetoEnlaceManga(id);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            enlaceConFechaActualizada.setFechalectura(dtf.format(LocalDateTime.now()));
            repositorioEnlace.save(enlaceConFechaActualizada);
    }
    public List<enlacesManga> todo(){
        List<enlacesManga> lista = repositorioEnlace.findAll();
        return lista;
    }

}
