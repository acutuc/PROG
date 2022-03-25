package daw.poo.maquinavending.gabrielallendejuanjosebazan;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel & Juan José
 */
public class TestMaquinas {

    public static void main(String[] args) {
        //Instanciación de objetos.

        //Productos creados
        Productos cocaCola = new Productos("Coca-Cola 500ml", 120);
        Productos kitKat = new Productos("Kit-Kat", 150);
        Productos agua = new Productos("Agua 500ml", 100);
        Productos smint = new Productos("Caramelos Smint", 100);
        Productos fantaNaranja = new Productos("Fanta Naranja 500ml", 120);
        Productos haribbo = new Productos("Caramelos Haribbo", 200);
        Bandejas bandeja1 = new Bandejas(cocaCola, 10, 1);
        Bandejas bandeja2 = new Bandejas(kitKat, 10, 2);
        Bandejas bandeja3 = new Bandejas(agua, 10, 3);
        Bandejas bandeja4 = new Bandejas(smint, 10, 4);
        Bandejas bandeja5 = new Bandejas(fantaNaranja, 10, 5);
        Bandejas bandeja6 = new Bandejas(haribbo, 10, 6);
        Tarjetas tarjeta1 = new Tarjetas();
        Tarjetas tarjeta2 = new Tarjetas();
        Tarjetas tarjeta3 = new Tarjetas();
        Contenedor contenedor = new Contenedor();
        Efectivo efectivo = new Efectivo();
        String direccionFisica = "C. Fuente de María Gil, 30, 29680 Estepona, Málaga";
        int recaudadoTarjeta = 0;
        Maquinas maquina1 = new Maquinas(bandeja1, bandeja2, bandeja3, bandeja4, bandeja5, bandeja6, tarjeta1, tarjeta2, tarjeta3, false, false, contenedor, efectivo, direccionFisica, recaudadoTarjeta);
        Productos productoElegido;

        //bandejas
        int codBandeja1 = bandeja1.getCodBandeja();
        String codBandeja1String = String.valueOf(codBandeja1);
        int codBandeja2 = bandeja2.getCodBandeja();
        String codBandeja2String = String.valueOf(codBandeja2);
        int codBandeja3 = bandeja3.getCodBandeja();
        String codBandeja3String = String.valueOf(codBandeja3);
        int codBandeja4 = bandeja4.getCodBandeja();
        String codBandeja4String = String.valueOf(codBandeja4);
        int codBandeja5 = bandeja5.getCodBandeja();
        String codBandeja5String = String.valueOf(codBandeja5);
        int codBandeja6 = bandeja6.getCodBandeja();
        String codBandeja6String = String.valueOf(codBandeja6);

        //base del modo admin
        ModoAdmin mAdmin = new ModoAdmin();
        mAdmin.generarCodigoAdmin();
        final String COD_ADMIN = mAdmin.mostrarCodigoAdmin();

        //resto de funciones modo admin
        //modificar y cambiar codbandeja
        String[] opcionesMainMenu = {codBandeja1String, codBandeja2String, codBandeja3String, codBandeja4String, codBandeja5String, codBandeja6String, COD_ADMIN};

        //Variable que nos ayuda a controlar la recaudación de las tarjetas.
        double tarjetaDouble = 0;

        //arrayTarjetas para implementar en el modo de pago con tarjeta.
        String[] arrayTarjetas = {"Tarjeta 1: \n" + tarjeta1.getNUMERO_TARJETA(), "Tarjeta 2: \n" + tarjeta2.getNUMERO_TARJETA(), "Tarjeta 3: \n" + tarjeta3.getNUMERO_TARJETA()};

        //Variable boolean auxiliar para salir del bucle.
        boolean aux = true;
        //Bucle que mantiene la máquina encendida hasta que el Admin la apague.
        do {
            //Array para implementar en el JOptionPane de métodos de pago.
            String[] arrayOpciones = {"Efectivo", "Tarjeta", "Cancelar"};
            //JOptionPane para elegir entre Efectivo, Tarjeta o Cancelar la compra.

            JOptionPane.showMessageDialog(null, "Bienvenido a la Máquina Vending 3000", "¡Hola usuario!", 1);
            int opcionesInt = JOptionPane.showOptionDialog(null, "Seleccione un método de pago: ", null, 0, 1, null, arrayOpciones, null);

            //If's para intercambiar entre las opciones elegidas, pudiendo ser: Efectivo, Tarjeta o Cancelar.
            //If que entra en las interacciones de Efectivo.
            if (opcionesInt == 0) {
                int opcionMainMenu = (JOptionPane.showOptionDialog(null, "Introduzca un código: "
                        + "\n" + codBandeja1String + "    " + mAdmin.consultarProducto(maquina1, bandeja1)
                        + "\n" + codBandeja2String + "    " + mAdmin.consultarProducto(maquina1, bandeja2)
                        + "\n" + codBandeja3String + "    " + mAdmin.consultarProducto(maquina1, bandeja3)
                        + "\n" + codBandeja4String + "    " + mAdmin.consultarProducto(maquina1, bandeja4)
                        + "\n" + codBandeja5String + "    " + mAdmin.consultarProducto(maquina1, bandeja5)
                        + "\n" + codBandeja6String + "    " + mAdmin.consultarProducto(maquina1, bandeja6)
                        + "\n" + "\n" + COD_ADMIN, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesMainMenu, null));

                int cantidad = 0;
                //Int que nos devuelve el JOptionPane.showOptionDialog.
                int pago;
                String[] valorMonedas = {"0,10€", "0,20€", "0,50€", "1€", "2€", "5€", "10€", "20€", "Pagar."};
                double cantidadDouble = 0;

                switch (opcionMainMenu) {
                    case 0:
                        do {
                            do {
                                pago = JOptionPane.showOptionDialog(null, "Ha seleccionado " + cocaCola.getNombreProducto() + ". Introduzca el dinero: \nDinero actual: " + (cantidadDouble / 100) + "€", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, valorMonedas, null);
                                switch (pago) {
                                    case 0:
                                        cantidad += 10;
                                        cantidadDouble += 10;
                                        efectivo.agregarMoneda(0, cantidad / 10);
                                        break;
                                    case 1:
                                        cantidad += 20;
                                        cantidadDouble += 20;
                                        efectivo.agregarMoneda(1, cantidad / 20);
                                        break;
                                    case 2:
                                        cantidad += 50;
                                        cantidadDouble += 50;
                                        efectivo.agregarMoneda(2, cantidad / 50);
                                        break;
                                    case 3:
                                        cantidad += 100;
                                        cantidadDouble += 100;
                                        efectivo.agregarMoneda(3, cantidad / 100);
                                        break;
                                    case 4:
                                        cantidad += 200;
                                        cantidadDouble += 200;
                                        efectivo.agregarMoneda(4, cantidad / 200);
                                        break;
                                    case 5:
                                        cantidad += 500;
                                        cantidadDouble += 500;
                                        efectivo.agregarMoneda(5, cantidad / 500);
                                        break;
                                    case 6:
                                        cantidad += 1000;
                                        cantidadDouble += 1000;
                                        efectivo.agregarMoneda(6, cantidad / 1000);
                                        break;
                                    case 7:
                                        cantidad += 2000;
                                        cantidadDouble += 2000;
                                        efectivo.agregarMoneda(7, cantidad / 2000);
                                        break;
                                    case 8:
                                        continue;
                                    default:

                                        break;
                                }
                            } while (pago != 8 && cantidad <= cocaCola.getPrecioProducto());
                            if (cantidad < cocaCola.getPrecioProducto()) {
                                JOptionPane.showMessageDialog(null, "Cantidad insuficiente.");
                            }
                        } while (cantidad < cocaCola.getPrecioProducto());

                        if (cantidad == cocaCola.getPrecioProducto()) {
                            JOptionPane.showMessageDialog(null, "Ha introducido la cantidad exacta. No tendrá cambio.");
                        } else {
                            cantidad -= cocaCola.getPrecioProducto();
                            JOptionPane.showMessageDialog(null, "El cambio será de:");
                            if (cantidad / 1000 > 0) {
                                efectivo.retirarMoneda(6, cantidad / 1000);
                                JOptionPane.showMessageDialog(null, "Billetes de 10€: " + cantidad / 1000);
                                cantidad %= 1000;
                            }
                            if (cantidad / 500 > 0) {
                                efectivo.retirarMoneda(5, cantidad / 500);
                                JOptionPane.showMessageDialog(null, "Billetes de 5€: " + cantidad / 500);
                                cantidad %= 500;
                            }
                            if (cantidad / 200 > 0) {
                                efectivo.retirarMoneda(4, cantidad / 200);
                                JOptionPane.showMessageDialog(null, "Monedas de 2€: " + cantidad / 200);
                                cantidad %= 200;
                            }
                            if (cantidad / 100 > 0) {
                                efectivo.retirarMoneda(3, cantidad / 100);
                                JOptionPane.showMessageDialog(null, "Monedas de 1€: " + cantidad / 100);
                                cantidad %= 100;
                            }
                            if (cantidad / 50 > 0) {
                                efectivo.retirarMoneda(2, cantidad / 50);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,50€: " + cantidad / 50);
                                cantidad %= 50;
                            }
                            if (cantidad / 20 > 0) {
                                efectivo.retirarMoneda(1, cantidad / 20);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,20€: " + cantidad / 20);
                                cantidad %= 20;
                            }
                            if (cantidad / 10 > 0) {
                                efectivo.retirarMoneda(0, cantidad / 10);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,10€: " + cantidad / 10);
                                cantidad %= 10;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        bandeja1.productoVendido();
                        productoElegido = cocaCola;
                        // fin de este proceso
                        aux = false;
                        continue;
                    case 1:
                        do {
                            do {
                                pago = JOptionPane.showOptionDialog(null, "Ha seleccionado " + kitKat.getNombreProducto() + ". Introduzca el dinero: \nDinero actual: " + (cantidadDouble / 100) + "€", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, valorMonedas, null);
                                switch (pago) {
                                    case 0:
                                        cantidad += 10;
                                        cantidadDouble += 10;
                                        efectivo.agregarMoneda(0, cantidad / 10);
                                        break;
                                    case 1:
                                        cantidad += 20;
                                        cantidadDouble += 20;
                                        efectivo.agregarMoneda(1, cantidad / 20);
                                        break;
                                    case 2:
                                        cantidad += 50;
                                        cantidadDouble += 50;
                                        efectivo.agregarMoneda(2, cantidad / 50);
                                        break;
                                    case 3:
                                        cantidad += 100;
                                        cantidadDouble += 100;
                                        efectivo.agregarMoneda(3, cantidad / 100);
                                        break;
                                    case 4:
                                        cantidad += 200;
                                        cantidadDouble += 200;
                                        efectivo.agregarMoneda(4, cantidad / 200);
                                        break;
                                    case 5:
                                        cantidad += 500;
                                        cantidadDouble += 500;
                                        efectivo.agregarMoneda(5, cantidad / 500);
                                        break;
                                    case 6:
                                        cantidad += 1000;
                                        cantidadDouble += 1000;
                                        efectivo.agregarMoneda(6, cantidad / 1000);
                                        break;
                                    case 7:
                                        cantidad += 2000;
                                        cantidadDouble += 2000;
                                        efectivo.agregarMoneda(7, cantidad / 2000);
                                        break;
                                    case 8:
                                        continue;
                                    default:

                                        break;
                                }
                            } while (pago != 8 && cantidad <= kitKat.getPrecioProducto());
                            if (cantidad < kitKat.getPrecioProducto()) {
                                JOptionPane.showMessageDialog(null, "Cantidad insuficiente.");
                            }
                        } while (cantidad < kitKat.getPrecioProducto());

                        if (cantidad == kitKat.getPrecioProducto()) {
                            JOptionPane.showMessageDialog(null, "Ha introducido la cantidad exacta. No tendrá cambio.");
                        } else {
                            cantidad -= kitKat.getPrecioProducto();
                            JOptionPane.showMessageDialog(null, "El cambio será de:");
                            if (cantidad / 1000 > 0) {
                                efectivo.retirarMoneda(6, cantidad / 1000);
                                JOptionPane.showMessageDialog(null, "Billetes de 10€: " + cantidad / 1000);
                                cantidad %= 1000;
                            }
                            if (cantidad / 500 > 0) {
                                efectivo.retirarMoneda(5, cantidad / 500);
                                JOptionPane.showMessageDialog(null, "Billetes de 5€: " + cantidad / 500);
                                cantidad %= 500;
                            }
                            if (cantidad / 200 > 0) {
                                efectivo.retirarMoneda(4, cantidad / 200);
                                JOptionPane.showMessageDialog(null, "Monedas de 2€: " + cantidad / 200);
                                cantidad %= 200;
                            }
                            if (cantidad / 100 > 0) {
                                efectivo.retirarMoneda(3, cantidad / 100);
                                JOptionPane.showMessageDialog(null, "Monedas de 1€: " + cantidad / 100);
                                cantidad %= 100;
                            }
                            if (cantidad / 50 > 0) {
                                efectivo.retirarMoneda(2, cantidad / 50);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,50€: " + cantidad / 50);
                                cantidad %= 50;
                            }
                            if (cantidad / 20 > 0) {
                                efectivo.retirarMoneda(1, cantidad / 20);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,20€: " + cantidad / 20);
                                cantidad %= 20;
                            }
                            if (cantidad / 10 > 0) {
                                efectivo.retirarMoneda(0, cantidad / 10);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,10€: " + cantidad / 10);
                                cantidad %= 10;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        bandeja2.productoVendido();
                        productoElegido = kitKat;
                        // fin de este proceso
                        aux = false;
                        continue;
                    case 2:
                        do {
                            do {
                                pago = JOptionPane.showOptionDialog(null, "Ha seleccionado " + agua.getNombreProducto() + ". Introduzca el dinero: \nDinero actual: " + (cantidadDouble / 100) + "€", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, valorMonedas, null);
                                switch (pago) {
                                    case 0:
                                        cantidad += 10;
                                        cantidadDouble += 10;
                                        efectivo.agregarMoneda(0, cantidad / 10);
                                        break;
                                    case 1:
                                        cantidad += 20;
                                        cantidadDouble += 20;
                                        efectivo.agregarMoneda(1, cantidad / 20);
                                        break;
                                    case 2:
                                        cantidad += 50;
                                        cantidadDouble += 50;
                                        efectivo.agregarMoneda(2, cantidad / 50);
                                        break;
                                    case 3:
                                        cantidad += 100;
                                        cantidadDouble += 100;
                                        efectivo.agregarMoneda(3, cantidad / 100);
                                        break;
                                    case 4:
                                        cantidad += 200;
                                        cantidadDouble += 200;
                                        efectivo.agregarMoneda(4, cantidad / 200);
                                        break;
                                    case 5:
                                        cantidad += 500;
                                        cantidadDouble += 500;
                                        efectivo.agregarMoneda(5, cantidad / 500);
                                        break;
                                    case 6:
                                        cantidad += 1000;
                                        cantidadDouble += 1000;
                                        efectivo.agregarMoneda(6, cantidad / 1000);
                                        break;
                                    case 7:
                                        cantidad += 2000;
                                        cantidadDouble += 2000;
                                        efectivo.agregarMoneda(7, cantidad / 2000);
                                        break;
                                    case 8:
                                        continue;
                                    default:

                                        break;
                                }
                            } while (pago != 8 && cantidad <= agua.getPrecioProducto());
                            if (cantidad < agua.getPrecioProducto()) {
                                JOptionPane.showMessageDialog(null, "Cantidad insuficiente.");
                            }
                        } while (cantidad < agua.getPrecioProducto());

                        if (cantidad == agua.getPrecioProducto()) {
                            JOptionPane.showMessageDialog(null, "Ha introducido la cantidad exacta. No tendrá cambio.");
                        } else {
                            cantidad -= agua.getPrecioProducto();
                            JOptionPane.showMessageDialog(null, "El cambio será de:");
                            if (cantidad / 1000 > 0) {
                                efectivo.retirarMoneda(6, cantidad / 1000);
                                JOptionPane.showMessageDialog(null, "Billetes de 10€: " + cantidad / 1000);
                                cantidad %= 1000;
                            }
                            if (cantidad / 500 > 0) {
                                efectivo.retirarMoneda(5, cantidad / 500);
                                JOptionPane.showMessageDialog(null, "Billetes de 5€: " + cantidad / 500);
                                cantidad %= 500;
                            }
                            if (cantidad / 200 > 0) {
                                efectivo.retirarMoneda(4, cantidad / 200);
                                JOptionPane.showMessageDialog(null, "Monedas de 2€: " + cantidad / 200);
                                cantidad %= 200;
                            }
                            if (cantidad / 100 > 0) {
                                efectivo.retirarMoneda(3, cantidad / 100);
                                JOptionPane.showMessageDialog(null, "Monedas de 1€: " + cantidad / 100);
                                cantidad %= 100;
                            }
                            if (cantidad / 50 > 0) {
                                efectivo.retirarMoneda(2, cantidad / 50);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,50€: " + cantidad / 50);
                                cantidad %= 50;
                            }
                            if (cantidad / 20 > 0) {
                                efectivo.retirarMoneda(1, cantidad / 20);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,20€: " + cantidad / 20);
                                cantidad %= 20;
                            }
                            if (cantidad / 10 > 0) {
                                efectivo.retirarMoneda(0, cantidad / 10);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,10€: " + cantidad / 10);
                                cantidad %= 10;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        bandeja3.productoVendido();
                        productoElegido = agua;
                        // fin de este proceso
                        aux = false;
                        continue;
                    case 3:
                        do {
                            do {
                                pago = JOptionPane.showOptionDialog(null, "Ha seleccionado " + smint.getNombreProducto() + ". Introduzca el dinero: \nDinero actual: " + (cantidadDouble / 100) + "€", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, valorMonedas, null);
                                switch (pago) {
                                    case 0:
                                        cantidad += 10;
                                        cantidadDouble += 10;
                                        efectivo.agregarMoneda(0, cantidad / 10);
                                        break;
                                    case 1:
                                        cantidad += 20;
                                        cantidadDouble += 20;
                                        efectivo.agregarMoneda(1, cantidad / 20);
                                        break;
                                    case 2:
                                        cantidad += 50;
                                        cantidadDouble += 50;
                                        efectivo.agregarMoneda(2, cantidad / 50);
                                        break;
                                    case 3:
                                        cantidad += 100;
                                        cantidadDouble += 100;
                                        efectivo.agregarMoneda(3, cantidad / 100);
                                        break;
                                    case 4:
                                        cantidad += 200;
                                        cantidadDouble += 200;
                                        efectivo.agregarMoneda(4, cantidad / 200);
                                        break;
                                    case 5:
                                        cantidad += 500;
                                        cantidadDouble += 500;
                                        efectivo.agregarMoneda(5, cantidad / 500);
                                        break;
                                    case 6:
                                        cantidad += 1000;
                                        cantidadDouble += 1000;
                                        efectivo.agregarMoneda(6, cantidad / 1000);
                                        break;
                                    case 7:
                                        cantidad += 2000;
                                        cantidadDouble += 2000;
                                        efectivo.agregarMoneda(7, cantidad / 2000);
                                        break;
                                    case 8:
                                        continue;
                                    default:

                                        break;
                                }
                            } while (pago != 8 && cantidad <= smint.getPrecioProducto());
                            if (cantidad < smint.getPrecioProducto()) {
                                JOptionPane.showMessageDialog(null, "Cantidad insuficiente.");
                            }
                        } while (cantidad < smint.getPrecioProducto());

                        if (cantidad == smint.getPrecioProducto()) {
                            JOptionPane.showMessageDialog(null, "Ha introducido la cantidad exacta. No tendrá cambio.");
                        } else {
                            cantidad -= smint.getPrecioProducto();
                            JOptionPane.showMessageDialog(null, "El cambio será de:");
                            if (cantidad / 1000 > 0) {
                                efectivo.retirarMoneda(6, cantidad / 1000);
                                JOptionPane.showMessageDialog(null, "Billetes de 10€: " + cantidad / 1000);
                                cantidad %= 1000;
                            }
                            if (cantidad / 500 > 0) {
                                efectivo.retirarMoneda(5, cantidad / 500);
                                JOptionPane.showMessageDialog(null, "Billetes de 5€: " + cantidad / 500);
                                cantidad %= 500;
                            }
                            if (cantidad / 200 > 0) {
                                efectivo.retirarMoneda(4, cantidad / 200);
                                JOptionPane.showMessageDialog(null, "Monedas de 2€: " + cantidad / 200);
                                cantidad %= 200;
                            }
                            if (cantidad / 100 > 0) {
                                efectivo.retirarMoneda(3, cantidad / 100);
                                JOptionPane.showMessageDialog(null, "Monedas de 1€: " + cantidad / 100);
                                cantidad %= 100;
                            }
                            if (cantidad / 50 > 0) {
                                efectivo.retirarMoneda(2, cantidad / 50);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,50€: " + cantidad / 50);
                                cantidad %= 50;
                            }
                            if (cantidad / 20 > 0) {
                                efectivo.retirarMoneda(1, cantidad / 20);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,20€: " + cantidad / 20);
                                cantidad %= 20;
                            }
                            if (cantidad / 10 > 0) {
                                efectivo.retirarMoneda(0, cantidad / 10);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,10€: " + cantidad / 10);
                                cantidad %= 10;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        bandeja4.productoVendido();
                        productoElegido = smint;
                        // fin de este proceso
                        aux = false;
                        continue;
                    case 4:
                        do {
                            do {
                                pago = JOptionPane.showOptionDialog(null, "Ha seleccionado " + fantaNaranja.getNombreProducto() + ". Introduzca el dinero: \nDinero actual: " + (cantidadDouble / 100) + "€", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, valorMonedas, null);
                                switch (pago) {
                                    case 0:
                                        cantidad += 10;
                                        cantidadDouble += 10;
                                        efectivo.agregarMoneda(0, cantidad / 10);
                                        break;
                                    case 1:
                                        cantidad += 20;
                                        cantidadDouble += 20;
                                        efectivo.agregarMoneda(1, cantidad / 20);
                                        break;
                                    case 2:
                                        cantidad += 50;
                                        cantidadDouble += 50;
                                        efectivo.agregarMoneda(2, cantidad / 50);
                                        break;
                                    case 3:
                                        cantidad += 100;
                                        cantidadDouble += 100;
                                        efectivo.agregarMoneda(3, cantidad / 100);
                                        break;
                                    case 4:
                                        cantidad += 200;
                                        cantidadDouble += 200;
                                        efectivo.agregarMoneda(4, cantidad / 200);
                                        break;
                                    case 5:
                                        cantidad += 500;
                                        cantidadDouble += 500;
                                        efectivo.agregarMoneda(5, cantidad / 500);
                                        break;
                                    case 6:
                                        cantidad += 1000;
                                        cantidadDouble += 1000;
                                        efectivo.agregarMoneda(6, cantidad / 1000);
                                        break;
                                    case 7:
                                        cantidad += 2000;
                                        cantidadDouble += 2000;
                                        efectivo.agregarMoneda(7, cantidad / 2000);
                                        break;
                                    case 8:
                                        continue;
                                    default:

                                        break;
                                }
                            } while (pago != 8 && cantidad <= fantaNaranja.getPrecioProducto());
                            if (cantidad < fantaNaranja.getPrecioProducto()) {
                                JOptionPane.showMessageDialog(null, "Cantidad insuficiente.");
                            }
                        } while (cantidad < fantaNaranja.getPrecioProducto());

                        if (cantidad == fantaNaranja.getPrecioProducto()) {
                            JOptionPane.showMessageDialog(null, "Ha introducido la cantidad exacta. No tendrá cambio.");
                        } else {
                            cantidad -= fantaNaranja.getPrecioProducto();
                            JOptionPane.showMessageDialog(null, "El cambio será de:");
                            if (cantidad / 1000 > 0) {
                                efectivo.retirarMoneda(6, cantidad / 1000);
                                JOptionPane.showMessageDialog(null, "Billetes de 10€: " + cantidad / 1000);
                                cantidad %= 1000;
                            }
                            if (cantidad / 500 > 0) {
                                efectivo.retirarMoneda(5, cantidad / 500);
                                JOptionPane.showMessageDialog(null, "Billetes de 5€: " + cantidad / 500);
                                cantidad %= 500;
                            }
                            if (cantidad / 200 > 0) {
                                efectivo.retirarMoneda(4, cantidad / 200);
                                JOptionPane.showMessageDialog(null, "Monedas de 2€: " + cantidad / 200);
                                cantidad %= 200;
                            }
                            if (cantidad / 100 > 0) {
                                efectivo.retirarMoneda(3, cantidad / 100);
                                JOptionPane.showMessageDialog(null, "Monedas de 1€: " + cantidad / 100);
                                cantidad %= 100;
                            }
                            if (cantidad / 50 > 0) {
                                efectivo.retirarMoneda(2, cantidad / 50);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,50€: " + cantidad / 50);
                                cantidad %= 50;
                            }
                            if (cantidad / 20 > 0) {
                                efectivo.retirarMoneda(1, cantidad / 20);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,20€: " + cantidad / 20);
                                cantidad %= 20;
                            }
                            if (cantidad / 10 > 0) {
                                efectivo.retirarMoneda(0, cantidad / 10);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,10€: " + cantidad / 10);
                                cantidad %= 10;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        bandeja5.productoVendido();
                        productoElegido = fantaNaranja;
                        // fin de este proceso
                        aux = false;
                        continue;
                    case 5:
                        do {
                            do {
                                pago = JOptionPane.showOptionDialog(null, "Ha seleccionado " + haribbo.getNombreProducto() + ". Introduzca el dinero: \nDinero actual: " + (cantidadDouble / 100) + "€", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, valorMonedas, null);
                                switch (pago) {
                                    case 0:
                                        cantidad += 10;
                                        cantidadDouble += 10;
                                        efectivo.agregarMoneda(0, cantidad / 10);
                                        break;
                                    case 1:
                                        cantidad += 20;
                                        cantidadDouble += 20;
                                        efectivo.agregarMoneda(1, cantidad / 20);
                                        break;
                                    case 2:
                                        cantidad += 50;
                                        cantidadDouble += 50;
                                        efectivo.agregarMoneda(2, cantidad / 50);
                                        break;
                                    case 3:
                                        cantidad += 100;
                                        cantidadDouble += 100;
                                        efectivo.agregarMoneda(3, cantidad / 100);
                                        break;
                                    case 4:
                                        cantidad += 200;
                                        cantidadDouble += 200;
                                        efectivo.agregarMoneda(4, cantidad / 200);
                                        break;
                                    case 5:
                                        cantidad += 500;
                                        cantidadDouble += 500;
                                        efectivo.agregarMoneda(5, cantidad / 500);
                                        break;
                                    case 6:
                                        cantidad += 1000;
                                        cantidadDouble += 1000;
                                        efectivo.agregarMoneda(6, cantidad / 1000);
                                        break;
                                    case 7:
                                        cantidad += 2000;
                                        cantidadDouble += 2000;
                                        efectivo.agregarMoneda(7, cantidad / 2000);
                                        break;
                                    case 8:
                                        continue;
                                    default:

                                        break;
                                }
                            } while (pago != 8 && cantidad <= haribbo.getPrecioProducto());
                            if (cantidad < haribbo.getPrecioProducto()) {
                                JOptionPane.showMessageDialog(null, "Cantidad insuficiente.");
                            }
                        } while (cantidad < haribbo.getPrecioProducto());

                        if (cantidad == haribbo.getPrecioProducto()) {
                            JOptionPane.showMessageDialog(null, "Ha introducido la cantidad exacta. No tendrá cambio.");
                        } else {
                            cantidad -= haribbo.getPrecioProducto();
                            JOptionPane.showMessageDialog(null, "El cambio será de:");
                            if (cantidad / 1000 > 0) {
                                efectivo.retirarMoneda(6, cantidad / 1000);
                                JOptionPane.showMessageDialog(null, "Billetes de 10€: " + cantidad / 1000);
                                cantidad %= 1000;
                            }
                            if (cantidad / 500 > 0) {
                                efectivo.retirarMoneda(5, cantidad / 500);
                                JOptionPane.showMessageDialog(null, "Billetes de 5€: " + cantidad / 500);
                                cantidad %= 500;
                            }
                            if (cantidad / 200 > 0) {
                                efectivo.retirarMoneda(4, cantidad / 200);
                                JOptionPane.showMessageDialog(null, "Monedas de 2€: " + cantidad / 200);
                                cantidad %= 200;
                            }
                            if (cantidad / 100 > 0) {
                                efectivo.retirarMoneda(3, cantidad / 100);
                                JOptionPane.showMessageDialog(null, "Monedas de 1€: " + cantidad / 100);
                                cantidad %= 100;
                            }
                            if (cantidad / 50 > 0) {
                                efectivo.retirarMoneda(2, cantidad / 50);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,50€: " + cantidad / 50);
                                cantidad %= 50;
                            }
                            if (cantidad / 20 > 0) {
                                efectivo.retirarMoneda(1, cantidad / 20);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,20€: " + cantidad / 20);
                                cantidad %= 20;
                            }
                            if (cantidad / 10 > 0) {
                                efectivo.retirarMoneda(0, cantidad / 10);
                                JOptionPane.showMessageDialog(null, "Monedas de 0,10€: " + cantidad / 10);
                                cantidad %= 10;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        bandeja6.productoVendido();
                        productoElegido = haribbo;
                        // fin de este proceso
                        aux = false;
                        continue;

                    // case del MODO ADMIN
                    case 6:

                        String[] opcionesModoAdmin = {"Apagar Dispositivo", "1", "2", "3", "4", "5", "6", "7", "8"};

                        int opcionModoAdmin = (JOptionPane.showOptionDialog(null, "Usted está en Modo Administrador, que desea hacer."
                                + "\n [Número de Serie: " + maquina1.getNumeroSerie() + "]"
                                + "\n "
                                + "\n 1. Consultar Código de Bandeja "
                                + "\n 2. Modificar Código de Bandeja "
                                + "\n 3. Consultar Producto"
                                + "\n 4. Cambiar Producto"
                                + "\n 5. Consultar Stock"
                                + "\n 6. Cambiar Stock"
                                + "\n 7. Consultar Efectivo"
                                + "\n 8. Consultar Recaudado por Tarjeta"
                                + "\n ", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesModoAdmin, null));

                        switch (opcionModoAdmin) {

                            case 0:
                                aux = true;
                                continue;

                            case 1:

                                JOptionPane.showMessageDialog(null, "Códigos de Bandejas: "
                                        + "\n Bandeja 1: " + codBandeja1String
                                        + "\n Bandeja 2: " + codBandeja2String
                                        + "\n Bandeja 3: " + codBandeja3String
                                        + "\n Bandeja 4: " + codBandeja4String
                                        + "\n Bandeja 5: " + codBandeja5String
                                        + "\n Bandeja 6: " + codBandeja6String
                                );
                                aux = false;
                                continue;
                            case 2:

                                String[] opcionesCambiarBandeja = {codBandeja1String, codBandeja2String, codBandeja3String, codBandeja4String, codBandeja5String, codBandeja6String};
                                int opcionCambiarBandeja = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar el Código de una Bandeja, elija la bandeja.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarBandeja, null));

                                switch (opcionCambiarBandeja) {

                                    case 0:

                                        String nuevoCodBandeja1 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja1String));
                                        codBandeja1String = (nuevoCodBandeja1);
                                        break;
                                    case 1:
                                        String nuevoCodBandeja2 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja2String));
                                        codBandeja2String = (nuevoCodBandeja2);
                                        break;
                                    case 2:
                                        String nuevoCodBandeja3 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja3String));
                                        codBandeja3String = (nuevoCodBandeja3);
                                        break;
                                    case 3:
                                        String nuevoCodBandeja4 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja4String));
                                        codBandeja4String = (nuevoCodBandeja4);
                                        break;
                                    case 4:
                                        String nuevoCodBandeja5 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja5String));
                                        codBandeja5String = (nuevoCodBandeja5);
                                        break;
                                    case 5:
                                        String nuevoCodBandeja6 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja6String));
                                        codBandeja6String = (nuevoCodBandeja6);
                                        break;

                                }
                                aux = false;
                                continue;

                            case 3:

                                JOptionPane.showMessageDialog(null, "Productos de Bandejas: "
                                        + "\n Bandeja 1: " + mAdmin.consultarProducto(maquina1, bandeja1)
                                        + "\n Bandeja 2: " + mAdmin.consultarProducto(maquina1, bandeja2)
                                        + "\n Bandeja 3: " + mAdmin.consultarProducto(maquina1, bandeja3)
                                        + "\n Bandeja 4: " + mAdmin.consultarProducto(maquina1, bandeja4)
                                        + "\n Bandeja 5: " + mAdmin.consultarProducto(maquina1, bandeja5)
                                        + "\n Bandeja 6: " + mAdmin.consultarProducto(maquina1, bandeja6)
                                );
                                aux = false;
                                continue;

                            case 4:

                                String[] opcionesCambiarProducto = {maquina1.getBandeja1().getProducto().getNombreProducto(), maquina1.getBandeja2().getProducto().getNombreProducto(), maquina1.getBandeja3().getProducto().getNombreProducto(), maquina1.getBandeja4().getProducto().getNombreProducto(), maquina1.getBandeja5().getProducto().getNombreProducto(), maquina1.getBandeja6().getProducto().getNombreProducto()};
                                String[] opcionesCambiarProductoPor = {"CocaCola", "KitKat", "Agua", "Smint", "Fanta Naranja", "Haribbo"};
                                int opcionCambiarProducto = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProducto, null));

                                switch (opcionCambiarProducto) {

                                    case 0:

                                        int opcionCambiarProducto1Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto1Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, haribbo);
                                                break;
                                        }
                                        break;
                                    case 1:
                                        int opcionCambiarProducto2Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto2Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, haribbo);
                                                break;
                                        }
                                        break;
                                    case 2:
                                        int opcionCambiarProducto3Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto3Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, haribbo);
                                                break;
                                        }
                                        break;
                                    case 3:

                                        int opcionCambiarProducto4Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto4Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, haribbo);
                                                break;
                                        }

                                        break;
                                    case 4:
                                        int opcionCambiarProducto5Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto5Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, haribbo);
                                                break;
                                        }
                                        break;

                                    case 5:
                                        int opcionCambiarProducto6Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto6Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, haribbo);
                                                break;
                                        }
                                        break;
                                }
                                aux = false;
                                continue;
                            case 5:

                                JOptionPane.showMessageDialog(null, "Stock de Bandejas: "
                                        + "\n Bandeja 1: " + mAdmin.consultarStock(maquina1, bandeja1)
                                        + "\n Bandeja 2: " + mAdmin.consultarStock(maquina1, bandeja2)
                                        + "\n Bandeja 3: " + mAdmin.consultarStock(maquina1, bandeja3)
                                        + "\n Bandeja 4: " + mAdmin.consultarStock(maquina1, bandeja4)
                                        + "\n Bandeja 5: " + mAdmin.consultarStock(maquina1, bandeja5)
                                        + "\n Bandeja 6: " + mAdmin.consultarStock(maquina1, bandeja6)
                                );

                                aux = false;
                                continue;

                            case 6:

                                String[] opcionesCambiarStock = {codBandeja1String, codBandeja2String, codBandeja3String, codBandeja4String, codBandeja5String, codBandeja6String, "Rellenar todo el Stock"};
                                int opcionCambiarStock = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar el Stock del prodcuto de una Bandeja, elija la bandeja.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarStock, null));

                                switch (opcionCambiarStock) {

                                    case 0:

                                        String nuevoStockBandeja1 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja1String));
                                        int nuevoStockBandeja1Int = Integer.parseInt(nuevoStockBandeja1);
                                        mAdmin.cambiarStock(maquina1, bandeja1, nuevoStockBandeja1Int);
                                        break;
                                    case 1:
                                        String nuevoStockBandeja2 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja2String));
                                        int nuevoStockBandeja2Int = Integer.parseInt(nuevoStockBandeja2);
                                        mAdmin.cambiarStock(maquina1, bandeja2, nuevoStockBandeja2Int);
                                        break;
                                    case 2:
                                        String nuevoStockBandeja3 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja3String));
                                        int nuevoStockBandeja3Int = Integer.parseInt(nuevoStockBandeja3);
                                        mAdmin.cambiarStock(maquina1, bandeja3, nuevoStockBandeja3Int);
                                        break;
                                    case 3:
                                        String nuevoStockBandeja4 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja4String));
                                        int nuevoStockBandeja4Int = Integer.parseInt(nuevoStockBandeja4);
                                        mAdmin.cambiarStock(maquina1, bandeja4, nuevoStockBandeja4Int);
                                        break;
                                    case 4:
                                        String nuevoStockBandeja5 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja5String));
                                        int nuevoStockBandeja5Int = Integer.parseInt(nuevoStockBandeja5);
                                        mAdmin.cambiarStock(maquina1, bandeja5, nuevoStockBandeja5Int);
                                        break;
                                    case 5:
                                        String nuevoStockBandeja6 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja6String));
                                        int nuevoStockBandeja6Int = Integer.parseInt(nuevoStockBandeja6);
                                        mAdmin.cambiarStock(maquina1, bandeja6, nuevoStockBandeja6Int);
                                        break;
                                    case 6:
                                        mAdmin.cambiarStock(maquina1, bandeja1, 15);
                                        mAdmin.cambiarStock(maquina1, bandeja2, 15);
                                        mAdmin.cambiarStock(maquina1, bandeja3, 15);
                                        mAdmin.cambiarStock(maquina1, bandeja4, 15);
                                        mAdmin.cambiarStock(maquina1, bandeja5, 15);
                                        mAdmin.cambiarStock(maquina1, bandeja6, 15);

                                }

                                aux = false;
                                continue;

                            case 7:

                                // debes, aquí, además de mostrar el dinero recaudado, dar la opción de recaudar y recargar
                                String[] opcionesRecaudacion = {"Recaudar", "Recargar"};

                                int opcionRecaudacion = (JOptionPane.showOptionDialog(null, "Recaudación en Efectivo " + Arrays.toString(maquina1.getEfectivoMaquina().getCantidadMonedas()) + "\n Ultima recolecta: " + mAdmin.verUltimaRecaudacion(), null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesRecaudacion, null));

                                switch (opcionRecaudacion) {
                                    case 0:

                                        mAdmin.recaudarEfectivo(maquina1);

                                        break;
                                    case 1:

                                        String moneda10 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Monedas de 10 "));
                                        int moneda10Int = Integer.parseInt(moneda10);

                                        String moneda20 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Monedas de 20 "));
                                        int moneda20Int = Integer.parseInt(moneda20);

                                        String moneda50 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Monedas de 50 "));
                                        int moneda50Int = Integer.parseInt(moneda50);

                                        String moneda1 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Monedas de 1 "));
                                        int moneda1Int = Integer.parseInt(moneda1);

                                        String moneda2 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Monedas de 2 "));
                                        int moneda2Int = Integer.parseInt(moneda2);

                                        String billete5 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Billetes de 5 "));
                                        int billete5Int = Integer.parseInt(billete5);

                                        String billete10 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Billetes de 10"));
                                        int billete10Int = Integer.parseInt(billete10);

                                        String billete20 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Billetes de 20"));
                                        int billete20Int = Integer.parseInt(billete20);

                                        Efectivo efectivoARecargar = new Efectivo(moneda10Int, moneda20Int, moneda50Int, moneda1Int, moneda2Int, billete5Int, billete10Int, billete20Int);
                                        mAdmin.recargarEfectivo(maquina1, efectivoARecargar);

                                        break;

                                }
                            case 8:
                                JOptionPane.showMessageDialog(null, "Ha recaudado desde que se inició la máquina: " + tarjetaDouble
                                        + " €");
                                break;

                        }
                        aux = false;
                }
            }
            if (opcionesInt == 1) {
                int opcionMainMenu = (JOptionPane.showOptionDialog(null, "Introduzca un código: "
                        + "\n" + codBandeja1String + "    " + mAdmin.consultarProducto(maquina1, bandeja1)
                        + "\n" + codBandeja2String + "    " + mAdmin.consultarProducto(maquina1, bandeja2)
                        + "\n" + codBandeja3String + "    " + mAdmin.consultarProducto(maquina1, bandeja3)
                        + "\n" + codBandeja4String + "    " + mAdmin.consultarProducto(maquina1, bandeja4)
                        + "\n" + codBandeja5String + "    " + mAdmin.consultarProducto(maquina1, bandeja5)
                        + "\n" + codBandeja6String + "    " + mAdmin.consultarProducto(maquina1, bandeja6)
                        + "\n" + "\n" + COD_ADMIN, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesMainMenu, null));

                switch (opcionMainMenu) {
                    case 0:
                        //Seleccionamos una de las 3 tarjetas para pagar.
                        int tarjetaSeleccionada = JOptionPane.showOptionDialog(null, "Introduzca la tarjeta: ", null, 0, 1, null, arrayTarjetas, null);
                        if (tarjetaSeleccionada == 0) {
                            tarjeta1.ventaRealizada(cocaCola.getPrecioProducto());
                            bandeja1.productoVendido();
                            tarjetaDouble += 1.20;
                        }
                        // fin de este proceso
                        if (tarjetaSeleccionada == 1) {
                            tarjeta2.ventaRealizada(cocaCola.getPrecioProducto());
                            bandeja1.productoVendido();
                            tarjetaDouble += 1.20;
                        }
                        // Incio de proceso de entrega de producto y modificación del stack
                        if (tarjetaSeleccionada == 2) {
                            tarjeta3.ventaRealizada(cocaCola.getPrecioProducto());
                            bandeja1.productoVendido();
                            tarjetaDouble += 1.20;
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        productoElegido = cocaCola;
                        // fin de este proceso
                        aux = false;
                        break;
                    case 1:
                        //Seleccionamos una de las 3 tarjetas para pagar.
                        tarjetaSeleccionada = JOptionPane.showOptionDialog(null, "Introduzca la tarjeta: ", null, 0, 1, null, arrayTarjetas, null);
                        if (tarjetaSeleccionada == 0) {
                            tarjeta1.ventaRealizada(kitKat.getPrecioProducto());
                            bandeja2.productoVendido();
                            tarjetaDouble += 1.50;
                        }
                        // fin de este proceso
                        if (tarjetaSeleccionada == 1) {
                            tarjeta2.ventaRealizada(kitKat.getPrecioProducto());
                            bandeja2.productoVendido();
                            tarjetaDouble += 1.50;
                        }
                        // Incio de proceso de entrega de producto y modificación del stack
                        if (tarjetaSeleccionada == 2) {
                            tarjeta3.ventaRealizada(kitKat.getPrecioProducto());
                            bandeja2.productoVendido();
                            tarjetaDouble += 1.50;
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        productoElegido = kitKat;
                        // fin de este proceso
                        aux = false;
                        break;
                    case 2:
                        //Seleccionamos una de las 3 tarjetas para pagar.
                        tarjetaSeleccionada = JOptionPane.showOptionDialog(null, "Introduzca la tarjeta: ", null, 0, 1, null, arrayTarjetas, null);
                        if (tarjetaSeleccionada == 0) {
                            tarjeta1.ventaRealizada(agua.getPrecioProducto());
                            bandeja3.productoVendido();
                            tarjetaDouble += 1.00;
                        }
                        // fin de este proceso
                        if (tarjetaSeleccionada == 1) {
                            tarjeta2.ventaRealizada(agua.getPrecioProducto());
                            bandeja3.productoVendido();
                            tarjetaDouble += 1.00;
                        }
                        // Incio de proceso de entrega de producto y modificación del stack
                        if (tarjetaSeleccionada == 2) {
                            tarjeta3.ventaRealizada(agua.getPrecioProducto());
                            bandeja3.productoVendido();
                            tarjetaDouble += 1.00;
                        }
                        // Incio de proceso de entrega de producto y modificación del stack
                        productoElegido = agua;
                        // fin de este proceso
                        aux = false;
                        break;
                    case 3:
                        //Seleccionamos una de las 3 tarjetas para pagar.
                        tarjetaSeleccionada = JOptionPane.showOptionDialog(null, "Introduzca la tarjeta: ", null, 0, 1, null, arrayTarjetas, null);
                        if (tarjetaSeleccionada == 0) {
                            tarjeta1.ventaRealizada(smint.getPrecioProducto());
                            bandeja4.productoVendido();
                            tarjetaDouble += 1.00;
                        }
                        // fin de este proceso
                        if (tarjetaSeleccionada == 1) {
                            tarjeta2.ventaRealizada(smint.getPrecioProducto());
                            bandeja4.productoVendido();
                            tarjetaDouble += 1.00;
                        }
                        // Incio de proceso de entrega de producto y modificación del stack
                        if (tarjetaSeleccionada == 2) {
                            tarjeta3.ventaRealizada(smint.getPrecioProducto());
                            bandeja4.productoVendido();
                            tarjetaDouble += 1.00;
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        productoElegido = smint;
                        // fin de este proceso
                        aux = false;
                        break;
                    case 4:
                        //Seleccionamos una de las 3 tarjetas para pagar.
                        tarjetaSeleccionada = JOptionPane.showOptionDialog(null, "Introduzca la tarjeta: ", null, 0, 1, null, arrayTarjetas, null);
                        if (tarjetaSeleccionada == 0) {
                            tarjeta1.ventaRealizada(fantaNaranja.getPrecioProducto());
                            bandeja5.productoVendido();
                            tarjetaDouble += 1.20;
                        }
                        // fin de este proceso
                        if (tarjetaSeleccionada == 1) {
                            tarjeta2.ventaRealizada(fantaNaranja.getPrecioProducto());
                            bandeja5.productoVendido();
                            tarjetaDouble += 1.20;
                        }
                        // Incio de proceso de entrega de producto y modificación del stack
                        if (tarjetaSeleccionada == 2) {
                            tarjeta3.ventaRealizada(fantaNaranja.getPrecioProducto());
                            bandeja5.productoVendido();
                            tarjetaDouble += 1.20;
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        productoElegido = fantaNaranja;
                        // fin de este proceso
                        aux = false;
                        break;
                    case 5:
                        //Seleccionamos una de las 3 tarjetas para pagar.
                        tarjetaSeleccionada = JOptionPane.showOptionDialog(null, "Introduzca la tarjeta: ", null, 0, 1, null, arrayTarjetas, null);
                        if (tarjetaSeleccionada == 0) {
                            tarjeta1.ventaRealizada(haribbo.getPrecioProducto());
                            bandeja6.productoVendido();
                            tarjetaDouble += 2.00;
                        }
                        // fin de este proceso
                        if (tarjetaSeleccionada == 1) {
                            tarjeta2.ventaRealizada(haribbo.getPrecioProducto());
                            bandeja6.productoVendido();
                            tarjetaDouble += 2.00;
                        }
                        // Incio de proceso de entrega de producto y modificación del stack
                        if (tarjetaSeleccionada == 2) {
                            tarjeta3.ventaRealizada(haribbo.getPrecioProducto());
                            bandeja6.productoVendido();
                            tarjetaDouble += 2.00;
                        }
                        JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                        // Incio de proceso de entrega de producto y modificación del stack
                        productoElegido = haribbo;
                        // fin de este proceso
                        aux = false;
                        break;
                    case 6:

                        String[] opcionesModoAdmin = {"Apagar Dispositivo", "1", "2", "3", "4", "5", "6", "7", "8"};

                        int opcionModoAdmin = (JOptionPane.showOptionDialog(null, "Usted está en Modo Administrador, que desea hacer."
                                + "\n [Número de Serie: " + maquina1.getNumeroSerie() + "]"
                                + "\n "
                                + "\n 1. Consultar Código de Bandeja "
                                + "\n 2. Modificar Código de Bandeja "
                                + "\n 3. Consultar Producto"
                                + "\n 4. Cambiar Producto"
                                + "\n 5. Consultar Stock"
                                + "\n 6. Cambiar Stock"
                                + "\n 7. Consultar Efectivo"
                                + "\n 8. Consultar Recaudado por Tarjeta"
                                + "\n ", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesModoAdmin, null));

                        switch (opcionModoAdmin) {

                            case 0:
                                aux = true;
                                continue;

                            case 1:

                                JOptionPane.showMessageDialog(null, "Códigos de Bandejas: "
                                        + "\n Bandeja 1: " + codBandeja1String
                                        + "\n Bandeja 2: " + codBandeja2String
                                        + "\n Bandeja 3: " + codBandeja3String
                                        + "\n Bandeja 4: " + codBandeja4String
                                        + "\n Bandeja 5: " + codBandeja5String
                                        + "\n Bandeja 6: " + codBandeja6String
                                );
                                aux = false;
                                continue;
                            case 2:

                                String[] opcionesCambiarBandeja = {codBandeja1String, codBandeja2String, codBandeja3String, codBandeja4String, codBandeja5String, codBandeja6String};
                                int opcionCambiarBandeja = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar el Código de una Bandeja, elija la bandeja.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarBandeja, null));

                                switch (opcionCambiarBandeja) {

                                    case 0:

                                        String nuevoCodBandeja1 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja1String));
                                        codBandeja1String = (nuevoCodBandeja1);
                                        break;
                                    case 1:
                                        String nuevoCodBandeja2 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja2String));
                                        codBandeja2String = (nuevoCodBandeja2);
                                        break;
                                    case 2:
                                        String nuevoCodBandeja3 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja3String));
                                        codBandeja3String = (nuevoCodBandeja3);
                                        break;
                                    case 3:
                                        String nuevoCodBandeja4 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja4String));
                                        codBandeja4String = (nuevoCodBandeja4);
                                        break;
                                    case 4:
                                        String nuevoCodBandeja5 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja5String));
                                        codBandeja5String = (nuevoCodBandeja5);
                                        break;
                                    case 5:
                                        String nuevoCodBandeja6 = (JOptionPane.showInputDialog("Introduzca un nuevo Código de Bandeja para la Bandeja " + codBandeja6String));
                                        codBandeja6String = (nuevoCodBandeja6);
                                        break;

                                }
                                aux = false;
                                continue;

                            case 3:

                                JOptionPane.showMessageDialog(null, "Productos de Bandejas: "
                                        + "\n Bandeja 1: " + mAdmin.consultarProducto(maquina1, bandeja1)
                                        + "\n Bandeja 2: " + mAdmin.consultarProducto(maquina1, bandeja2)
                                        + "\n Bandeja 3: " + mAdmin.consultarProducto(maquina1, bandeja3)
                                        + "\n Bandeja 4: " + mAdmin.consultarProducto(maquina1, bandeja4)
                                        + "\n Bandeja 5: " + mAdmin.consultarProducto(maquina1, bandeja5)
                                        + "\n Bandeja 6: " + mAdmin.consultarProducto(maquina1, bandeja6)
                                );
                                aux = false;
                                continue;

                            case 4:

                                String[] opcionesCambiarProducto = {maquina1.getBandeja1().getProducto().getNombreProducto(), maquina1.getBandeja2().getProducto().getNombreProducto(), maquina1.getBandeja3().getProducto().getNombreProducto(), maquina1.getBandeja4().getProducto().getNombreProducto(), maquina1.getBandeja5().getProducto().getNombreProducto(), maquina1.getBandeja6().getProducto().getNombreProducto()};
                                String[] opcionesCambiarProductoPor = {"CocaCola", "KitKat", "Agua", "Smint", "Fanta Naranja", "Haribbo"};
                                int opcionCambiarProducto = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProducto, null));

                                switch (opcionCambiarProducto) {

                                    case 0:

                                        int opcionCambiarProducto1Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto1Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja1, haribbo);
                                                break;
                                        }
                                        break;
                                    case 1:
                                        int opcionCambiarProducto2Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto2Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja2, haribbo);
                                                break;
                                        }
                                        break;
                                    case 2:
                                        int opcionCambiarProducto3Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto3Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja3, haribbo);
                                                break;
                                        }
                                        break;
                                    case 3:

                                        int opcionCambiarProducto4Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto4Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja4, haribbo);
                                                break;
                                        }

                                        break;
                                    case 4:
                                        int opcionCambiarProducto5Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto5Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja5, haribbo);
                                                break;
                                        }
                                        break;

                                    case 5:
                                        int opcionCambiarProducto6Por = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar un Producto, elija un Producto por el cual Modificar.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarProductoPor, null));
                                        switch (opcionCambiarProducto6Por) {

                                            case 0:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, cocaCola);
                                                break;
                                            case 1:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, kitKat);
                                                break;
                                            case 2:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, agua);
                                                break;
                                            case 3:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, smint);
                                                break;
                                            case 4:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, fantaNaranja);
                                                break;
                                            case 5:
                                                mAdmin.cambiarProducto(maquina1, bandeja6, haribbo);
                                                break;
                                        }
                                        break;
                                }
                                aux = false;
                                continue;
                            case 5:

                                JOptionPane.showMessageDialog(null, "Stock de Bandejas: "
                                        + "\n Bandeja 1: " + mAdmin.consultarStock(maquina1, bandeja1)
                                        + "\n Bandeja 2: " + mAdmin.consultarStock(maquina1, bandeja2)
                                        + "\n Bandeja 3: " + mAdmin.consultarStock(maquina1, bandeja3)
                                        + "\n Bandeja 4: " + mAdmin.consultarStock(maquina1, bandeja4)
                                        + "\n Bandeja 5: " + mAdmin.consultarStock(maquina1, bandeja5)
                                        + "\n Bandeja 6: " + mAdmin.consultarStock(maquina1, bandeja6)
                                );

                                aux = false;
                                continue;

                            case 6:

                                String[] opcionesCambiarStock = {codBandeja1String, codBandeja2String, codBandeja3String, codBandeja4String, codBandeja5String, codBandeja6String, "Rellenar todo el Stock"};
                                int opcionCambiarStock = (JOptionPane.showOptionDialog(null, "Usted ha elegido Modificar el Stock del prodcuto de una Bandeja, elija la bandeja.", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCambiarStock, null));

                                switch (opcionCambiarStock) {

                                    case 0:

                                        String nuevoStockBandeja1 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja1String));
                                        int nuevoStockBandeja1Int = Integer.parseInt(nuevoStockBandeja1);
                                        mAdmin.cambiarStock(maquina1, bandeja1, nuevoStockBandeja1Int);
                                        break;
                                    case 1:
                                        String nuevoStockBandeja2 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja2String));
                                        int nuevoStockBandeja2Int = Integer.parseInt(nuevoStockBandeja2);
                                        mAdmin.cambiarStock(maquina1, bandeja2, nuevoStockBandeja2Int);
                                        break;
                                    case 2:
                                        String nuevoStockBandeja3 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja3String));
                                        int nuevoStockBandeja3Int = Integer.parseInt(nuevoStockBandeja3);
                                        mAdmin.cambiarStock(maquina1, bandeja3, nuevoStockBandeja3Int);
                                        break;
                                    case 3:
                                        String nuevoStockBandeja4 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja4String));
                                        int nuevoStockBandeja4Int = Integer.parseInt(nuevoStockBandeja4);
                                        mAdmin.cambiarStock(maquina1, bandeja4, nuevoStockBandeja4Int);
                                        break;
                                    case 4:
                                        String nuevoStockBandeja5 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja5String));
                                        int nuevoStockBandeja5Int = Integer.parseInt(nuevoStockBandeja5);
                                        mAdmin.cambiarStock(maquina1, bandeja5, nuevoStockBandeja5Int);
                                        break;
                                    case 5:
                                        String nuevoStockBandeja6 = (JOptionPane.showInputDialog("Introduzca un nuevo Stock de Producto para la Bandeja " + codBandeja6String));
                                        int nuevoStockBandeja6Int = Integer.parseInt(nuevoStockBandeja6);
                                        mAdmin.cambiarStock(maquina1, bandeja6, nuevoStockBandeja6Int);
                                        break;
                                    case 6:
                                        mAdmin.cambiarStock(maquina1, bandeja1, 15);
                                        mAdmin.cambiarStock(maquina1, bandeja2, 15);
                                        mAdmin.cambiarStock(maquina1, bandeja3, 15);
                                        mAdmin.cambiarStock(maquina1, bandeja4, 15);
                                        mAdmin.cambiarStock(maquina1, bandeja5, 15);
                                        mAdmin.cambiarStock(maquina1, bandeja6, 15);

                                }

                                aux = false;
                                continue;

                            case 7:

                                // debes, aquí, además de mostrar el dinero recaudado, dar la opción de recaudar y recargar
                                String[] opcionesRecaudacion = {"Recaudar", "Recargar"};

                                int opcionRecaudacion = (JOptionPane.showOptionDialog(null, "Recaudación en Efectivo " + Arrays.toString(maquina1.getEfectivoMaquina().getCantidadMonedas()) + "\n Ultima recolecta: " + mAdmin.verUltimaRecaudacion(), null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesRecaudacion, null));

                                switch (opcionRecaudacion) {
                                    case 0:

                                        mAdmin.recaudarEfectivo(maquina1);

                                        break;
                                    case 1:

                                        String moneda10 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Monedas de 10 "));
                                        int moneda10Int = Integer.parseInt(moneda10);

                                        String moneda20 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Monedas de 20 "));
                                        int moneda20Int = Integer.parseInt(moneda20);

                                        String moneda50 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Monedas de 50 "));
                                        int moneda50Int = Integer.parseInt(moneda50);

                                        String moneda1 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Monedas de 1 "));
                                        int moneda1Int = Integer.parseInt(moneda1);

                                        String moneda2 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Monedas de 2 "));
                                        int moneda2Int = Integer.parseInt(moneda2);

                                        String billete5 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Billetes de 5 "));
                                        int billete5Int = Integer.parseInt(billete5);

                                        String billete10 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Billetes de 10"));
                                        int billete10Int = Integer.parseInt(billete10);

                                        String billete20 = (JOptionPane.showInputDialog("Introduzca una nueva cantidad de Billetes de 20"));
                                        int billete20Int = Integer.parseInt(billete20);

                                        Efectivo efectivoARecargar = new Efectivo(moneda10Int, moneda20Int, moneda50Int, moneda1Int, moneda2Int, billete5Int, billete10Int, billete20Int);
                                        mAdmin.recargarEfectivo(maquina1, efectivoARecargar);

                                        break;
                                }

                            case 8:
                                JOptionPane.showMessageDialog(null, "Ha recaudado desde que se inició la máquina: " + tarjetaDouble
                                        + " €");
                                break;
                        }
                        aux = false;
                }
                aux = false;
            }
            if (opcionesInt == 2) {
                JOptionPane.showMessageDialog(null, "Salir de la compra. Reanudando estado.");
            }
        } while (!aux);

    }
}
