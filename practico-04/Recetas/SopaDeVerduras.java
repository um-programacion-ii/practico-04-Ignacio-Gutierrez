package Recetas;

import Entidades.Ingrediente;
import Entidades.Receta;
import Entidades.Utensilio;
import Interfaces.Cocinable;

public class SopaDeVerduras extends Receta implements Cocinable {
    public SopaDeVerduras() {
        super(40, new Ingrediente[]{new Ingrediente("Caldo de verduras", 1),
                        new Ingrediente("Zanahoria", 2),
                        new Ingrediente("Apio", 2),
                        new Ingrediente("Patata", 2),
                        new Ingrediente("Cebolla", 1),
                        new Ingrediente("Ajo", 2)},
                new Utensilio[]{new Utensilio("Olla", 1),
                        new Utensilio("Cuchillo", 1)},
                "Picar todas las verduras en trozos pequeños. En una olla grande, calentar el caldo de verduras a fuego medio. Agregar las verduras picadas y el ajo machacado a la olla. Cocinar a fuego lento durante unos 30 minutos o hasta que las verduras estén tiernas. Servir caliente.");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando la receta...");
    }
}
