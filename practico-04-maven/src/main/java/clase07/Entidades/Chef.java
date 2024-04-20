package clase07.Entidades;

import clase07.Servicios.CocinaService;
import clase07.Servicios.DespensaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

@AllArgsConstructor
@NoArgsConstructor
public class Chef {
    private String nombre;
    private int estrellasMichelin;
    private Despensa despensa;
    private Estante estante;
    private Queue<Integer> recetasPendientes;

    public Chef(String nombre, int estrellasMichelin, Despensa despensa, Estante estante) {
        this.nombre = nombre;
        this.estrellasMichelin = estrellasMichelin;
        this.despensa = despensa;
        this.estante = estante;
        this.recetasPendientes = new LinkedList<>();
    }

    public void agregarRecetaPendiente(Integer receta) {
        recetasPendientes.add(receta);
    }

    public void prepararReceta() {
        while (!recetasPendientes.isEmpty()) {
            Integer receta = recetasPendientes.poll();
            System.out.printf("El Chef %s está preparando la receta %d.\n", nombre, receta);
            try {
                boolean stockIngredientes = DespensaService.verificarStockIngredientes(receta, despensa);
                boolean utensiliosSuficientes = DespensaService.verificarVidaUtilUtensilios(receta, estante);
                if (stockIngredientes && utensiliosSuficientes) {
                    CocinaService.comenzarACocinar(receta, despensa, estante);
                    System.out.println("El Chef " + nombre + ", con " + estrellasMichelin + " estrellas Michelin, espera que disfrute su comida.");
                } else if (!utensiliosSuficientes) {
                    System.out.printf("Utensilios necesarios ocupados para preparar: " + receta + ".\n");
                    recetasPendientes.add(receta);
                } else {
                    System.out.printf("Ingredientes insuficientes para preparar: " + receta + ".\n");
                }
            } catch (Exception  e) {
                System.out.println("Receta no disponible en el menú.");
            }
        }
    }

    @Override
    public String toString() {
        return "El Chef " + nombre + " tiene " + estrellasMichelin + " estrellas Michelin.";
    }
}
