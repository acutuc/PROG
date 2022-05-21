package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Mecanico;

//Definición de la clase
public class ControladorMecanico {
	//Atributos de la clase
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("ProyectoFinalGabrielAllende");
	private EntityManager em;
	private Query consulta;

	// Métodos
	public void borrarMecanico(Mecanico m) {
		this.em = entityManagerFactory.createEntityManager();
		Mecanico aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(m)) {
			aux = this.em.merge(m);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public void modificarMecanico(Mecanico m) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(m);
		this.em.getTransaction().commit();
		this.em.close();

	}

	public void crearMecanico(Mecanico m) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(m);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public Mecanico findByPK(int codmec) {
		this.em = entityManagerFactory.createEntityManager();
		Mecanico aux = null;
		this.consulta = em.createNativeQuery("SELECT * FROM mecanico WHERE codmec = ?", Mecanico.class);
		this.consulta.setParameter(1, codmec);
		try {
			aux = (Mecanico) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}
		this.em.close();
		return aux;

	}
	
	public List<Mecanico> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Mecanico.findAll");
		List<Mecanico> lista = (List<Mecanico>) consulta.getResultList();
		this.em.close();
		return lista;
	}
}
