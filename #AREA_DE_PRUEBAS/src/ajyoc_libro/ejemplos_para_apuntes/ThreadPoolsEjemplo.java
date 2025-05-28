package ejemplos_para_apuntes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ThreadPoolsEjemplo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Crear un ThreadPool de solo 1 hilo de capacidad
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        // Crear un ThreadPool de 10 hilos de capacidad
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        // Crear un ThreadPool de 10 hilos de capacidad, con capacidad de planificarlos
        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

        // Usando EXECUTE()
        executorService2.execute(new HiloRunnable());

        // Usando SUBMIT( RUNNABLE )
        Future futureObj = executorService2.submit(new HiloRunnable());
        futureObj.get();  // devuelve null si la tarea ha terminado correctamente

        // Usando SUBMIT( CALLABLE )
        Future futureObj2 = executorService2.submit(new HiloCallable());
        System.out.println("Si, estuvo durmiendo " + futureObj2.get() + " milisegundos");

        // Usando INVOQUEANY ( CALLABLE_COLLECTION )
        Set<Callable<String>> callablesSet = new HashSet<Callable<String>>();
        callablesSet.add(new HiloCallable());
        callablesSet.add(new HiloCallable());
        callablesSet.add(new HiloCallable());
        String resultado = executorService2.invokeAny(callablesSet);
        System.out.println("Valor devuelto" + resultado);

        // Usando INVOQUEALL ( CALLABLE_COLLECTION )
        // usa la misma coleccion del ejemplo anterior
        List<Future<String>> listaFut = executorService2.invokeAll(callablesSet);
        for (Future<String> cadafuture : listaFut) {
            System.out.println("Valor devuelto " + cadafuture.get());
        }

        // Cerrando ExecutorServices
        executorService1.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();
    }


}

class HiloRunnable implements Runnable {
    public void run() {
        try {
            System.out.println("Este hilo estará de siesta un rato");
            Thread.sleep(2000); // hilo duerme durante 2 segundos
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("!Buena siesta me he tragado!");
    }
}

class HiloCallable implements Callable<String> {
    public String call() throws Exception {
        int tiempo = (int) (Math.random() * 5) * 1000;
        try {
            System.out.println("Este hilo estará de siesta un rato");
            Thread.sleep(tiempo); // hilo duerme durante 2 segundos
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("!Buena siesta me he tragado!.." + (tiempo / 1000) + " segundos");
        return tiempo + "";
    }
}