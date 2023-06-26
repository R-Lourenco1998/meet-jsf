package com.rlourenco.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.rlourenco.entity.Evento;

public class EventoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public EventoRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EventoRepository() {
	}
	
	public Evento findById(Long id) {
		return entityManager.find(Evento.class, id);
	}
	
	public List<Evento> findAll() {
		TypedQuery<Evento> query = entityManager.createQuery("SELECT e FROM Evento e ORDER BY e.id", Evento.class);
		return query.getResultList();
	}
	
	public Evento save(Evento evento) {
		return entityManager.merge(evento);
	}

	public void delete(Evento evento) {
		evento = findById(evento.getId());
		entityManager.remove(evento);
	}

}
