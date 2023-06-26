package com.rlourenco.repository;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rlourenco.entity.Evento;

public class PersistanceLoader {

	public static void main(String[] args) throws ParseException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MeetManagerPU");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		EventoRepository eventoRepository = new EventoRepository(entityManager);

		Evento evento1 = new Evento();


		evento1.setNome("Confraternização");
		evento1.setLocal("Salão de festas");
		// evento1.setDeadline(deadline);
		evento1.setOrganizacao("FESTAS S.A");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date data = sdf.parse("15/06/2023");
			evento1.setData(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date horario = timeFormat.parse("14:30:00");
        evento1.setHorario(horario);

		eventoRepository.save(evento1);

		entityManager.getTransaction().commit();

		List<Evento> tasksLists = eventoRepository.findAll();
		System.out.println(tasksLists);

		entityManager.close();
		entityManagerFactory.close();

	}

}
