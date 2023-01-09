package com.mangas.LectorMangas.entidad;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "datosmanga")
@Getter @Setter
public class datosManga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombremanga")
    private String nombre;

    @Column(name = "fotomanga")
    private String foto;

    @Column(name = "ultimocapleido")
    private int ultimoCapLeido;

    @OneToMany(mappedBy = "id_manga",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<enlacesManga> enlaces;

}
