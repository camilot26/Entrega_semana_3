package com.riwi.eventos.service.abstract_service;



import org.springframework.data.domain.Page;

import com.riwi.eventos.entities.Eventos;

public interface IeventosService {
    public Eventos Save(Eventos objEvent);
    public Eventos update(Eventos objEvent);
    public void delete(String id);
    public Eventos findById(String id);
    public Page<Eventos>getAll(int page, int size);
}
