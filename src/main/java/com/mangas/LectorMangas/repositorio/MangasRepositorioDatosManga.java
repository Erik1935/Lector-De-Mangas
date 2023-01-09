package com.mangas.LectorMangas.repositorio;

import com.mangas.LectorMangas.entidad.datosManga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MangasRepositorioDatosManga extends JpaRepository<datosManga,Integer> {

    @Query(value = "SELECT nombremanga,fotomanga FROM datosmanga WHERE id= :id", nativeQuery=true)
    List<String> datosById(Integer id);
    @Query(value = "SELECT nombremanga,fotomanga FROM datosmanga WHERE id= :id", nativeQuery=true)
    List<Object> datos(Integer id);//El metodo devuelve un objeto, podria castearlo
}
