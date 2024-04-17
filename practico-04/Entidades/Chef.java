package Entidades;

import Servicios.CocinaService;
import Servicios.DespensaService;
public class Chef {
    private final String nombre;
    private final int estrellasMichelin;
    private final Despensa despensa;

    public Chef(String nombre, int estrellasMichelin, Despensa despensa) {
        this.nombre  = nombre;
        this.estrellasMichelin = estrellasMichelin;
        this.despensa = despensa;
    }

    public void prepararReceta(int numeroReceta) {
        try {
            boolean listosParaCocinar = DespensaService.verificarStockYVidaUtil(numeroReceta, despensa);
            if (listosParaCocinar) {
                CocinaService.comenzarACocinar(numeroReceta, despensa);
                Thread.sleep(4000);
                System.out.println("El Chef " + nombre + ", con " + estrellasMichelin + " estrellas Michelin, espera que disfrute su comida.");
            } else {
                System.out.println("El Chef " + nombre + ", con " + estrellasMichelin + " estrellas Michelin, dice que debe pedir algo del menú.");
            }
        } catch (Exception  e) {
            System.out.println("Receta no disponible en el menú.");
        }
    }

    @Override
    public String toString() {
        return "El Chef " + nombre + " tiene " + estrellasMichelin + " estrellas Michelin.";
    }
}
