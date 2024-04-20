package clase07.Entidades;

import clase07.Interfaces.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elemento implements Ingrediente {
    private String nombre;
    private int cantidad;

    public void despensar(int cantidadARetirar) {
        if (this.cantidad >= cantidadARetirar) {
            this.cantidad -= cantidadARetirar;
            System.out.println("Se retiró " + cantidadARetirar + " de " + nombre + ", quedan " + cantidad+ ".");
        } else {
            System.out.println("No es posible retirar " + cantidadARetirar + " de " + nombre + ", quedan " + cantidad + ".");
        }
    }

    @Override
    public void getClass(int i) {

    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Quedan " + cantidad + " de " + nombre + ".";
    }
}
