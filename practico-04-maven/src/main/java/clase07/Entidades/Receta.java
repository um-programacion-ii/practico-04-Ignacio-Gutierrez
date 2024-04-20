package clase07.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {
    protected int tiempoCoccion;
    protected Elemento[] elementos;
    protected Utensilio[] utensilios;
    protected String preparacion;

    public void mostrarReceta() {
        System.out.println("Tiempo de cocción: " + tiempoCoccion + " minutos");
        System.out.println("Ingredientes:");
        for (Elemento elemento : elementos) {
            System.out.println(elemento.getNombre() + ": " + elemento.getCantidad());
        }
        System.out.println("Preparación: " + preparacion);
    }

    public Elemento[] getIngredientes() {
        return this.elementos;
    }
}
