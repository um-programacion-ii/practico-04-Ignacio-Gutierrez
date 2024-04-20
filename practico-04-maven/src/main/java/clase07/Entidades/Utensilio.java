package clase07.Entidades;

import clase07.Interfaces.Despensable;
import clase07.Interfaces.Reutilizable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utensilio implements Despensable, Reutilizable {
    private String nombre;
    private int vidaUtil;

    public void utilizar(int vidaUtilNecesaria) {
        if (vidaUtil >= vidaUtilNecesaria) {
            vidaUtil -= vidaUtilNecesaria;
            System.out.println("El utensilio " + nombre + " ha sido utilizado. Vida útil restante: " + vidaUtil);
        } else {
            System.out.println("El utensilio " + nombre + " ha llegado al final de su vida útil.");
        }
    }

    @Override
    public int getCantidad() {
        return 0;
    }

    @Override
    public void setCantidad(int i) {
    }

    @Override
    public void getClass(int i) {
    }

    @Override
    public void despensar(int cantidad) {

    }

    @Override
    public String toString() {
        return "Quedan " + vidaUtil + " usos de " + nombre + ".";
    }

}
