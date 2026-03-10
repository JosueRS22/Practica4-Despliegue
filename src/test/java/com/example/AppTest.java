package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    @Test
    public void pruebaCicloDeVida() {
        Agenda.getTareas().clear();
        
        Agenda.getTareas().add(new Tarea("Test"));
        assertEquals("La lista debería tener 1 tarea", 1, Agenda.getTareas().size());

        Agenda.getTareas().get(0).setCompletada(true);
        assertTrue("La tarea debería estar completada", Agenda.getTareas().get(0).isCompletada());
    }

    public static void ejecutarPruebas() {
        new AppTest().pruebaCicloDeVida();
        System.out.println(">> [OK] Pruebas pasadas.");
    }
}
