/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula_estudiantes;
import java.util.Scanner;

/**
 *
 * @author Camilo Gallego B
 */

public class Estudiante {
    private String nombre;
    private String apellido;
    private String documento;
    private String direccion;
    private String telefono;
    private String cursoEnlinea;
    private int semestre;
    private String carrera;
    
    public Estudiante(String nombre, String apellido, String documento, String direccion, String telefono, String cursoEnlinea, int semestre, String carrera ){
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento; 
        this.direccion = direccion;
        this.telefono = telefono;
        this.cursoEnlinea = cursoEnlinea;
        this.semestre = semestre;
        this.carrera = carrera;
    }
    public String getnombre(){return nombre;}
    public String getapellido(){return apellido;}
    public String getdocumento(){return documento;}
    public String getdireccion(){return direccion ; }
    public String gettelefono(){return telefono;}
    public String iscursoEnlinea(){return cursoEnlinea;}
    public int getsemestre(){return semestre;}
    public String getcarrera(){return carrera;}
    
    public double calcularMatricula(){
        double montobase = 1500.0;
        if(semestre >= 5){
            montobase += montobase * 0.05;
        }
        return montobase;
    }
    public void imprimirrecibo(){
        System.out.println("---------------- RECIBO DE MATRICULA -----------------------");
        System.out.println("Nombre: " + nombre + apellido);
        System.out.println("Documento: " + documento);
        System.out.println("Direccion: "+ direccion);
        System.out.println("Telefono: "+ telefono);
        System.out.println("Carrera: " + carrera);
        System.out.println("Semestre: "+ semestre);
        System.out.println("Curso en linea: " + cursoEnlinea );
        System.out.println("Total a pagar: $" + calcularMatricula());
    }
    
}
class EstudianteConMateriasAplazadas extends Estudiante {
    private int CreditosAplazados;
    
    public EstudianteConMateriasAplazadas(String nombre, String apellido, String documento, String direccion, String telefono, String cursoEnlinea, int semestre, int CreditosAplazados, String carrera){
        super(nombre, apellido, documento, direccion, telefono, cursoEnlinea, semestre,carrera);
        this.CreditosAplazados = CreditosAplazados;
    }
    @Override
    public double calcularMatricula(){
        double montoBase = super.calcularMatricula();
        double costocredito = 0;
        
        if(getsemestre() >= 1 && getsemestre() <=3){
            costocredito = 20;
        }else if (getsemestre()>=4 && getsemestre()<=6){
            costocredito = 25;
        }else{
            costocredito = 30;
        }
        double costoAplazadas = CreditosAplazados * costocredito;
        return montoBase + costoAplazadas; 
    }
    public void imprimirRecibo(){
        super.imprimirrecibo();
        System.out.println("Creditos aplazados: " + CreditosAplazados);
    }
}