package com.rlourenco.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rlourenco.entity.Evento;
import com.rlourenco.service.EventoService;

@Named
@SessionScoped
public class EventoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Evento evento = new Evento();

	@Inject
	private EventoService eventoService;

	private List<Evento> eventos = new ArrayList<Evento>();

	public void adicionarEvento() {
		eventoService.save(evento);
		//eventos.add(evento);
		System.out.println("Evento " + evento.getNome() + " cadastrado com sucesso!");
		clean();
		getAllEventos();
	}

	public void getAllEventos() {
		eventos = eventoService.getAllEventos();
	}

	public void clean() {
		this.evento = new Evento();
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

}
