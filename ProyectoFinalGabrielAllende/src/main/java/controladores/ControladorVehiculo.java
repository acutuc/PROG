package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Vehiculo;

//Definición de la clase.
public class ControladorVehiculo {
	//Atributos de la clase.
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("ProyectoFinalGabrielAllende");
	private EntityManager em;
	private Query consulta;

	// Métodos
	public void borrarVehiculo(Vehiculo v) {
		this.em = entityManagerFactory.createEntityManager();
		Vehiculo aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(v)) {
			aux = this.em.merge(v);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public void modificarVehiculo(Vehiculo v) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(v);
		this.em.getTransaction().commit();
		this.em.close();

	}

	public void crearVehiculo(Vehiculo v) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(v);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public Vehiculo findByPK(int codvehi) {
		this.em = entityManagerFactory.createEntityManager();
		Vehiculo aux = null;
		this.consulta = em.createNativeQuery("SELECT * FROM vehiculo WHERE codvehi = ?", Vehiculo.class);
		this.consulta.setParameter(1, codvehi);
		try {
			aux = (Vehiculo) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}
		this.em.close();
		return aux;

	}

	public List<Vehiculo> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Vehiculo.findAll");
		List<Vehiculo> lista = (List<Vehiculo>) consulta.getResultList();
		this.em.close();
		return lista;
	}
}
