///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
// */
//package daw.poo.maquinavending.gabrielallendejuanjosebazan;
//
//import java.util.Scanner;
//
///**
// *
// * @author Naturalkid
// */
//public class NewMain {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//
//        ModoAdmin ma = new ModoAdmin();
//
//        ma.generarCodigoAdmin();
//
//   System.out.println(ma.mostrarCodigoAdmin());
//
//        Productos patata = new Productos("Producto1", 1);
//        Bandejas patataBandeja = new Bandejas(patata, 15, 1111);
//
//        //Instanciación de objetos.
//        Productos cocaCola = new Productos("Coca-Cola 500ml", 120);
//        Productos kitKat = new Productos("Kit-Kat", 150);
//        Productos agua = new Productos("Agua 500ml", 100);
//        Productos smint = new Productos("Caramelos Smint", 100);
//        Productos fantaNaranja = new Productos("Fanta Naranja 500ml", 120);
//        Productos haribbo = new Productos("Caramelos Haribbo", 200);
//        Productos productoElegido;
//        // crear bandejas
//        Bandejas bandeja1 = new Bandejas(cocaCola, 15, 1);
//        Bandejas bandeja2 = new Bandejas(kitKat, 15, 2);
//        Bandejas bandeja3 = new Bandejas(agua, 15, 3);
//        Bandejas bandeja4 = new Bandejas(smint, 15, 4);
//        Bandejas bandeja5 = new Bandejas(fantaNaranja, 15, 5);
//        Bandejas bandeja6 = new Bandejas(haribbo, 15, 6);
//
//////        Maquinas maquina1 = new Maquinas(bandeja1, bandeja2, bandeja3, bandeja4, bandeja5, bandeja6, true, true);
////
////        System.out.println(ma.consultarCodBandeja(maquina1, bandeja1));
////        ma.cambiarCodigoBandeja(maquina1, bandeja1, 1234);
////        System.out.println(ma.consultarCodBandeja(maquina1, bandeja1));
////
////        System.out.println(ma.consultarProducto(maquina1, bandeja1));
////        ma.cambiarProducto(maquina1, bandeja1, agua);
////        System.out.println(ma.consultarProducto(maquina1, bandeja1));
////        
////        System.out.println(ma.consultarStock(maquina1, bandeja1));
////        ma.cambiarStock(maquina1, bandeja1, 10);
////        System.out.println(ma.consultarStock(maquina1, bandeja1));
////    
////          System.out.println(maquina1.getContenedor());
////          //estructura para mover el producto escogido al contenedor
////          productoElegido = agua;
////          maquina1.getContenedor().setProductoContenedor(productoElegido);
////          System.out.println(maquina1.getContenedor().getProductoContenedor());
////          //
////    }
////
////}
