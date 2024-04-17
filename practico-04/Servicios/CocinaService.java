package Servicios;

import Entidades.Despensa;
import Entidades.Ingrediente;
import Entidades.Receta;
import Entidades.Utensilio;
import Excepciones.StockInsuficiente;
import Excepciones.VidaUtilInsuficiente;
import Interfaces.Cocinable;
import Recetas.*;

import java.util.HashMap;
import java.util.Map;

public class CocinaService {
    private static volatile CocinaService instancia = null;
    private static final Object lock = new Object();

    private static final Map<Integer, Cocinable> recetas = new HashMap<>();

    static {
        recetas.put(1, new ArrozConLeche());
        recetas.put(2, new HuevoDuro());
        recetas.put(3, new TerneraAlHorno());
        recetas.put(4, new EnsaladaCesar());
        recetas.put(5, new SopaDeVerduras());
        recetas.put(6, new TartaDeManzana());
    }

    private CocinaService() {}

    public static CocinaService obtenerInstancia() {
        if (instancia == null) {
            synchronized (lock) {
                if (instancia == null) {
                    instancia = new CocinaService();
                }
            }
        }
        return instancia;
    }

    public static void comenzarACocinar(int numeroReceta, Despensa despensa) throws VidaUtilInsuficiente, StockInsuficiente {
        Receta receta = (Receta) recetas.get(numeroReceta);

        ((Cocinable) receta).cocinar();
        for (Ingrediente ingrediente : receta.getIngredientes()) {
            String nombreIngrediente = ingrediente.getNombre();
            int cantidadRequerida = ingrediente.getCantidad();
            despensa.getElemento(nombreIngrediente, cantidadRequerida);
        }
        for (Utensilio utensilio : receta.getUtensilios()) {
            String nombreUtensilio = utensilio.getNombre();
            int vidaUtilRequerida = utensilio.getVidaUtil();
            despensa.getUtensilio(nombreUtensilio, vidaUtilRequerida);
        }
    }
}