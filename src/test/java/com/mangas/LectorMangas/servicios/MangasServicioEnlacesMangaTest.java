package com.mangas.LectorMangas.servicios;

import com.mangas.LectorMangas.entidad.enlacesManga;
import com.mangas.LectorMangas.repositorio.MangasRepositorioEnlacesManga;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MangasServicioEnlacesMangaTest {
    @Autowired
    private MangasRepositorioEnlacesManga enlaces;
    @Autowired
    private MangasServicioEnlacesManga serv;
    @Test
    public void pruebaEnlaces(){
       List<enlacesManga> enlacesDeMangas = enlaces.enlacesmanga(1);
        System.out.println("enlacesDeMangas.toString() = " + enlacesDeMangas.toString());
    }
    @Test
    public void pruebaDeFechas(){
        serv.actualizarFechaEnlace(1);
    }
}