
package interfaceenclase;

/**
 *
 * @author acutuc
 */
public abstract class Vehiculo implements SeArranca, SePara, Comparable<Vehiculo>{
    
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + '}';
    }
    
    
    public abstract void repostar(String tipoCombustible);
    
    /*Al implementar interface, esta clase debería dar código a arrancar(),
    pero al ser abstracta puede dejarlo que lo hagan las clases
    hijas.*/
    
    public boolean arrancar(){
        System.out.println("El vehículo ha arrancado.");
        return true;
    }
    
    public boolean parar(){
        System.out.println("El vehículo se para.");
        return false;
    }
    
    public int compareTo(Vehiculo v){
        return this.matricula.compareTo(v.matricula);
    }
}
