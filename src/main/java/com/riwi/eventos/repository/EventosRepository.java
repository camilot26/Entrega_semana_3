package com.riwi.eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.eventos.entities.Eventos;
@Repository
public interface EventosRepository extends JpaRepository<Eventos,String> {
    



}
