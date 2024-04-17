package Entidades;

import Interfaces.Ingrediente;
import Interfaces.Reutilizable;

public class Utensilio implements Ingrediente, Reutilizable {
    private String nombre;
    private int vidaUtil;

    public Utensilio(String nombre, int vidaUtil) {
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
    }


    public void utilizar(int vidaUtilNecesaria) {
        if (vidaUtil >= vidaUtilNecesaria) {
            vidaUtil -= vidaUtilNecesaria;
            System.out.println("El utensilio " + nombre + " ha sido utilizado. Vida útil restante: " + vidaUtil);
        } else {
            System.out.println("El utensilio " + nombre + " ha llegado al final de su vida útil.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCantidad() {
        return 0;
    }

    @Override
    public void setCantidad(int i) {

    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
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
