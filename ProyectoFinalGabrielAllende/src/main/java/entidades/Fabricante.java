package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the fabricante database table.
 * 
 */
//Entity nos dice que esta clase es una ENTIDAD, la cual será gestionada por Entity Manager
@Entity
//Table nos da las características de la tabla, en este caso el nombre de la misma.
@Table(name = "fabricante")
//Las consultas con nombre se definen junto con la entidad, utilizando la anotación @NamedQuery.
@NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f")
public class Fabricante implements Serializable {
	private static final long serialVersionUID = 1L;

	// Id y GeneratedValue van juntos, justo encima de la PK.
	// Id nos dice cuál es el atributo que se mapea con la clave primaria.
	// GeneratedValue nos indica la forma en la que se guarda la PK al insertar una
	// nueva
	// entidad en la tabla. IDENTITY es para aquellas tablas donde la pk es
	// auto_increment.
	@Id
	// EAGER (recupera el dato cuando se obtiene la entidad de la base de datos)
	// LAZY (recupera el dato cuando se accede al atributo).
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codfab;

	private String nomfab;

	private String paisfab;

	// bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy = "fabricante")
	private List<Vehiculo> vehiculos;

	public Fabricante() {
	}

	public int getCodfab() {
		return this.codfab;
	}

	public void setCodfab(int codfab) {
		this.codfab = codfab;
	}

	public String getNomfab() {
		return this.nomfab;
	}

	public void setNomfab(String nomfab) {
		this.nomfab = nomfab;
	}

	public String getPaisfab() {
		return this.paisfab;
	}

	public void setPaisfab(String paisfab) {
		this.paisfab = paisfab;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setFabricante(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setFabricante(null);

		return vehiculo;
	}

	// toString()
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nCódigo del fabricante: ");
		builder.append(codfab + " \n");
		builder.append("Nombre del fabricante: ");
		builder.append(nomfab + " \n");
		builder.append("País de origen del fabricante: ");
		builder.append(paisfab + " \n");
		builder.append(toStringVehiculos());
		return builder.toString();
	}

	private String toStringVehiculos() {
		StringBuilder builder = new StringBuilder();
		for (Vehiculo v : vehiculos) {
			builder.append("Cód. del vehículo: ").append(v.getCodvehi() + " \n");
		}
		return builder.toString();
	}
}