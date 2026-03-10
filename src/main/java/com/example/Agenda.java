package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    private static List<Tarea> tareas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=================================================");
            System.out.println(" ORGANIZADOR DE TAREAS ");
            System.out.println("=================================================");
            System.out.println("1. Agregar una nueva tarea");
            System.out.println("2. Listar todas las tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar una tarea");
            System.out.println("5. Ejecutar auto-diagnóstico (Tests)");
            System.out.println("6. Salir");
            System.out.println("=================================================");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    agregarTarea();
                    break;
                case "2":
                    listarTareas();
                    break;
                case "3":
                    marcarTarea();
                    break;
                case "4":
                    eliminarTarea();
                    break;
                case "5":
                try {
                    // Buscamos la clase por nombre de forma dinámica
                    Class<?> clazz = Class.forName("com.example.AppTest");
                    clazz.getMethod("ejecutarPruebas").invoke(null);
                } catch (ClassNotFoundException e) {
                    System.out.println(">> [ERROR] No se encontró la clase de pruebas en el classpath.");
                } catch (Exception e) {
                    System.out.println(">> [ERROR] Error al ejecutar pruebas: " + e.getMessage());
                }
                break;
                case "6": 
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void agregarTarea() {
        System.out.print("Descripción: ");
        tareas.add(new Tarea(scanner.nextLine()));
    }

    private static void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("Agenda vacía.");
            return;
        }
        
        System.out.println("\n--- LISTA DE TAREAS ---");
        for (int i = 0; i < tareas.size(); i++) {
            Tarea t = tareas.get(i);
            String estado = t.isCompletada() ? "Completada" : "Pendiente";
            System.out.printf("%d. \"%s\" : %s%n", i + 1, t.getDescripcion(), estado);
        }
    }

    private static void marcarTarea() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para marcar.");
            return;
        }
        listarTareas();
        System.out.print("Número de tarea a completar: ");
        try {
            int idx = Integer.parseInt(scanner.nextLine()) - 1;
            if (idx >= 0 && idx < tareas.size()) {
                tareas.get(idx).setCompletada(true);
                System.out.println("¡Tarea completada!");
            } else {
                System.out.println("Número fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un número válido.");
        }
    }

    private static void eliminarTarea() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para eliminar.");
            return;
        }
        listarTareas();
        System.out.print("Número de tarea a eliminar: ");
        try {
            int idx = Integer.parseInt(scanner.nextLine()) - 1;
            if (idx >= 0 && idx < tareas.size()) {
                tareas.remove(idx);
                System.out.println("Tarea eliminada.");
            } else {
                System.out.println("Número fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida.");
        }
    }

    public static List<Tarea> getTareas() { 
        return tareas; 
    }
}