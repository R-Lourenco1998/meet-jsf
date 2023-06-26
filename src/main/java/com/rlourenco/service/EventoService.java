package com.rlourenco.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.rlourenco.entity.Evento;
import com.rlourenco.repository.EventoRepository;
import com.rlourenco.util.Transactional;

public class EventoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EventoRepository repository;

	@Transactional
	public void save(Evento evento) {
		repository.save(evento);
	}

	@Transactional
	public void delete(Evento evento) {
		repository.delete(evento);
	}

	public List<Evento> getAllEventos() {
		return repository.findAll();
	}
}
