import Entidades.Chef;
import Entidades.Despensa;
import Entidades.Ingrediente;
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

        //chef's de Domingo a Jueves
        Despensa despensa1 = new Despensa();
        Chef chef1 = new Chef("Francis Mallmann", 0, despensa1);

        Despensa despensa2 = new Despensa();
        Chef chef2 = new Chef("Mauro Colagreco", 1, despensa2);

        Despensa despensa3 = new Despensa();
        Chef chef3 = new Chef("Francis Mallmann", 0, despensa3);


        //chef's Viernes, Sábados, Domingos y Feriados
        Despensa despensa4 = new Despensa();
        Chef chef4 = new Chef("Germán Martitegui", 0, despensa4);

        Despensa despensa5 = new Despensa();
        Chef chef5 = new Chef("Narda Lepes", 0, despensa5);

        Despensa despensa6 = new Despensa();
        Chef chef6 = new Chef("Donato De Santis", 0, despensa6);

        Despensa despensa7 = new Despensa();
        Chef chef7 = new Chef("Pablo Massey", 0, despensa7);

        Despensa despensa8 = new Despensa();
        Chef chef8 = new Chef("Christophe Krywonis", 0, despensa8);


        List<Despensa> despensas = Arrays.asList(despensa1, despensa2, despensa3, despensa4, despensa7, despensa8);


        List<Ingrediente> ingredientes = Arrays.asList(
                new Ingrediente("Arroz", 5000),
                new Ingrediente("Agua", 5000),
                new Ingrediente("Leche", 1000),
                new Ingrediente("Azucar", 300),
                new Ingrediente("Canela", 25),
                new Ingrediente("Lechuga romana", 1),
                new Ingrediente("Pechuga de pollo", 1),
                new Ingrediente("Pan de molde", 2),
                new Ingrediente("Queso parmesano", 50),
                new Ingrediente("Salsa César", 50),
                new Ingrediente("Huevo", 1),
                new Ingrediente("Agua", 400),
                new Ingrediente("Caldo de verduras", 1),
                new Ingrediente("Zanahoria", 2),
                new Ingrediente("Apio", 2),
                new Ingrediente("Patata", 2),
                new Ingrediente("Cebolla", 1),
                new Ingrediente("Ajo", 2),
                new Ingrediente("Masa de hojaldre", 1),
                new Ingrediente("Manzanas", 4),
                new Ingrediente("Azúcar", 150),
                new Ingrediente("Canela", 10),
                new Ingrediente("Ternera", 1),
                new Ingrediente("Papa", 4)
        );

        List<Utensilio> utensilios = Arrays.asList(
                new Utensilio("Olla", 2),
                new Utensilio("Cuchara", 4),
                new Utensilio("Tabla de cortar", 1),
                new Utensilio("Cuchillo", 4),
                new Utensilio("Sartén", 1),
                new Utensilio("Molde para tarta", 1),
                new Utensilio("Horno", 1),
                new Utensilio("Bandeja", 1),
                new Utensilio("Tenedor", 1)
        );


        for (Despensa despensa : despensas) {
            for (Ingrediente original : ingredientes) {
                Ingrediente copy = new Ingrediente(original.getNombre(), original.getCantidad());
                despensa.addElemento(copy);
            }
            for (Utensilio original : utensilios) {
                Utensilio copy = new Utensilio(original.getNombre(), original.getVidaUtil());
                despensa.addUtensilio(copy);
            }
        }

        for (Ingrediente original : ingredientes) {
            Ingrediente copy = new Ingrediente(original.getNombre(), 0);
            despensa6.addElemento(copy);
        }
        for (Utensilio original : utensilios) {
            Utensilio copy = new Utensilio(original.getNombre(), 0);
            despensa6.addUtensilio(copy);
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
            for (int i = 0; i < 3; i++) {
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

        DespensaService.renovarUtensilios(despensa6);
        DespensaService.renovarIngredientes(despensa6);

        System.out.println("\nArroz con Leche:");
        chef6.prepararReceta(1);
    }
}