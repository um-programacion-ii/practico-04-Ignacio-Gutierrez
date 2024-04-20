import Entidades.Chef;
import Entidades.Despensa;
import Entidades.Estante;
import Entidades.Elemento;
import Entidades.Utensilio;
import Servicios.DespensaService;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);

        Estante estante = Estante.getInstance();

        //chef's de Domingo a Jueves
        Despensa despensa1 = new Despensa();
        Chef chef1 = new Chef("Francis Mallmann", 0, despensa1, estante);

        Despensa despensa2 = new Despensa();
        Chef chef2 = new Chef("Mauro Colagreco", 1, despensa2, estante);

        Despensa despensa3 = new Despensa();
        Chef chef3 = new Chef("Dolli Irigoyen", 0, despensa3, estante);


        //chef's Viernes, Sábados, Domingos y Feriados
        Despensa despensa4 = new Despensa();
        Chef chef4 = new Chef("Germán Martitegui", 0, despensa4, estante);

        Despensa despensa5 = new Despensa();
        Chef chef5 = new Chef("Narda Lepes", 0, despensa5, estante);

        Despensa despensa6 = new Despensa();
        Chef chef6 = new Chef("Donato De Santis", 0, despensa6, estante);

        Despensa despensa7 = new Despensa();
        Chef chef7 = new Chef("Pablo Massey", 0, despensa7, estante);

        Despensa despensa8 = new Despensa();
        Chef chef8 = new Chef("Christophe Krywonis", 0, despensa8, estante);


        List<Despensa> despensas = Arrays.asList(despensa1, despensa2, despensa3, despensa4, despensa7, despensa8);


        List<Elemento> elementos = Arrays.asList(
                new Elemento("Arroz", 50000),
                new Elemento("Agua", 50000),
                new Elemento("Leche", 10000),
                new Elemento("Azucar", 3000),
                new Elemento("Canela", 250),
                new Elemento("Lechuga romana", 10),
                new Elemento("Pechuga de pollo", 10),
                new Elemento("Pan de molde", 20),
                new Elemento("Queso parmesano", 500),
                new Elemento("Salsa César", 500),
                new Elemento("Huevo", 10),
                new Elemento("Agua", 4000),
                new Elemento("Caldo de verduras", 10),
                new Elemento("Zanahoria", 20),
                new Elemento("Apio", 20),
                new Elemento("Patata", 20),
                new Elemento("Cebolla", 10),
                new Elemento("Ajo", 20),
                new Elemento("Masa de hojaldre", 10),
                new Elemento("Manzanas", 40),
                new Elemento("Azúcar", 1500),
                new Elemento("Canela", 100),
                new Elemento("Ternera", 30),
                new Elemento("Papa", 40)
        );

        List<Utensilio> utensilios = Arrays.asList(
                new Utensilio("Olla", 100),
                new Utensilio("Olla", 100),
                new Utensilio("Cuchara", 100),
                //new Utensilio("Cuchara", 100),
                //new Utensilio("Cuchara", 100),
                //new Utensilio("Cuchara", 100),
                new Utensilio("Tabla de cortar", 100),
                new Utensilio("Cuchillo", 100),
                //new Utensilio("Sartén", 100),
                new Utensilio("Sartén", 100),
                new Utensilio("Molde para tarta", 100),
                new Utensilio("Horno", 10),
                //new Utensilio("Horno", 10),
                new Utensilio("Bandeja", 100),
                //new Utensilio("Tenedor", 100),
                //new Utensilio("Tenedor", 100),
                //new Utensilio("Tenedor", 100),
                //new Utensilio("Tenedor", 100),
                new Utensilio("Tenedor", 100)

        );


        for (Despensa despensa : despensas) {
            for (Elemento original : elementos) {
                Elemento copy = new Elemento(original.getNombre(), original.getCantidad());
                despensa.addIngrediente(copy);
            }
        }
        for (Utensilio utensilio : utensilios) {
            Utensilio copy = new Utensilio(utensilio.getNombre(), utensilio.getVidaUtil());
            estante.addUtensilio(copy);
        }

        Map<String, Integer> recetas = new HashMap<>();
        recetas.put("\nArroz con Leche:", 1);
        recetas.put("\nHuevo Duro:", 2);
        recetas.put("\nTernera al Horno:", 3);
        recetas.put("\nEnsalada Cesar:", 4);
        recetas.put("\nSopa de Verduras:", 5);
        recetas.put("\nTarta de Manzana:", 6);
        recetas.put("\nNada:", 7);


        List<Chef> chefsDomingoAJueves = Arrays.asList(chef1, chef2, chef3);

        List<Chef> chefsViernesADomingoYFeriados = Arrays.asList(chef4, chef5, chef6, chef7, chef8);

        List<Map.Entry<String, Integer>> recetasList = new ArrayList<>(recetas.entrySet());

        Random random = new Random();

        System.out.printf(" Domingo a Jueves\n-----------------------------\n");
        for (Chef chef : chefsDomingoAJueves) {
            for (int i = 0; i < 3; i++) {
                Map.Entry<String, Integer> recetaAleatoria = recetasList.get(random.nextInt(recetasList.size()));
                chef.agregarRecetaPendiente(recetaAleatoria.getValue());
            }

            executorService1.submit(() -> {
                chef.prepararReceta();
            });
        }

        executorService1.shutdown();
        try {
            executorService1.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("\n Viernes a Domingo y Feriados\n-----------------------------\n");


        for (Chef chef : chefsViernesADomingoYFeriados) {
            for (int i = 0; i < 3; i++) {
                Map.Entry<String, Integer> recetaAleatoria = recetasList.get(random.nextInt(recetasList.size()));
                chef.agregarRecetaPendiente(recetaAleatoria.getValue());
            }

            executorService2.submit(() -> {
                chef.prepararReceta();
            });

        }

        executorService2.shutdown();
        try {
            executorService2.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}