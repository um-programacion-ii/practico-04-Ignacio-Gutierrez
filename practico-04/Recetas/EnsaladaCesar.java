package Recetas;

import Entidades.Ingrediente;
import Entidades.Receta;
import Entidades.Utensilio;
import Interfaces.Cocinable;

public class EnsaladaCesar extends Receta implements Cocinable {
    public EnsaladaCesar() {
        super(15, new Ingrediente[]{new Ingrediente("Lechuga romana", 1),
                        new Ingrediente("Pechuga de pollo", 1),
                        new Ingrediente("Pan de molde", 2),
                        new Ingrediente("Queso parmesano", 50),
                        new Ingrediente("Salsa César", 50)},
                new Utensilio[]{new Utensilio("Tabla de cortar", 1),
                        new Utensilio("Cuchillo", 1),
                        new Utensilio("Sartén", 1)},
                "Cortar el pan en cubos y dorarlo en una sartén con un poco de aceite hasta que esté crujiente. Cortar la lechuga y la pechuga de pollo en trozos. Mezclar la lechuga, el pollo, el pan tostado y la salsa César en un tazón grande. Espolvorear con queso parmesano rallado y servir.");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando la receta...");
    }
}
