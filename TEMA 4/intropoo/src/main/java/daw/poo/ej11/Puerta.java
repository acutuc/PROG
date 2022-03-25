package daw.poo.ej11;

/**
 *
 * @author acutuc
 */
public class Puerta {
    private boolean estado; //abierta true
    private Ventana ventana;

    public Puerta(boolean estado, Ventana ventana) {
        this.estado = estado;
        this.ventana = ventana;
    }

    public boolean isEstado() {
        return estado;
    }

    public void abrir() {
        this.estado = true;
    }
    
    public void cerrar() {
        this.estado = false;
    }

    public Ventana getVentana() {
        return ventana;
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }

    //Recordatorio: ¿Qué pasa si el objeto ventana no tiene implementado toString?
    //Nos devuelve la dirección de memoria del objeto Ventana. PONER toString en Ventana.
    @Override
    public String toString() {
        return "Puerta{" + "estado=" + estado + ", ventana=" + ventana + '}';
    }
    
    
    
}
