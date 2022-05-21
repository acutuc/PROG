package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the mecanico database table.
 * 
 */
@Entity
@NamedQuery(name = "Mecanico.findAll", query = "SELECT m FROM Mecanico m")
public class Mecanico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codmec;

	private String ape1mec;

	private String ape2mec;

	private String nommec;

	// bi-directional many-to-one association to Vehiculo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codvehi", referencedColumnName = "codvehi")
	private Vehiculo vehiculo;

	// Constructor con sus atributos por defecto.
	public Mecanico() {
	}

	// Getters y setters.
	public int getCodmec() {
		return this.codmec;
	}

	public void setCodmec(int codmec) {
		this.codmec = codmec;
	}

	public String getApe1mec() {
		return this.ape1mec;
	}

	public void setApe1mec(String ape1mec) {
		this.ape1mec = ape1mec;
	}

	public String getApe2mec() {
		return this.ape2mec;
	}

	public void setApe2mec(String ape2mec) {
		this.ape2mec = ape2mec;
	}

	public String getNommec() {
		return this.nommec;
	}

	public void setNommec(String nommec) {
		this.nommec = nommec;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	// toString()
	@Override
	public String toString() {
		String codvehi = (this.vehiculo != null) ? String.valueOf(this.vehiculo.getCodvehi()) : "";
		StringBuilder builder = new StringBuilder();
		builder.append("Mecanico [\nID: ");
		builder.append(codmec);
		builder.append("\nPrimer apellido: ");
		builder.append(ape1mec);
		builder.append("\nSegundo apellido: ");
		builder.append(ape2mec);
		builder.append("\nNombre: ");
		builder.append(nommec);
		builder.append("\nTrabaja en el vehículo: ");
		if (codvehi.equals("")) {
			builder.append("Actualmente no tiene asignado un vehículo para reparar.");
		} else {
			builder.append(codvehi);
		}
		builder.append("\n]\n");
		return builder.toString();
	}

}