package daw.poo.maquinavending.gabrielallendejuanjosebazan;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Naturalkid
 */

/*
Cosas a hacer:
- Generar código(s) admin
- Introducir código(s) admin

- Hacer que la máquina sepa que estemos con los permisos
- Consultar y cambiar el código de las bandejas.
- Consultar y cambiar el producto contenido en las bandejas.
- Consultar y cambiar el stock de las bandejas
- Consultar el efectivo que hay en la máquina y recaudar
- Recargar efectivo
- Consultar el dinero recaudado mediante tarjetas de crédito.
 */
public class ModoAdmin {

    private Random r = new Random();
    private String codAdmin;
    private LocalDate ultimaRecaudacion;

    public ModoAdmin() {
    }

    public void generarCodigoAdmin() {

        // el código debe tener Una minúscula (a - z), Una mayúscula (A - Z), Un número (0 - 9), Uno de los siguientes caracteres especiales: # $ % & ( ) * + , - .  : ; < = > @
        char codLetra1;
        char codLetra2;
        int codCarEsp;

        String letra1;
        String letra2;
        String num;
        String carEsp;

        codLetra1 = (char) (r.nextInt(122 - 97) + 97);

        letra1 = String.valueOf(codLetra1);

        codLetra2 = (char) (r.nextInt(90 - 65) + 65);

        letra2 = String.valueOf(codLetra2);

        String[] carEspArray = new String[16];

        carEspArray[0] = "#";
        carEspArray[1] = "$";
        carEspArray[2] = "%";
        carEspArray[3] = "(";
        carEspArray[4] = ")";
        carEspArray[5] = "*";
        carEspArray[6] = "+";
        carEspArray[7] = ",";
        carEspArray[8] = "-";
        carEspArray[9] = ".";
        carEspArray[10] = ":";
        carEspArray[11] = ";";
        carEspArray[12] = "<";
        carEspArray[13] = ">";
        carEspArray[14] = "=";
        carEspArray[15] = "@";

        codCarEsp = r.nextInt(carEspArray.length);

        carEsp = carEspArray[codCarEsp];

        num = RandomStringUtils.randomNumeric(5);

        //------
        codAdmin = letra1 + letra2 + num + carEsp;

    }

    public String mostrarCodigoAdmin() {

        return codAdmin;

    }

    public int consultarCodBandeja(Maquinas maquina, Bandejas bandeja) {

        return maquina.getBandeja(bandeja).getCodBandeja();

    }

    public void cambiarCodigoBandeja(Maquinas maquina, Bandejas bandeja, int codigoBandeja) {

        maquina.getBandeja(bandeja).setCodBandeja(codigoBandeja);

    }

    public Productos consultarProducto(Maquinas maquina, Bandejas bandeja) {

        return maquina.getBandeja(bandeja).getProducto();

    }

    public void cambiarProducto(Maquinas maquina, Bandejas bandeja, Productos producto) {

        maquina.getBandeja(bandeja).setProducto(producto);

    }

    public int consultarStock(Maquinas maquina, Bandejas bandeja) {

        return maquina.getBandeja(bandeja).getStockProducto();

    }

    public void cambiarStock(Maquinas maquina, Bandejas bandeja, int stock) {

        if (stock < 15 || stock > 0) {
            maquina.getBandeja(bandeja).setStockProducto(stock);
        }

    }

//    - Consultar el efectivo que hay en la máquina y recaudar
//- Recargar efectivo
    public Efectivo consultarEfectivo(Maquinas maquina) {

        return maquina.getEfectivoMaquina();

    }

    public void recaudarEfectivo(Maquinas maquina) {

        Efectivo efectivoRecaudado = new Efectivo(0, 0, 0, 0, 0, 0, 0, 0);
        maquina.setEfectivoMaquina(efectivoRecaudado);

        this.ultimaRecaudacion = LocalDate.now();

    }

    public LocalDate verUltimaRecaudacion() {

        return this.ultimaRecaudacion;

    }

    public void recargarEfectivo(Maquinas maquina, Efectivo efectivoARecargar) {

        maquina.setEfectivoMaquina(efectivoARecargar);

    }

}
