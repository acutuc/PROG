package daw.poo.maquinavending.gabrielallendejuanjosebazan;

public class Contenedor {

    private Productos productoActual;

    public Contenedor() {

    }

    public Productos getProductoContenedor() {
        return productoActual;
    }


    public void setProductoContenedor(Productos productoActual) {
        this.productoActual = productoActual;
    }

    @Override
    public String toString() {
        return "Contenedor{" + "productoActual=" + productoActual + '}';
    }
    
    

}
