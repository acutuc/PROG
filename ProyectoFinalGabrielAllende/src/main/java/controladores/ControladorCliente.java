package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Cliente;

//Definición de la clase.
public class ControladorCliente {
	// Atributos de la clase
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("ProyectoFinalGabrielAllende");
	private EntityManager em;
	private Query consulta;

	//Método que elimina un cliente
	public void borrarCliente(Cliente c) {
		this.em = entityManagerFactory.createEntityManager();
		Cliente aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(c)) {
			aux = this.em.merge(c);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	//Método que modifica un cliente.
	public void modificarCliente(Cliente c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}

	//Método que persiste un cliente.
	public void crearCliente(Cliente c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
		this.em.close();
	}

	//Método que localiza un cliente por su PK.
	public Cliente findByPK(int codcli) {
		this.em = entityManagerFactory.createEntityManager();
		Cliente aux = null;
		this.consulta = em.createNativeQuery("SELECT * FROM cliente WHERE codcli = ?", Cliente.class);
		this.consulta.setParameter(1, codcli);
		try {
			aux = (Cliente) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}
		this.em.close();
		return aux;

	}

	//Método que localiza un cliente por su num. de teléfono.
	public Cliente findByTelefono(String telcli) {
		this.em = entityManagerFactory.createEntityManager();
		Cliente aux = null;
		this.consulta = em.createNativeQuery("SELECT * FROM cliente WHERE telcli = ?", Cliente.class);
		this.consulta.setParameter(1, telcli);
		try {
			aux = (Cliente) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}
		this.em.close();
		return aux;

	}

	//Método que nos devuelve una List con todos los registros de la tabla cliente.
	public List<Cliente> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Cliente.findAll");
		List<Cliente> lista = (List<Cliente>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}