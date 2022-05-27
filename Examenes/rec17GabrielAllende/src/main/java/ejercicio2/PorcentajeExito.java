package ejercicio2;

import java.util.Objects;

//Definición de la clase. CLASE POJO
public class PorcentajeExito {
	//Atributos de la clase.
	private String codMunicipio;//String para que lea los ceros a la izquierda
	private String municipio;
	private String anio2016;
	private String anio2015;
	private String anio2014;
	private String anio2013;
	private String anio2011;
	private String anio2010;
	private String anio2006;
	private String anio2001;
	private String anio1996;
	
	//Constructor con sus atributos por defecto
	public PorcentajeExito() {
	}

	//Getters y setters.
	public String getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(String codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getAnio2016() {
		return anio2016;
	}

	public void setAnio2016(String anio2016) {
		this.anio2016 = anio2016;
	}

	public String getAnio2015() {
		return anio2015;
	}

	public void setAnio2015(String anio2015) {
		this.anio2015 = anio2015;
	}

	public String getAnio2014() {
		return anio2014;
	}

	public void setAnio2014(String anio2014) {
		this.anio2014 = anio2014;
	}

	public String getAnio2013() {
		return anio2013;
	}

	public void setAnio2013(String anio2013) {
		this.anio2013 = anio2013;
	}

	public String getAnio2011() {
		return anio2011;
	}

	public void setAnio2011(String anio2011) {
		this.anio2011 = anio2011;
	}

	public String getAnio2010() {
		return anio2010;
	}

	public void setAnio2010(String anio2010) {
		this.anio2010 = anio2010;
	}

	public String getAnio2006() {
		return anio2006;
	}

	public void setAnio2006(String anio2006) {
		this.anio2006 = anio2006;
	}

	public String getAnio2001() {
		return anio2001;
	}

	public void setAnio2001(String anio2001) {
		this.anio2001 = anio2001;
	}

	public String getAnio1996() {
		return anio1996;
	}

	public void setAnio1996(String anio1996) {
		this.anio1996 = anio1996;
	}

	//hashCode()
	@Override
	public int hashCode() {
		return Objects.hash(anio1996, anio2001, anio2006, anio2010, anio2011, anio2013, anio2014, anio2015,
				anio2016, codMunicipio, municipio);
	}

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PorcentajeExito other = (PorcentajeExito) obj;
		return anio1996 == other.anio1996 && anio2001 == other.anio2001 && anio2006 == other.anio2006
				&& anio2010 == other.anio2010 && anio2011 == other.anio2011 && anio2013 == other.anio2013 && anio2014 == other.anio2014 && anio2015 == other.anio2015
				&& anio2016 == other.anio2016 && Objects.equals(codMunicipio, other.codMunicipio)
				&& Objects.equals(municipio, other.municipio);
	}

	//toString()
	@Override
	public String toString() {
		return "Porcentaje de éxito: [\nCód. municipio: " + codMunicipio + "\nMunicipio: " + municipio + 
				"\nAño 2016: " + anio2016 + "\nAño 2015: " + anio2015 + "\nAño 2014: " + anio2014 +
				"\nAño 2013: " + anio2013 + "\nAño 2011: " + anio2011 + "\nAño 2010: " + anio2010 + 
				"\nAño 2006: " + anio2006 + "\nAño 2001: " + anio2001 + "\nAño 1996: " + anio1996 + "]\n";
	}
	
		
	

}
