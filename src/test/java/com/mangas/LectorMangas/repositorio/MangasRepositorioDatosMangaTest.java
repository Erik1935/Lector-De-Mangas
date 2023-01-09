package com.mangas.LectorMangas.repositorio;

import com.mangas.LectorMangas.entidad.datosManga;
import com.mangas.LectorMangas.servicios.MangasServicioDatosManga;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MangasRepositorioDatosMangaTest {
    @Autowired
    private MangasServicioDatosManga repositorio;

    @Test
    public void queryPrueba(){
       List<Object> lista = repositorio.pruebaConObject(1);
        System.out.println("lista = " + lista);
    }
    @Test
    public void queryPruebafindAll(){
        List<datosManga> lista = repositorio.listarDatosManga();
        System.out.println("lista = " + lista);
    }
    @Test
    public void obtenerDatos(){
        List<String> datos = repositorio.obtenerAlgunosDatos((Integer) 1);
        System.out.println("datos = " + datos);
    }
    @Test
    public void guardarDatos(){
        /*datosManga datos = new datosManga().builder()
                .nombre("Numer 2j")
                .foto("ninguna foton")
                .ultimoCapLeido(23)
                .build();
        repositorio.guardar(datos);*/
    }
}