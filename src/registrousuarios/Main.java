package registrousuarios;

import java.util.Scanner;

/**
 *
 * @author Carlos Contreras
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista<Usuario> lista = new Lista<>();
        int criterioAux = registrousuarios.UtilsCriterioOrdenamiento.POR_NOMBRE; // Default

        System.out.println("----------------------------------------------------------------------------------------"
                + "\n\t\t\t\t  Registro de Usuarios"
                + "\n----------------------------------------------------------------------------------------");

        int opcion = 1;
        int opcionAux = 1;
        while (opcion != 0) {
            System.out.println("\n1. Seleccionar un criterio de ordenamiento."
                    + "\n2. Captura"
                    + "\n3. Consultar"
                    + "\n0. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 0: // 0. Salir
                    System.out.println("\nHa finalizado el programa correctamente.");
                    break;
                default:
                    System.out.println("\nFavor de ingresar una opción del menú.");
                    break;
                case 1: // 1. Seleccionar criterio de ordenamiento
                    System.out.println("\nOrdenar por:"
                            + "\n\t1. Nombre (default)"
                            + "\n\t2. Edad"
                            + "\n\t3. Estatura"
                            + "\n\t4. Edad-Estatura-Nombre"
                            + "\n\t0. Salir sin cambios.");
                    opcionAux = scanner.nextInt();

                    switch (opcionAux) {
                        case 0: // 0. Salir sin cambios.
                            continue;
                        default:
                            System.out.println("\nFavor de ingresar una opción del menú.");
                            break;
                        case 1: // 1. Nombre (default)
                            criterioAux = UtilsCriterioOrdenamiento.POR_NOMBRE;
                            break;
                        case 2: // 2. Edad
                            criterioAux = UtilsCriterioOrdenamiento.POR_EDAD;
                            break;
                        case 3: // 3. Estatura
                            criterioAux = UtilsCriterioOrdenamiento.POR_ESTATURA;
                            break;
                        case 4: // 4. Edad-Estatura-Nombre
                            criterioAux = UtilsCriterioOrdenamiento.POR_EDAD_ESTATURA_NOMBRE;
                            break;
                    }
                    Ordenamiento.ordenamientoIntercambio(lista, criterioAux);
                    System.out.println("La lista se ha ordenado correctamente por el criterio seleccionado.");
                    break;
                case 2: // 2. Captura
                    System.out.println("\nIngrese el nombre del usuario: ");
                    String nombreAux = scanner.next();
                    System.out.println("Ingrese la edad del usuario: ");
                    int edadAux = scanner.nextInt();
                    System.out.println("Ingrese la estatura del usuario: ");
                    double estaturaAux = scanner.nextDouble();

                    Usuario usuario = new Usuario(nombreAux, edadAux, estaturaAux, criterioAux);
                    lista.InsertaOrdenado(usuario);
                    break;
                case 3: // 3. Consultar
                    System.out.print("\nSe muestra la lista de usuarios ordenados por el criterio de: ");
                    // Clean Code ¿Qué se ve más limpio? ¿Usar switch o if's?
                    switch (criterioAux) {
                        case UtilsCriterioOrdenamiento.POR_NOMBRE:
                            System.out.println("Nombre");
                            break;
                        case UtilsCriterioOrdenamiento.POR_EDAD:
                            System.out.println("Edad");
                            break;
                        case UtilsCriterioOrdenamiento.POR_ESTATURA:
                            System.out.println("Estatura");
                            break;
                        case UtilsCriterioOrdenamiento.POR_EDAD_ESTATURA_NOMBRE:
                            System.out.println("Edad-Estatura-Nombre");
                            break;
                    }
                    consultarLista(lista);
            }
        }
    }

    public static void consultarLista(Lista<Usuario> lista) {
        Nodo<Usuario> nodoAux = lista.getFrente();
        while (nodoAux != null) {
            System.out.println(nodoAux.Info.mostrarInformacion());
            nodoAux = nodoAux.getSig();
        }
        System.out.println("");
    }
}
