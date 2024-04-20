package clase07.Recetas;

import clase07.Entidades.Elemento;
import clase07.Entidades.Receta;
import clase07.Entidades.Utensilio;
import clase07.Interfaces.Cocinable;

public class TartaDeManzana extends Receta implements Cocinable {
    public TartaDeManzana() {
        super(60, new Elemento[]{new Elemento("Masa de hojaldre", 1),
                        new Elemento("Manzanas", 4),
                        new Elemento("Azúcar", 150),
                        new Elemento("Canela", 10)},
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
