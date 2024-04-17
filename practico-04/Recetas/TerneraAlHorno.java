package Recetas;

import Entidades.Ingrediente;
import Entidades.Receta;
import Entidades.Utensilio;
import Interfaces.Cocinable;

public class TerneraAlHorno extends Receta implements Cocinable {
    public TerneraAlHorno() {
        super(60, new Ingrediente[]{new Ingrediente("Ternera", 1),
                                                new Ingrediente("Papa", 4)},
                               new Utensilio[]{new Utensilio("Bandeja", 1),
                                               new Utensilio("Cuchillo", 1),
                                               new Utensilio("Tenedor", 1)},
                                    "Cortar las papas a gusto y cocinar junto a la ternera en el horno por 60 minutos");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando la receta...");
    }

}