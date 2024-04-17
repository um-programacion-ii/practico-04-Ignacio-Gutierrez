package Recetas;

import Entidades.Ingrediente;
import Entidades.Receta;
import Entidades.Utensilio;
import Interfaces.Cocinable;

public class HuevoDuro extends Receta implements Cocinable {
    public HuevoDuro() {
        super(10, new Ingrediente[]{new Ingrediente("Huevo", 1),
                                                 new Ingrediente("Agua", 400)},
                               new Utensilio[]{new Utensilio("Olla", 1),
                                                 new Utensilio("Cuchara", 1)},
                                      "Hervir el huevo durante 10 minutos");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando la receta...");
    }


}