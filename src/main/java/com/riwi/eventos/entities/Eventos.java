package com.riwi.eventos.entities;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "eventos1")
@Data //crear los get and set
@AllArgsConstructor // Crear constructor de la clase completo
@NoArgsConstructor  //crear constructor vacio de la clase.
public class Eventos {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;
    private String nombre;
    private LocalDate fecha;
    private String ubicacion;
    private int capacidad;

}
