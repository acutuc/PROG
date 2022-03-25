
package daw.poo.ej11;

/**
 *
 * @author acutuc
 */
public class Ventana {
    private boolean tintada; // true está tintada
    private boolean estado; // true está abierta

    public Ventana(boolean tintada, boolean estado) {
        this.tintada = tintada;
        this.estado = estado;
    }

    public boolean isTintada() {
        return tintada;
    }
    
    //OJOOOOOOOOOOOOOOOOOOOOOOO ATENSION.
    public String isTintadaString(){
        String txt = tintada?"tintada":"no tintada";
        return txt;
    }

    public void setTintada(boolean tintada) {
        this.tintada = tintada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void bajar() {
        this.estado = true;
    }
    
    public void subir() {
        this.estado = false;
    }


    @Override
    public String toString() {
        return "Ventana{" + "tintada=" + tintada + ", estado=" + estado + '}';
    }

    
}
