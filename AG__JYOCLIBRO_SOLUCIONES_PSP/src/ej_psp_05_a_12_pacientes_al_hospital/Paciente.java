package psp_ej_05_a_12_pacientes_al_hospital;

import java.util.concurrent.Semaphore;

public class Paciente extends Thread {
    private String paciente;
    private String[] consultas = {"medicina", "enfemeria", "pediatria"};
    private int milisegundosEnLaconsulta;
    private Semaphore[] lostressemaforos;

    public Paciente(String paciente, Semaphore[] lostressemaforos) {
        this.lostressemaforos = lostressemaforos;
        this.paciente = paciente;
    }

    public void run() {
        try {
            System.out.println("El paciente " + paciente + " esta llegando al centro y va a tardar un poco");

            int milisegundosPaseando = (int) (Math.random() * 5001);  // da un numero al azar entre 0 y 5000
            Thread.sleep(milisegundosPaseando);  // simulamos que esperamos paseando.... (realmente estamos dormidos)

            System.out.println("El paciente " + paciente + " entra en el centro y va a buscar una consulta");

            int azar = (int) (Math.random() * 3);  // esto da un numero entre 0 y 2, para que cada uno sea una consulta..
            String consultaelegida = consultas[azar];

            switch (consultaelegida) {
                case "medicina":

                    lostressemaforos[0].acquire(); // intgento coger llave, si puedo, sigo, sino, me espero que haya una llave libre

                    System.out.println("--> El paciente " + paciente + " entra en MEDICINA");

                    milisegundosEnLaconsulta = (int) (Math.random() * 10000 - 1000) + 1000;  // da un numero al azar entre 1000 y 10000

                    Thread.sleep(milisegundosEnLaconsulta);  // simulamos que esta dentro de la consulta.... (realmente estamos dormidos)

                    lostressemaforos[0].release();   // devuelvo la llave !!!!!!!!!

                    System.out.println("----------------> El paciente " + paciente + " se sale de MEDICINA" + " dejando " + lostressemaforos[0].availablePermits() + " permisos");


                case "enfermeria":

                    lostressemaforos[1].acquire(); // intgento coger llave, si puedo, sigo, sino, me espero que haya una llave libre

                    System.out.println("--> El paciente " + paciente + " entra en ENFERMERIA");

                    milisegundosEnLaconsulta = (int) (Math.random() * 10000 - 1000) + 1000;  // da un numero al azar entre 1000 y 10000

                    Thread.sleep(milisegundosEnLaconsulta);  // simulamos que esta dentro de la consulta.... (realmente estamos dormidos)

                    lostressemaforos[1].release();   // devuelvo la llave !!!!!!!!!

                    System.out.println("----------------> El paciente " + paciente + " se sale de ENFERMERIA" + " dejando " + lostressemaforos[1].availablePermits() + " permisos");

                    break;

                case "pediatria":
                    lostressemaforos[2].acquire(); // intgento coger llave, si puedo, sigo, sino, me espero que haya una llave libre

                    System.out.println("--> El paciente " + paciente + " entra en PEDIATRIA");

                    milisegundosEnLaconsulta = (int) (Math.random() * 10000 - 1000) + 1000;  // da un numero al azar entre 1000 y 10000

                    Thread.sleep(milisegundosEnLaconsulta);  // simulamos que esta dentro de la consulta.... (realmente estamos dormidos)

                    lostressemaforos[2].release();   // devuelvo la llave !!!!!!!!!

                    System.out.println("----------------> El paciente " + paciente + " se sale de PEDIATRIA" + " dejando " + lostressemaforos[2].availablePermits() + " permisos");

                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Semaphore semaforo_medicina = new Semaphore(2);
        Semaphore semaforo_enfermeria = new Semaphore(1);
        Semaphore semaforo_pediatria = new Semaphore(2);
        Semaphore[] lostressemaforos = {semaforo_medicina, semaforo_enfermeria, semaforo_pediatria};

        String[] pacientes = {"Miguel", "Laura", "Alberto", "Carla", "Jaime", "Juana", "Carlos", "Elena", "Juan", "Jimena"};
        for (int i = 0; i < pacientes.length; i++) {
            Paciente cs = new Paciente(pacientes[i], lostressemaforos);
            cs.start();
        }
    }

}

