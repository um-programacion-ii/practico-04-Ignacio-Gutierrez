package clase07.Entidades;

import clase07.Excepciones.StockInsuficiente;
import clase07.Interfaces.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Despensa {
    private Map<String, Ingrediente> elemento = new HashMap<>();


    public void addIngrediente(Ingrediente nuevoIngrediente) {
        String nombre = nuevoIngrediente.getNombre().toString();
        if (elemento.containsKey(nombre)) {
            Ingrediente existente = elemento.get(nombre);
            existente.getClass(existente.getCantidad() + nuevoIngrediente.getCantidad());
        } else {
            elemento.put(nombre, nuevoIngrediente);
        }
    }

    public void getIngrediente(String nombre, int cantidad) throws StockInsuficiente {
        if (elemento.containsKey(nombre)) {
            Ingrediente elemento = this.elemento.get(nombre);
            if (elemento.getCantidad() < cantidad) {
                throw new StockInsuficiente("No es posible retirar " + cantidad + " de " + nombre + ", no hay en la despensa.");
            }
            elemento.despensar(cantidad);
        } else {
            throw new StockInsuficiente("No es posible retirar " + cantidad + " de " + nombre + ", no hay en la despensa.");
        }
    }

    public boolean checkIngrediente(String nombre, int cantidad) throws StockInsuficiente {
        if (elemento.containsKey(nombre)) {
            Ingrediente elemento = this.elemento.get(nombre);
            if (elemento.getCantidad() >= cantidad) {
                return true;
            } else {
                throw new StockInsuficiente("No hay suficiente cantidad de " + nombre + " en la despensa.");
            }
        } else {
            throw new StockInsuficiente("No es posible retirar " + cantidad + " de " + nombre + ", no hay en la despensa.");
        }
    }

    public void mostrarIngrediente() {
        System.out.println("Elementos en la despensa:");
        for (Map.Entry<String, Ingrediente> entry : elemento.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getCantidad());
        }
    }

    public Map<String, Ingrediente> getElemento() {
        return elemento;
    }
}