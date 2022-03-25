/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Hospital {
    
    private String nombre;
    private String direccion;
    private int numeroCamas;
    
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Paciente> listaPacientes;

    public void contratarEmpleado(Empleado e){
        listaEmpleados.add(e);
    }
    
    public void ingresarPaciente(Paciente p){
        // Se puede controlar que el número de pacientes si supera al número de camas
        // entonces el hospital haga algo
        listaPacientes.add(p);
    }
    
    public Hospital(String nombre, String direccion, int numeroCamas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroCamas = numeroCamas;
        this.listaEmpleados = new ArrayList<>();
        this.listaPacientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }


    
    
    
}
