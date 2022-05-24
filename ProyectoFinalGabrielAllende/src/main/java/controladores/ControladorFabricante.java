package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Fabricante;

//Definición de la clase
public class ControladorFabricante {
	//Atributos de la clase
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("ProyectoFinalGabrielAllende");
	private EntityManager em;
	private Query consulta;

	// Métodos
	public void borrarFabricante(Fabricante f) {
		this.em = entityManagerFactory.createEntityManager();
		Fabricante aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(f)) {
			aux = this.em.merge(f);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public void modificarFabricante(Fabricante f) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(f);
		this.em.getTransaction().commit();
		this.em.close();

	}

	public void crearFabricante(Fabricante f) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(f);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public Fabricante findByPK(int codfab) {
		this.em = entityManagerFactory.createEntityManager();
		Fabricante aux = null;
		this.consulta = em.createNativeQuery("SELECT * FROM Fabricante WHERE codfab = ?", Fabricante.class);
		this.consulta.setParameter(1, codfab);
		try {
			aux = (Fabricante) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}
		this.em.close();
		return aux;

	}
	
	public List<Fabricante> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Fabricante.findAll");
		List<Fabricante> lista = (List<Fabricante>) consulta.getResultList();
		this.em.close();
		return lista;
	}
}
