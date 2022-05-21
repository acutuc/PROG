package p81gabrielallende;

//Definición de la clase
public class VehiculoVO {
	//Atributos de la clase     En MySQL:
	private int pk;				//codvehi
	private String matricula;	//matricula
	private String marca; 		//marca
	private String modelo;	 	//modelo
	private int puertas; 		//puertas
	private boolean auto; 		//automatico
	
	//Constructor parametrizado.
	VehiculoVO(int pk, String matricula, String marca, String modelo, int puertas, boolean auto){
		this.pk = pk;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.puertas = puertas;
		this.auto = auto;
	}
	
	//Constructor con sus atributos por defecto.
	public VehiculoVO() {
	}

	//Getters y setters.
	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public boolean isAuto() {
		return auto;
	}

	public void setAuto(boolean auto) {
		this.auto = auto;
	}

	
	//toString()
	@Override
	public String toString() {
		return "VehiculoVO [pk=" + pk + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ ", puertas=" + puertas + ", auto=" + auto + "]";
	}
	
}
