package daw.poo.maquinavending.gabrielallendejuanjosebazan;

public class Bandejas {

// Atributos    
    private Productos producto; //Producto que almacenará, siempre siendo el mismo
    private int stockProducto; //Stock de cantidad de productos dentro de cada vandeja.
    private int codBandeja; //¿preferimos int o String?

// Constructor sin parametrizar
    public Bandejas() {

    }
// Constructor parametrizado

    public Bandejas(Productos producto, int stockProducto, int codBandeja) {
        this.producto = producto;
        this.stockProducto = stockProducto; 
        this.codBandeja = codBandeja;
    }

    @Override
    public String toString() {
        return "Bandejas{" + "producto=" + producto + ", stockProducto=" + stockProducto + ", codBandeja=" + codBandeja + '}';
    }

// Setters y Getters    

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public int getCodBandeja() {
        return codBandeja;
    }

    public void setCodBandeja(int codBandeja) {
        this.codBandeja = codBandeja;
    }
    
    
    //Método que vende producto.
    public void productoVendido(){
        this.stockProducto = stockProducto - 1;
    }
    
    //Método que introduce productos
    public void agregarProductos(int cantidadAAgregar){
        this.stockProducto = stockProducto + Math.abs(cantidadAAgregar); //Math.abs para que no se pueda introducir valores negativos.
    }


}
