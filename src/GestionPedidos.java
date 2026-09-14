package src;
import java.util.Scanner;

/*
 * CLASE GestionPedidos.java
 * -------------------------
 * Controlador principal que maneja el menú y las dos pilas (Undo / Redo).
 */
public class GestionPedidos {

    public static void main(String[] args) {
        // Dos pilas manuales para gestionar el sistema Undo/Redo
        Pila pilaPrincipal = new Pila();  // Guarda los pedidos activos
        Pila pilaSecundaria = new Pila(); // Guarda los pedidos deshechos

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n--- SISTEMA DE GESTION DE PEDIDOS (PIZZA-TRACK) ---");
            System.out.println("1. Registrar Pizza (Escribir)");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual (Peek)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        // REGISTRAR PIZZA
                        System.out.print("Nombre de la pizza: ");
                        String nombre = sc.nextLine();

                        String[] ingredientes = new String[3];
                        System.out.println("Ingrese 3 ingredientes:");
                        for (int i = 0; i < 3; i++) {
                            System.out.print("  Ingrediente " + (i + 1) + ": ");
                            ingredientes[i] = sc.nextLine();
                        }

                        Pizza nuevaPizza = new Pizza(nombre, ingredientes);
                        pilaPrincipal.push(nuevaPizza);
                        
                        // Al registrar una nueva pizza, se limpia la pila de rehacer
                        while (!pilaSecundaria.isEmpty()) {
                            pilaSecundaria.pop();
                        }

                        System.out.println(">> ¡Pedido registrado correctamente!");
                        break;

                    case 2:
                        // DESHACER (UNDO)
                        if (pilaPrincipal.isEmpty()) {
                            System.out.println(">> No hay pedidos para deshacer.");
                        } else {
                            Pizza deshecha = pilaPrincipal.pop();
                            pilaSecundaria.push(deshecha);
                            System.out.println(">> Deshecho: " + deshecha.getNombre());
                        }
                        break;

                    case 3:
                        // REHACER (REDO)
                        if (pilaSecundaria.isEmpty()) {
                            System.out.println(">> No hay pedidos para rehacer.");
                        } else {
                            Pizza rehecha = pilaSecundaria.pop();
                            pilaPrincipal.push(rehecha);
                            System.out.println(">> Rehecho: " + rehecha.getNombre());
                        }
                        break;

                    case 4:
                        // MOSTRAR PEDIDO ACTUAL (PEEK)
                        Pizza actual = pilaPrincipal.peek();
                        if (actual != null) {
                            System.out.println(">> Pedido listo para produccion: " + actual);
                        } else {
                            System.out.println(">> No hay pedidos activos.");
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un numero valido.");
                sc.nextLine();
            }
        } while (opcion != 0);

        sc.close();
    }
}