package com.mangas.LectorMangas.servicios;

import com.mangas.LectorMangas.entidad.datosManga;
import com.mangas.LectorMangas.repositorio.MangasRepositorioDatosManga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangasServicioDatosManga {
    @Autowired
    private MangasRepositorioDatosManga repositorio;

    //Obtener todos los datos de los mangas
    public List<datosManga> listarDatosManga(){
        return repositorio.findAll();
    }
    //Obtener elementos por id
    public datosManga obtenerPorId(Integer id){
        return repositorio.findById(id).get();
    }
    //Guardar animes
    public void guardar(datosManga datos){
        repositorio.save(datos);
    }
    public void eliminarProducto(Integer id){
        repositorio.deleteById(id);
    }
    public List<String> obtenerAlgunosDatos(Integer id){
        return repositorio.datosById(id);
    }
    public List<Object>pruebaConObject(Integer id){//Experimental. Por validar aun no utilizar
        return repositorio.datos(id);
    }
}
