package ejercicio1;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author acutuc
 */
//Definición de la clase. CLASE POJO
public class Crucero {
	// Atributos de la clase
	private String nombre;
	private ArrayList<String> destinos;
	private double precio;
	private int numeroNoches;
	private String puertoSalida;
	private String buque;

	// Constructor con sus atributos por defecto.
	public Crucero() {
	}

	// Getters y setters.

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getDestinos() {
		return destinos;
	}

	public void setDestinos(ArrayList<String> destinos) {
		this.destinos = destinos;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getNumeroNoches() {
		return numeroNoches;
	}

	public void setNumeroNoches(int numeroNoches) {
		this.numeroNoches = numeroNoches;
	}

	public String getPuertoSalida() {
		return puertoSalida;
	}

	public void setPuertoSalida(String puertoSalida) {
		this.puertoSalida = puertoSalida;
	}

	public String getBuque() {
		return buque;
	}

	public void setBuque(String buque) {
		this.buque = buque;
	}

	// hashCode()
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + Objects.hashCode(this.nombre);
		hash = 31 * hash + Objects.hashCode(this.destinos);
		hash = 31 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
		hash = 31 * hash + this.numeroNoches;
		hash = 31 * hash + Objects.hashCode(this.puertoSalida);
		hash = 31 * hash + Objects.hashCode(this.buque);
		return hash;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Crucero other = (Crucero) obj;
		if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
			return false;
		}
		if (this.numeroNoches != other.numeroNoches) {
			return false;
		}
		if (!Objects.equals(this.nombre, other.nombre)) {
			return false;
		}
		if (!Objects.equals(this.puertoSalida, other.puertoSalida)) {
			return false;
		}
		if (!Objects.equals(this.buque, other.buque)) {
			return false;
		}
		return Objects.equals(this.destinos, other.destinos);
	}

	// toString()
	@Override
	public String toString() {
		return "Crucero{" + "\nNombre: " + nombre + "\nDestinos: " + destinos + "\nPrecio: " + precio
				+ "\nCantidad de noches: " + numeroNoches + "\nPuerto de salida: " + puertoSalida + "\nBuque: " + buque
				+ '}' + "\n";
	}

}
