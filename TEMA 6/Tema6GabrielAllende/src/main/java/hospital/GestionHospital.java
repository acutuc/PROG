package hospital;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class GestionHospital {

    /**
     * @param args the command line arguments
     */
    //Atributo privado de clase.
    private static Hospital hospital;

    public static void main(String[] args) {
        //Instancio nuevo hospital.
        hospital = new Hospital("Hospital Costa del Sol", "Marbella", 450);

        //Instancio 10 NIFs para asignárselos a 5 pacientes, 2 médicos y 3 administrativos.
        NIF nif1 = new NIF("56732950", LocalDate.of(2015, Month.MARCH, 18));
        NIF nif2 = new NIF("16732950", LocalDate.of(2016, Month.APRIL, 20));
        NIF nif3 = new NIF("51673250", LocalDate.of(2017, Month.MAY, 14));
        NIF nif4 = new NIF("99732950", LocalDate.of(2018, Month.JUNE, 29));
        NIF nif5 = new NIF("67324950", LocalDate.of(2019, Month.JULY, 30));
        NIF nif6 = new NIF("98452158", LocalDate.of(2015, Month.OCTOBER, 7));
        NIF nif7 = new NIF("45548697", LocalDate.of(2013, Month.OCTOBER, 30));
        NIF nif8 = new NIF("44995638", LocalDate.of(2018, Month.JANUARY, 11));
        NIF nif9 = new NIF("88955158", LocalDate.of(2020, Month.FEBRUARY, 13));
        NIF nif10 = new NIF("24946514", LocalDate.of(2021, Month.DECEMBER, 20));

        //PONGO DE NOMBRE EL TIPO DE EMPLEADO QUE SON, PARA SIMPLICIDAD DEL EJERCICIO AL LEER LOS SYSTEM.OUT.PRINT
        //Contrato 5 empleados; 2 médicos y 3 administrativos.
        Medico med1 = new Medico("Cirujano", "AN823589235358", 4500, "Medico1", "Cirujano", nif1);
        Medico med2 = new Medico("Pediatra", "AN647456345308", 2000, "Medico2", "Pediatra", nif2);
        Administrativo adm1 = new Administrativo(Grupo.C, "AN58469346943562", 1400, "Administrativo1", "Grupo C", nif3);
        Administrativo adm2 = new Administrativo(Grupo.D, "AN87283534603452", 1550, "Administrativo2", "Grupo D", nif4);
        Administrativo adm3 = new Administrativo(Grupo.E, "AN47823504546346", 1350, "Administrativo3", "Grupo E", nif5);

        //Ingreso a 5 pacientes.
        Paciente pac1 = new Paciente("5466543", "Paciente1", "Apellido1", nif6);
        Paciente pac2 = new Paciente("6186138", "Paciente2", "Apellido2", nif7);
        Paciente pac3 = new Paciente("8946461", "Paciente3", "Apellido3", nif8);
        Paciente pac4 = new Paciente("4594819", "Paciente4", "Apellido4", nif9);
        Paciente pac5 = new Paciente("5119895", "Paciente5", "Apellido5", nif10);

        //Meto a todos los empleados en la lista de empleados del hospital.
        hospital.getListaEmpleados().add(med1);
        hospital.getListaEmpleados().add(med2);
        hospital.getListaEmpleados().add(adm1);
        hospital.getListaEmpleados().add(adm2);
        hospital.getListaEmpleados().add(adm3);

        //Meto a todos los pacientes en la lista de pacientes del hospital.
        hospital.getListaPacientes().add(pac1);
        hospital.getListaPacientes().add(pac2);
        hospital.getListaPacientes().add(pac3);
        hospital.getListaPacientes().add(pac4);
        hospital.getListaPacientes().add(pac5);

        //Cojo a un médico y a un paciente aleatoriamente.
        Random aleatorio = new Random();
        int numAleatorioMedico = aleatorio.nextInt(5); //Sólo tengo 5 empleados; posición 0-4
        int numAleatorioPaciente = aleatorio.nextInt(5); //Sólo tengo 5 pacientes; posición 0-4

        //Declaro auxiliares para utilizar en el bucle do-while.
        Medico medaux;
        Empleado empaux;
        Paciente pacaux;

        //Bucle do-while que me coge un médico al azar, de la lista de empleados, y un paciente al azar. Aplico método tratar();
        do {
            empaux = hospital.getListaEmpleados().get(numAleatorioMedico);
            if (empaux instanceof Medico) {
                medaux = (Medico) empaux;
                medaux.tratar(hospital.getListaPacientes().get(numAleatorioPaciente), "Pancetamol :)");
            }
        } while (!(empaux instanceof Medico));


        //Ejecuto el método abstracto de todos los empleados:
        for (Empleado emp : hospital.getListaEmpleados()) {
            if (emp instanceof Medico) {
                Medico aux = (Medico) emp;
                System.out.println("IRPF del Médico " + aux.getNombre() + " " + aux.getApellidos());
                System.out.println(aux.calcularIRPF());
            }
            if (emp instanceof Administrativo) {
                Administrativo aux = (Administrativo) emp;
                System.out.println("IRPF del Administrativo " + aux.getNombre() + " " + aux.getApellidos());
                System.out.println(aux.calcularIRPF());
            }
        }

        //Renuevo el nif a un paciente.
        System.out.println("NIF antes de renovar:");
        System.out.println(hospital.getListaPacientes().get(0).getNif());
        hospital.getListaPacientes().get(0).renovarNIF(LocalDate.now());
        System.out.println("NIF después de renovar:");
        System.out.println(hospital.getListaPacientes().get(0).getNif());

    }

    //Métodos
    public static Paciente crearPaciente() {
        return new Paciente();
    }

    public static Medico crearMedico() {
        return new Medico();
    }

    public static Administrativo crearPersonalPAS() {
        return new Administrativo();
    }

}
