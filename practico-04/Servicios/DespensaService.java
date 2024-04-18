package Servicios;

import Entidades.*;
import Excepciones.StockInsuficiente;
import Excepciones.VidaUtilInsuficiente;
import Interfaces.Cocinable;
import Interfaces.Ingrediente;
import Recetas.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class DespensaService {

    private static final Map<Integer, Cocinable> recetas = new HashMap<>();

    static {
        recetas.put(1, new ArrozConLeche());
        recetas.put(2, new HuevoDuro());
        recetas.put(3, new TerneraAlHorno());
        recetas.put(4, new EnsaladaCesar());
        recetas.put(5, new SopaDeVerduras());
        recetas.put(6, new TartaDeManzana());
    }


    public static boolean verificarStockYVidaUtil(int numeroReceta, Despensa despensa, Estante estante) {
        Receta receta = (Receta) recetas.get(numeroReceta);

        boolean ingredientesSuficientes = true;
        for (Elemento elemento : receta.getIngredientes()) {
            String nombreIngrediente = elemento.getNombre();
            int cantidadRequerida = elemento.getCantidad();
            try {
                despensa.checkIngrediente(nombreIngrediente, cantidadRequerida);
            } catch (StockInsuficiente e) {
                ingredientesSuficientes = false;
                System.out.println(e.getMessage());
                break;
            }
        }

        boolean utensiliosSuficientes = true;
        if (ingredientesSuficientes) {
            for (Utensilio utensilio : receta.getUtensilios()) {
                String nombreUtensilio = utensilio.getNombre();
                int vidaUtilRequerida = utensilio.getVidaUtil();
                try {
                    utensiliosSuficientes = estante.checkUtensilio(nombreUtensilio, vidaUtilRequerida);
                } catch (VidaUtilInsuficiente e) {
                    utensiliosSuficientes = false;
                    System.out.println(e.getMessage());
                    break;
                }
            }
        }

        return ingredientesSuficientes && utensiliosSuficientes;
    }

    public static void renovarUtensilios(Estante estante) {
        for (Queue<Utensilio> utensilios : estante.getUtensilios().values()) {
            for (Utensilio utensilio : utensilios) {
                if (utensilio.getVidaUtil() <= 0) {
                    utensilio.setVidaUtil(500);
                }
            }
        }
    }

    public static void renovarIngredientes(Despensa despensa) {
        for (Ingrediente ingrediente : despensa.getElemento().values()) {
            if (ingrediente.getCantidad() <= 0) {
                ingrediente.setCantidad(5000);
            }
        }
    }
}