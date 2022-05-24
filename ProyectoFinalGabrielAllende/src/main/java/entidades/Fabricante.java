package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the fabricante database table.
 * 
 */
@Entity
@Table(name="fabricante")
@NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f")
public class Fabricante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
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
		builder.append("Código del fabricante: ");
		builder.append(codfab + "\n");
		builder.append("Nombre del fabricante: ");
		builder.append(nomfab + "\n");
		builder.append("País de origen del fabricante: ");
		builder.append(paisfab + "\n");
		return builder.toString();
	}

	private String toStringVehiculos() {
		StringBuilder builder = new StringBuilder();
		for (Vehiculo v : vehiculos) {
			builder.append("Cód. del vehículo: ").append(v.getCodvehi());
		}
		return builder.toString();
	}

}