package com.riwi.eventos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.riwi.eventos.entities.Eventos;
import com.riwi.eventos.service.abstract_service.IeventosService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/eventos")
public class EventosController {
    @Autowired
    private final IeventosService Ieventosservice;

    @GetMapping
    public ResponseEntity<Page<Eventos>> getEventos(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<Eventos> eventos = Ieventosservice.getAll(page-1, size);

        return ResponseEntity.ok(eventos);
    }

    @PostMapping()
    public ResponseEntity<Eventos> create(@RequestBody Eventos evento) {
        evento.getFecha();
        LocalDate fechaactual= LocalDate.now();
        if(evento.getFecha().isBefore(fechaactual)&&evento.getCapacidad()>0)  {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(Ieventosservice.Save(evento)); //
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.Ieventosservice.delete(id); 
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Eventos> update(
        @RequestBody Eventos evento,
        @PathVariable String id
    ){
        LocalDate fechaactual= LocalDate.now();
        if(evento.getFecha().isBefore(fechaactual)&&evento.getCapacidad()>0)  {
            return ResponseEntity.badRequest().build();
        }
  
        return ResponseEntity.ok(this.Ieventosservice.update(evento));
    }
    

    
}
    