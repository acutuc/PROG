package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ape1cli;

	private String ape2cli;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codcli;

	private String nomcli;

	private String telcli;

	// bi-directional one-to-one association to Vehiculo
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codvehi", referencedColumnName = "codvehi")
	private Vehiculo vehiculo;

	public Cliente() {
	}

	public String getApe1cli() {
		return this.ape1cli;
	}

	public void setApe1cli(String ape1cli) {
		this.ape1cli = ape1cli;
	}

	public String getApe2cli() {
		return this.ape2cli;
	}

	public void setApe2cli(String ape2cli) {
		this.ape2cli = ape2cli;
	}

	public int getCodcli() {
		return this.codcli;
	}

	public void setCodcli(int codcli) {
		this.codcli = codcli;
	}

	public String getNomcli() {
		return this.nomcli;
	}

	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}

	public String getTelcli() {
		return this.telcli;
	}

	public void setTelcli(String telcli) {
		this.telcli = telcli;
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
		builder.append("Código de cliente: ");
		builder.append(codcli + "\n");
		builder.append("Nombre: ");
		builder.append(nomcli + "\n");
		builder.append("Primer apellido: ");
		builder.append(ape1cli + "\n");
		builder.append("Segundo apellido");
		builder.append(ape2cli + "\n");
		builder.append("Teléfono: ");
		builder.append(telcli + "\n");
		builder.append("Vehículo alquilado: ");
		builder.append(codvehi + "\n");
		return builder.toString();
	}

}