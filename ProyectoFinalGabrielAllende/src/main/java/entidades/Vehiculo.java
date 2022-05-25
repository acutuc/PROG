package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@Table(name="vehiculo")
@NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codvehi;

	private boolean aireacon;

	private boolean automatico;

	private int caballos;

	private int puertas;

	// bi-directional many-to-one association to Fabricante
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codfab")
	private Fabricante fabricante;

	// bi-directional one-to-one association to Cliente
	@OneToOne(mappedBy = "vehiculo", fetch = FetchType.LAZY)
	private Cliente cliente;

	public Vehiculo() {
	}

	public int getCodvehi() {
		return codvehi;
	}

	public void setCodvehi(int codvehi) {
		this.codvehi = codvehi;
	}

	public boolean getAireacon() {
		return this.aireacon;
	}

	public void setAireacon(boolean aireacon) {
		this.aireacon = aireacon;
	}

	public boolean getAutomatico() {
		return this.automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	public int getCaballos() {
		return this.caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public int getPuertas() {
		return this.puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public Fabricante getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// toString()
	@Override
	public String toString() {
		String codCliente = (this.cliente != null) ? String.valueOf(this.cliente.getCodcli()) : "";
		String codFabricante = (this.fabricante != null) ? String.valueOf(this.fabricante.getCodfab()) : "";
		StringBuilder builder = new StringBuilder();
		builder.append("\nCódigo del vehículo: ");
		builder.append(codvehi + " \n");
		builder.append("Puertas: ");
		builder.append(puertas + " \n");
		builder.append("Transmisión: ");
		if (String.valueOf(this.automatico).equals(true)) {
			builder.append("automático \n");
		} else {
			builder.append("manual \n");
		}
		builder.append("Caballos: ");
		builder.append(caballos + " \n");
		builder.append("Aire acondicionado: ");
		if (String.valueOf(this.aireacon).equals(true)) {
			builder.append("Si \n");
		} else {
			builder.append("No \n");
		}
		builder.append("Alquilado por el cliente: ");
		if (codCliente.equals("")) {
			builder.append("Ningún cliente asociado \n");
		} else {
			builder.append(codCliente + " \n");
		}
		builder.append("Cód. del fabricante: ");
		builder.append(codFabricante + " \n");

		return builder.toString();
	}

}