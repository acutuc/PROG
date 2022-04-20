package ej4ficherosvehiculos;

public class Vehiculo {
    //Atributos.
    private Long bastidor;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;
    
    //Constructor por defecto.
    public Vehiculo() {
    }
    

    // el método constructor de la clase Vehiculo 
    public Vehiculo(long bastidor, String matricula, String marca, String modelo, String color, double tarifa) {
    this.bastidor = bastidor;
    this.matricula = matricula;
    this.marca = marca; 
    this.modelo = modelo; 
    this.color = color; 
    this.tarifa = tarifa;
    this.disponible = false;
}

// los métodos ‘get’ y ‘set’ de la clase Vehiculo 

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

   
    public String getAtributos() {
        return bastidor + ":" + matricula + ":" + marca + ":" + modelo + ":" + color + ":" + tarifa + ":" + disponible;
    }

}
