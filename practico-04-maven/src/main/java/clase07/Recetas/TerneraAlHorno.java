package clase07.Recetas;

import clase07.Entidades.Elemento;
import clase07.Entidades.Receta;
import clase07.Entidades.Utensilio;
import clase07.Interfaces.Cocinable;

public class TerneraAlHorno extends Receta implements Cocinable {
    public TerneraAlHorno() {
        super(60, new Elemento[]{new Elemento("Ternera", 1),
                                                new Elemento("Papa", 4)},
                               new Utensilio[]{new Utensilio("Bandeja", 1),
                                               new Utensilio("Cuchillo", 1),
                                               new Utensilio("Tenedor", 1),
                                               new Utensilio("Horno", 1)},
                                    "Cortar las papas a gusto y cocinar junto a la ternera en el horno por 60 minutos");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando la receta...");
    }

}