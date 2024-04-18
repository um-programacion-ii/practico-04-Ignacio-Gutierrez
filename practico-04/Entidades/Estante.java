package Entidades;

import Excepciones.VidaUtilInsuficiente;

import java.util.HashMap;
import java.util.Map;

public class Estante {
    private static Estante instance;
    private Map<String, Utensilio> utensilios = new HashMap<>();

    private Estante() {
    }
    public static Estante getInstance() {
        if (instance == null) {
            instance = new Estante();
        }
        return instance;
    }


    public void addUtensilio(Utensilio nuevoUtensilio) {
        String nombre = nuevoUtensilio.getNombre().toString();
        utensilios.put(nombre, nuevoUtensilio);
    }

    public void getUtensilio(String nombre, int vidaUtil) throws VidaUtilInsuficiente {
        if (utensilios.containsKey(nombre)) {
            Utensilio utensilio = utensilios.get(nombre);
            if (utensilio.getVidaUtil() < vidaUtil) {
                throw new VidaUtilInsuficiente("No hay suficiente vida útil de " + nombre + " en la despensa.");
            }
            utensilio.utilizar(vidaUtil);
        } else {
            throw new VidaUtilInsuficiente("No es posible desgastar " + vidaUtil + " de " + nombre + ", no hay en la despensa.");
        }
    }

    public boolean checkUtensilio(String nombre, int vidaUtil) throws VidaUtilInsuficiente {
        if (utensilios.containsKey(nombre)) {
            Utensilio utensilio = utensilios.get(nombre);
            if (((Utensilio) utensilio).getVidaUtil() >= vidaUtil) {
                return true;
            } else {
                throw new VidaUtilInsuficiente("No hay suficiente vida útil de " + nombre + " en la despensa.");
            }
        } else {
            throw new VidaUtilInsuficiente("No es posible retirar " + nombre + ", no hay en la despensa.");
        }
    }

    public void mostrarUtensilios() {
        System.out.println("Utensilios en la despensa:");
        for (Map.Entry<String, Utensilio> entry : utensilios.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getVidaUtil());
        }
    }

    public Map<String, Utensilio> getUtensilios() {
        return utensilios;
    }

}
