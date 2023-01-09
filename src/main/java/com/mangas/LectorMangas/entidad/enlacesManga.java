package com.mangas.LectorMangas.entidad;


import com.fasterxml.jackson.annotation.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "enlacesmanga")
@Getter @Setter
public class enlacesManga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String enlace;
    private String fechalectura;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn (name = "idmanga",referencedColumnName = "id")
    @JsonProperty(access = Access.WRITE_ONLY)
    //@JsonIgnore
    private datosManga id_manga;
    }

