package p81gabrielallende;

//Definición de la clase
public class ClienteVO {
	//Atributos de la clase     En MySQL:
	private int pk; 			//codcli
	private String nombre; 		//nomcli
	private String apellido1; 	//ape1cli
	private String apellido2; 	//ape2cli
	private String telefono; 	//telcli
	
	//Constructor parametrizado.
	public ClienteVO(int pk, String nombre, String apellido1, String apellido2, String telefono) {
		this.pk = pk;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
	}
	
	//Constructor con sus atributos por defecto.
	public ClienteVO() {
	}

	//Getters y setters.
	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	//toString()
	@Override
	public String toString() {
		return "ClienteVO [pk=" + pk + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", telefono=" + telefono + "]";
	}
		
}
