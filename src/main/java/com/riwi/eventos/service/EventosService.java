package com.riwi.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.riwi.eventos.entities.Eventos;
import com.riwi.eventos.repository.EventosRepository;
import com.riwi.eventos.service.abstract_service.IeventosService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventosService implements IeventosService {

    @Autowired
    private final EventosRepository eventosRepository;

    @Override
    public Eventos Save(Eventos objEvent) {

        return this.eventosRepository.save(objEvent);

    }

    @Override
    public void delete(String id) {
        Eventos event = this.eventosRepository.findById(id).orElseThrow();
        this.eventosRepository.delete(event);
    }

    @Override
    public Eventos findById(String id) {

        return this.eventosRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<Eventos> getAll(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        Pageable pageable = PageRequest.of(page, size);

        return this.eventosRepository.findAll(pageable);

    }

    @Override
    public Eventos update(Eventos objEvent) {

        return this.eventosRepository.save(objEvent);
    }

}
