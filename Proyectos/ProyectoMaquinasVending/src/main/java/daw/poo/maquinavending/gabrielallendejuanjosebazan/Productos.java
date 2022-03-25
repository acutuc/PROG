
package daw.poo.maquinavending.gabrielallendejuanjosebazan;

/**
 *
 * @author acutuc
 */

//Definición de la clase
public class Productos {
    //Atributos de la clase Productos:
    private String nombreProducto;
    private int precioProducto; //Precio de producto en CÉNTIMOS.

    //Constructor parametrizado.
    public Productos(String nombreProducto, int precioProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        //Restricción que controla que el precio de un producto nunca pueda ser negativo.
        if(precioProducto < 0){
            this.precioProducto = Math.abs(precioProducto);
        }
        
    }

    //Constructor con sus valores predeterminados.
    public Productos() {
    }
    
    //Getters y setters:

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        if(precioProducto < 0){
            this.precioProducto = Math.abs(precioProducto);
        }
        this.precioProducto = precioProducto;
    }
   
            
    //toString.

    @Override
    public String toString() {
        return "Productos{" + "nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + '}';
    }
        
}
