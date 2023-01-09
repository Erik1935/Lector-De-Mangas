package com.mangas.LectorMangas.repositorio;



import com.mangas.LectorMangas.entidad.enlacesManga;
import com.mangas.LectorMangas.servicios.MangasServicioEnlacesManga;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
class MangasRepositorioEnlacesMangaTest {
@Autowired
private MangasServicioEnlacesManga repositorio;

    @Test
    public void metodo() {
        List<enlacesManga> enlaces = repositorio.enlacesDeUnManga(1);
        System.out.println("enlaces = " + enlaces);
        }
        }
