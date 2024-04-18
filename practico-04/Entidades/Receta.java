package Entidades;

public class Receta {
    protected int tiempoCoccion;
    protected Elemento[] elementos;
    protected Utensilio[] utensilios;
    protected String preparacion;

    public Receta(int tiempoCoccion, Elemento[] elementos, Utensilio[] utensilios, String preparacion) {
        this.tiempoCoccion = tiempoCoccion;
        this.elementos = elementos;
        this.utensilios = utensilios;
        this.preparacion = preparacion;
    }

    public void mostrarReceta() {
        System.out.println("Tiempo de cocción: " + tiempoCoccion + " minutos");
        System.out.println("Ingredientes:");
        for (Elemento elemento : elementos) {
            System.out.println(elemento.getNombre() + ": " + elemento.getCantidad());
        }
        System.out.println("Preparación: " + preparacion);
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public void setIngredientes(Elemento[] elementos) {
        this.elementos = elementos;
    }

    public void setUtensilios(Utensilio[] utensilios) {
        this.utensilios = utensilios;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public Elemento[] getIngredientes() {
        return this.elementos;
    }

    public Utensilio[] getUtensilios() {
        return this.utensilios;
    }
}
