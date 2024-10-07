/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matricula_estudiantes;
import java.util.Scanner;
/**
 *
 * @author Camilo Gallego B
 */
public class Matricula_estudiantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Ingrese los datos del estudiante: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellido = scanner.next(); 
        scanner.nextLine();  
        System.out.print("Documento: ");
        String documento = scanner.nextLine(); 
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Semestre (1 - 10): ");
        int semestre = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("¿El estudiante hace curso en línea? (SI o NO): ");
        String cursoEnlinea = scanner.nextLine().toUpperCase();  

        
        System.out.println("\nSeleccione la carrera: ");
        System.out.println(" 1. Ingeniería de Sistemas");
        System.out.println(" 2. Administración de Empresas");
        System.out.println(" 3. Medicina");
        System.out.print("Opción: ");
        int opcionCarrera = scanner.nextInt();
        scanner.nextLine();
        String carrera = "";
        switch(opcionCarrera){
        case 1:
            carrera = "Ingeniería de Sistemas";
            break;
        case 2:
            carrera = "Administracion de Empresas";
            break;
        case 3: 
            carrera = "Medicina";
            break;
        default:
            System.out.println("Opcion de carrera no valido");
            return;
        }

        
        System.out.print("¿El estudiante tiene materias aplazadas? (SI o NO): ");
        String tieneAplazadas = scanner.nextLine().toUpperCase();  

        Estudiante estudiante = null;

       
        if (tieneAplazadas.equals("NO")) {
            estudiante = new Estudiante(nombre, apellido, documento, direccion, telefono, cursoEnlinea, semestre, carrera);
            
        } else if (tieneAplazadas.equals("SI")) {
            System.out.print("Ingrese la cantidad de créditos aplazados: ");
            int creditosAplazados = scanner.nextInt();
            scanner.nextLine(); 
            estudiante = new EstudianteConMateriasAplazadas(nombre, apellido, documento, direccion, telefono, cursoEnlinea, semestre, creditosAplazados,  carrera);
        }

        
        estudiante.imprimirrecibo();
        scanner.close();
    }
}
