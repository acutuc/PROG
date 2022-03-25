package daw.vehiculos;

public class MisVehiculos {

    public static void main(String args[]) {

// este programa crea un objeto de la clase vehiculo y
// muestra sus atributos
// instanciación del objeto vehiculo1
        Vehiculo vehiculo1 = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco",
                100.0);

        Vehiculo miCacharro = new Vehiculo("6045 JTE", "Seat", "Ibiza", "Azul", 150.0);
// invocación de métodos para mostrar los datos del objeto vehiculo1
        System.out.println("Datos del vehículo :"
                + vehiculo1.getMatricula() + ", " + vehiculo1.getMarca());

        System.out.println("Datos del vehículo: " + miCacharro.getMatricula() + ", "
                + miCacharro.getMarca() + ", " + miCacharro.getModelo() + ", "
                + miCacharro.getColor() + ", " + miCacharro.getTarifa());
        miCacharro.setMatricula("8877 LKM");
        System.out.println(miCacharro.getMatricula());
    }

}
