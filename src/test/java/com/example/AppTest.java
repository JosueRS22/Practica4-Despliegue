package com.example;

import static org.junit.Assert.*; // Importa los asserts reales
import org.junit.Test;

public class AppTest {

    @Test // Esto le dice a Maven: "¡Oye, esto es una prueba!"
    public void pruebaCicloDeVida() {
        Agenda.getTareas().clear();
        
        // Probar Adición
        Agenda.getTareas().add(new Tarea("Test"));
        assertEquals("La lista debería tener 1 tarea", 1, Agenda.getTareas().size());

        // Probar Estado
        Agenda.getTareas().get(0).setCompletada(true);
        assertTrue("La tarea debería estar completada", Agenda.getTareas().get(0).isCompletada());
    }

    // Puedes mantener este para tu menú si quieres, pero es redundante
    public static void ejecutarPruebas() {
        new AppTest().pruebaCicloDeVida();
        System.out.println(">> [OK] Pruebas pasadas.");
    }
}