package Recetas;

import Entidades.Ingrediente;
import Entidades.Receta;
import Entidades.Utensilio;
import Interfaces.Cocinable;

public class TartaDeManzana extends Receta implements Cocinable {
    public TartaDeManzana() {
        super(60, new Ingrediente[]{new Ingrediente("Masa de hojaldre", 1),
                        new Ingrediente("Manzanas", 4),
                        new Ingrediente("Azúcar", 150),
                        new Ingrediente("Canela", 10)},
                new Utensilio[]{new Utensilio("Molde para tarta", 1),
                        new Utensilio("Cuchillo", 1),
                        new Utensilio("Horno", 1)},
                "Preparar la masa de hojaldre en el molde, cortar las manzanas en rodajas y colocarlas sobre la masa. Espolvorear con azúcar y canela, y hornear durante 60 minutos a 180°C.");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando la receta...");
    }
}
