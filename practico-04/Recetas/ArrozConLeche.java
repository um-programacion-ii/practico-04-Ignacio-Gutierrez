package Recetas;

import Entidades.Elemento;
import Entidades.Receta;
import Entidades.Utensilio;
import Interfaces.Cocinable;

public class ArrozConLeche extends Receta implements Cocinable {
    public ArrozConLeche() {
        super(45, new Elemento[]{new Elemento("Arroz", 200),
                                                new Elemento("Leche", 1000),
                                                new Elemento("Azucar", 100),
                                                new Elemento("Canela", 5)},
                               new Utensilio[]{new Utensilio("Olla", 1),
                                              new Utensilio("Cuchara", 1)},
                                                "Cocinar el arroz con leche, azúcar y canela durante 45 minutos");
    }
    @Override
    public void cocinar() {
        System.out.println("Cocinando la receta...");
    }


}
