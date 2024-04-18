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
        Chef chef3 = new Chef("Francis Mallmann", 0, despensa3, estante);


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
                new Elemento("Arroz", 5000),
                new Elemento("Agua", 5000),
                new Elemento("Leche", 1000),
                new Elemento("Azucar", 300),
                new Elemento("Canela", 25),
                new Elemento("Lechuga romana", 1),
                new Elemento("Pechuga de pollo", 1),
                new Elemento("Pan de molde", 2),
                new Elemento("Queso parmesano", 50),
                new Elemento("Salsa César", 50),
                new Elemento("Huevo", 1),
                new Elemento("Agua", 400),
                new Elemento("Caldo de verduras", 1),
                new Elemento("Zanahoria", 2),
                new Elemento("Apio", 2),
                new Elemento("Patata", 2),
                new Elemento("Cebolla", 1),
                new Elemento("Ajo", 2),
                new Elemento("Masa de hojaldre", 1),
                new Elemento("Manzanas", 4),
                new Elemento("Azúcar", 150),
                new Elemento("Canela", 10),
                new Elemento("Ternera", 3),
                new Elemento("Papa", 4)
        );

        List<Utensilio> utensilios = Arrays.asList(
                new Utensilio("Olla", 100),
                new Utensilio("Olla", 100),
                new Utensilio("Cuchara", 100),
                new Utensilio("Cuchara", 100),
                new Utensilio("Cuchara", 100),
                new Utensilio("Cuchara", 100),
                new Utensilio("Tabla de cortar", 100),
                new Utensilio("Cuchillo", 100),
                new Utensilio("Sartén", 100),
                new Utensilio("Sartén", 100),
                new Utensilio("Molde para tarta", 100),
                new Utensilio("Horno", 10),
                new Utensilio("Horno", 10),
                new Utensilio("Bandeja", 100),
                new Utensilio("Tenedor", 100),
                new Utensilio("Tenedor", 100),
                new Utensilio("Tenedor", 100),
                new Utensilio("Tenedor", 100),
                new Utensilio("Tenedor", 100)

        );


        for (Despensa despensa : despensas) {
            for (Elemento original : elementos) {
                Elemento copy = new Elemento(original.getNombre(), original.getCantidad());
                despensa.addIngrediente(copy);
            }
            for (Utensilio original : utensilios) {
                Utensilio copy = new Utensilio(original.getNombre(), original.getVidaUtil());
                estante.addUtensilio(copy);
            }
        }

        for (Elemento original : elementos) {
            Elemento copy = new Elemento(original.getNombre(), 0);
            despensa6.addIngrediente(copy);
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
        final AtomicInteger iteracion = new AtomicInteger(0);
        for (Chef chef : chefsDomingoAJueves) {
            for (int i = 0; i < 1; i++) {
                executorService1.submit(() -> {
                    Map.Entry<String, Integer> recetaAleatoria = recetasList.get(random.nextInt(recetasList.size()));
                    System.out.println(recetaAleatoria.getKey());
                    chef.prepararReceta(recetaAleatoria.getValue());
                    iteracion.incrementAndGet();
                });
            }
        }


        executorService1.shutdown();
        try {
            executorService1.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("\nIteraciones: %d\n", iteracion.get());

        final AtomicInteger iteracion2 = new AtomicInteger(0);
        System.out.printf("\n Viernes a Domingo y Feriados\n-----------------------------\n");
        for (Chef chef : chefsViernesADomingoYFeriados) {
            for (int i = 0; i < 3; i++) {
                executorService2.submit(() -> {
                    Map.Entry<String, Integer> recetaAleatoria = recetasList.get(random.nextInt(recetasList.size()));
                    System.out.println(recetaAleatoria.getKey());
                    chef.prepararReceta(recetaAleatoria.getValue());
                    iteracion2.incrementAndGet();
                });
            }
        }

        executorService2.shutdown();
        try {
            executorService2.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("\nIteraciones: %d\n", iteracion2.get());

        DespensaService.renovarIngredientes(despensa6);

        System.out.println("\nArroz con Leche:");
        chef6.prepararReceta(1);
    }
}