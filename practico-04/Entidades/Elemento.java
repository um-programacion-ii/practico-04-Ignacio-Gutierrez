package Entidades;

import Interfaces.Ingrediente;

public class Elemento implements Ingrediente {
    private String nombre;
    private int cantidad;

    public Elemento(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void despensar(int cantidadARetirar) {
        if (this.cantidad >= cantidadARetirar) {
            this.cantidad -= cantidadARetirar;
            System.out.println("Se retiró " + cantidadARetirar + " de " + nombre + ", quedan " + cantidad+ ".");
        } else {
            System.out.println("No es posible retirar " + cantidadARetirar + " de " + nombre + ", quedan " + cantidad + ".");
        }
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
