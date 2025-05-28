package programas_sueltos;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
/**
/* SEMAFOROS Y MUTEX
 *  
 * Un objeto SEMAPHORE mantiene un contador interno de permisos a ofrecer, llamados permits
 * Cuando se ejecuta un metodo acquire de un semaforo, se intenta coger un permit si hay disponible.
 *   - Si lo hay, el objeto semaforo resta un permit y permite continuar la ejecucion del codigo 
 *   - Si no lo hay, quedar en espera hasta que alguien incremente el numero de permits por encima de 0
 * Cuando se ejecuta un metodo release de un semaforo, se incrementa en 1 el numero de permits, 
 * y asi permite que algun otro bloque de codigo en espera por un acquire bloqueante se libere y pueda continuar.
 * El semaforo puede tener muchos permits, generalmente añadidos por procesos productores, 
 * en espera de algujn consumidor que los vaya liberando 
 *  
 * Un objeto MUTEX es un semaforo que se ejecuta en un codigo critico, y que no vale mas que 0-1,
 * bloqueando el acceso mientras se ejecuta el codigo critico a todo el mundo. 
 * 
 * El ejemplo usa un productor que envia a una cola varios mensajes, 
 * y varios consumidores que los consumen en mofo FIFO, liberando la cola segun se va llenando.
 *
 */


public class Ejemplo_Semaforo_Mutex {
	
    static LinkedList<String> miBuffer = new LinkedList<String>();
    
    // inicializa los objetos semaforo, con 0 y 1 permits en respectivamente
    static Semaphore atSemaforo = new Semaphore(0);
    static Semaphore atMutex = new Semaphore(1);
    
    
    public static void main(String[] args) {
        new ClaseProductor().start();
        ClaseConsumidor miConsumidor1 = new ClaseConsumidor("AAAA");   
        miConsumidor1.start();
        new ClaseConsumidor("CCCC").start();
        new ClaseConsumidor("BBBB").start();
    }
    
       
   
    static class ClaseProductor extends Thread {
        public void run() {
            
            int counter = 1;
            try {
                while (true) {
                    String threadName = Thread.currentThread().getName() + counter++;
                    
                    atMutex.acquire();
                    miBuffer.add(threadName);
                    System.out.println("++> Productor crea un valor nuevo: " + threadName);
                    atMutex.release();
                    
                    // incrementa el semaforo.
                    // inicialmente estaba con permits=0, 
                    // por lo que nadie podia estar pasando mas alla de un miSemaforo.acquire                    
                    // ahora permits se incrementa en 1, con lo que sera > 0, 
                    // y cualquier proceso parado en miSemaforo.acquire puede continuar
                    atSemaforo.release();
                    Thread.sleep(500);
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
    

    static class ClaseConsumidor extends Thread {
        String nombreConsumidor;
        
        // Constructor de Consumidor
        public ClaseConsumidor(String name) {
            this.nombreConsumidor = name;
        }
        
        public void run() {
        	try {
        		// Hay un tiempo inicial de espera antes de comenzar a consumidor para que la cola 
        		// se llena algo antes de comenzar a consumirse.
        		this.sleep(2000);
        		
        		while (true) {
        			// Con atSemaforo.acquire() se mira si el numero de permits de atSemaforo es mayor que cero
        			// Si no lo es, queda en espera aqui que alguien incremente los permits
        			// Si hay permits, resta uno a los permits y continua la ejecucion
        			atSemaforo.acquire();

        			// **COMIENZO Codigo Critico
        			// Se bloquea con un MUTEX, 
        			// Ya que este semaforo solo valia 1 al empezar, aqui se queda en cero,  
        			// y nadie podra hacer un getLast ni removeLast hasta un atMUtex.release()

        			atMutex.acquire();
        			String result = miBuffer.getLast();
        			miBuffer.removeLast();

        			System.out.println(	"      --> "+nombreConsumidor + " consume el valor: " + result + 
        					". El tamaño de miBuffer es : " + miBuffer.size() + "\n");

        			// Ahora liberamos el MUTEX para que otros consumidores puedan ejecutar el codigo critico
        			atMutex.release();

        			// **FIN Codigo Critico

        			Thread.sleep(500);

        		}
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
    }
    
/*  EJEMPLO DE EJECUCION :
 
++> Productor crea un valor nuevo: Thread-01
++> Productor crea un valor nuevo: Thread-02
++> Productor crea un valor nuevo: Thread-03
++> Productor crea un valor nuevo: Thread-04
			--> AAAA consume el valor: Thread-04. El tamaño de miBuffer es : 3
++> Productor crea un valor nuevo: Thread-05
			--> CCCC consume el valor: Thread-05. El tamaño de miBuffer es : 3
			--> BBBB consume el valor: Thread-03. El tamaño de miBuffer es : 2
			--> AAAA consume el valor: Thread-02. El tamaño de miBuffer es : 1
++> Productor crea un valor nuevo: Thread-06
			--> CCCC consume el valor: Thread-06. El tamaño de miBuffer es : 1
			--> BBBB consume el valor: Thread-01. El tamaño de miBuffer es : 0
++> Productor crea un valor nuevo: Thread-07
			--> AAAA consume el valor: Thread-07. El tamaño de miBuffer es : 0
++> Productor crea un valor nuevo: Thread-08
			--> AAAA consume el valor: Thread-08. El tamaño de miBuffer es : 0
++> Productor crea un valor nuevo: Thread-09
			--> CCCC consume el valor: Thread-09. El tamaño de miBuffer es : 0
++> Productor crea un valor nuevo: Thread-010
			--> BBBB consume el valor: Thread-010. El tamaño de miBuffer es : 0

*/
    
    
}