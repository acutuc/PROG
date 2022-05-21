package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codvehi;

	private boolean automatico;

	private String marca;

	private String matricula;

	private String modelo;

	private int puertas;

	//A partir del codcli, podemos obtener a qué cliente pertenece este Vehículo, 
	//aunque en la BD no lo podamos obtener directamente.
	//bi-directional one-to-one association to Cliente
	@OneToOne(mappedBy="vehiculo", fetch=FetchType.LAZY)
	private Cliente cliente;

	//bi-directional many-to-one association to Mecanico
	@OneToMany(mappedBy="vehiculo")
	private List<Mecanico> mecanicos;

	//Constructor con sus atributos por defecto
	public Vehiculo() {
	}
	
	//Getters y setters.
	public int getCodvehi() {
		return codvehi;
	}

	public void setCodvehi(int codvehi) {
		this.codvehi = codvehi;
	}

	public boolean getAutomatico() {
		return this.automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPuertas() {
		return this.puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Mecanico> getMecanicos() {
		return this.mecanicos;
	}

	public void setMecanicos(List<Mecanico> mecanicos) {
		this.mecanicos = mecanicos;
	}

	public Mecanico addMecanico(Mecanico mecanico) {
		getMecanicos().add(mecanico);
		mecanico.setVehiculo(this);

		return mecanico;
	}

	public Mecanico removeMecanico(Mecanico mecanico) {
		getMecanicos().remove(mecanico);
		mecanico.setVehiculo(null);

		return mecanico;
	}

	//toString()
	@Override
	public String toString() {
		String codcli = (this.cliente != null) ? String.valueOf(this.cliente.getCodcli()) : "";
		StringBuilder builder = new StringBuilder();
		builder.append("Vehiculo [\nID: ");
		builder.append(codvehi);
		builder.append("\nTransmisión automática: ");
		builder.append(automatico);
		builder.append("\nMarca: ");
		builder.append(marca);
		builder.append("\nMatrícula: ");
		builder.append(matricula);
		builder.append("\nModelo: ");
		builder.append(modelo);
		builder.append("\nPuertas: ");
		builder.append(puertas);
		builder.append("\nCliente: ");
		builder.append(codcli);
		builder.append("\nMecánicos: ");
		builder.append(mecanicos + "\n]\n");
		return builder.toString();
	}
	
	

}