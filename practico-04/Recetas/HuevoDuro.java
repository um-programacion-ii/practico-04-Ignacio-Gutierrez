package Recetas;

import Entidades.Elemento;
import Entidades.Receta;
import Entidades.Utensilio;
import Interfaces.Cocinable;

public class HuevoDuro extends Receta implements Cocinable {
    public HuevoDuro() {
        super(10, new Elemento[]{new Elemento("Huevo", 1),
                                                 new Elemento("Agua", 400)},
                               new Utensilio[]{new Utensilio("Olla", 1),
                                                 new Utensilio("Cuchara", 1)},
                                      "Hervir el huevo durante 10 minutos");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando la receta...");
    }


}