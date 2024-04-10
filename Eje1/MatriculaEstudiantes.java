import java.util.Scanner;

public class MatriculaEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Mostrar el menú de carreras
        System.out.println("Bienvenido al sistema de matrícula de estudiantes");
        System.out.println("Por favor, seleccione la carrera:");
        System.out.println("1. Ingeniería de Sistemas");
        System.out.println("2. Administración de Empresas");
        System.out.println("3. Psicología");
        System.out.print("Ingrese el número de la carrera: ");
        int carrera = scanner.nextInt();
        
        // Pedir datos del estudiante
        System.out.println("\nPor favor, ingrese los datos del estudiante:");
        System.out.print("Nombres: ");
        String nombres = scanner.next();
        System.out.print("Apellidos: ");
        String apellidos = scanner.next();
        System.out.print("Documento: ");
        String documento = scanner.next();
        System.out.print("Dirección: ");
        String direccion = scanner.next();
        System.out.print("Teléfono: ");
        String telefono = scanner.next();
        
        // Determinar si el estudiante tiene materias aplazadas
        System.out.print("¿El estudiante tiene materias aplazadas? (si/no): ");
        String tieneMateriasAplazadas = scanner.next();
        
        // Calcular el costo de la matrícula
        double costoMatricula = 1500.0; // Precio base
        int semestreActual;
        semestreActual=1;
        if (tieneMateriasAplazadas.equalsIgnoreCase("no")) {
            System.out.print("Ingrese el semestre actual del estudiante: ");
            semestreActual = scanner.nextInt();
            if (semestreActual >= 5) {
                costoMatricula *= 1.05; // Aumento del 5% a partir del quinto semestre
            }
        } else {
            System.out.print("Ingrese el total de créditos del semestre: ");
            int totalCreditos = scanner.nextInt();
            if (semestreActual <= 3) {
                costoMatricula += totalCreditos * 20; // Costo por créditos para primeros tres semestres
            } else if (semestreActual <= 6) {
                costoMatricula += totalCreditos * 25; // Costo por créditos para siguientes tres semestres
            } else {
                costoMatricula += totalCreditos * 30; // Costo por créditos para los demás semestres
            }
        }
        
        // Imprimir recibo de inscripción
        System.out.println("\nRecibo de Inscripción:");
        System.out.println("----------------------------");
        System.out.println("Carrera: " + getCarreraName(carrera));
        System.out.println("Estudiante: " + nombres + " " + apellidos);
        System.out.println("Documento: " + documento);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Costo de Matrícula: $" + costoMatricula);
        System.out.println("----------------------------");
        
        scanner.close();
    }
    
    public static String getCarreraName(int codigo) {
        switch(codigo) {
            case 1:
                return "Ingeniería de Sistemas";
            case 2:
                return "Administración de Empresas";
            case 3:
                return "Psicología";
            default:
                return "Carrera no especificada";
        }
    }
}
