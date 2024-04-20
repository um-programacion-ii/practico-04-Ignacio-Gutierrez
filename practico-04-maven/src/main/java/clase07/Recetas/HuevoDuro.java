package clase07.Recetas;

import clase07.Entidades.Elemento;
import clase07.Entidades.Receta;
import clase07.Entidades.Utensilio;
import clase07.Interfaces.Cocinable;

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