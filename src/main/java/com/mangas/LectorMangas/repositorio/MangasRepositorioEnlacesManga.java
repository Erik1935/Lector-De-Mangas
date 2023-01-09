package com.mangas.LectorMangas.repositorio;

import com.mangas.LectorMangas.entidad.enlacesManga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MangasRepositorioEnlacesManga extends JpaRepository<enlacesManga,Integer> {
    //Obtener enlaces en base al Id Del manga que provee
    @Query(value = "SELECT * FROM enlacesmanga WHERE idmanga= :idmanga", nativeQuery=true)
    List<enlacesManga> enlacesmanga(Integer idmanga);
    @Query(value = "SELECT * FROM enlacesmanga WHERE id= :id", nativeQuery=true)
    enlacesManga objetoEnlaceManga(Integer id);
    //Editar los datos en base al id(Del link no del manga) que tiene el enlace
    //@Query(value = "SELECT id FROM enlacesmanga WHERE enlace= :enlace", nativeQuery=true)
    enlacesManga findByEnlace(String enlace);
    //El borrado ya esta dentro de JpaRepository- declarar en la clase servicio
}
