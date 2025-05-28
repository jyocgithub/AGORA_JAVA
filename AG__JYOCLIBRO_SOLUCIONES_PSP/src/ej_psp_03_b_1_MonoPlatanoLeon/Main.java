package ej_psp_3_b_1_MonoPlatanoLeon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        int numCuidadores = 3;
        int numAnimales = 10;

        long tiempoInicial = System.currentTimeMillis();

        Jaula j = new Jaula(numAnimales);

        Thread[] cuidadores = new Thread[numCuidadores];

        for (int i = 0; i < cuidadores.length; i++)
        {
            cuidadores[i] = new Thread(new Cuidador(j, i+1));

            cuidadores[i].start();
        }

        for (int i = 0; i < cuidadores.length; i++)
        {
            try {
                cuidadores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        long tiempofinal = System.currentTimeMillis();
        long resta = tiempofinal - tiempoInicial;

        System.out.println("FIN, tardo " +( resta/1000)+ " segundos");
    }

}





class Jaula{

    private int numAnimales;
    private ArrayList<Integer> animales;
    public  Jaula(int numAnimales)
    {
        this.numAnimales = numAnimales;
        animales = new ArrayList<>();
    }

    public synchronized boolean meterEnJaula(int idCuidador, int idAnimal)
    {
        boolean resultado = true;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(animales.size() < numAnimales)
        {
            System.out.println("Cuidador " + idCuidador);
            switch (idAnimal)
            {
                case 0:// mono
                    System.out.println("Meto un mono");
                    if(!animales.contains(2)) //SI NO HAY LEONES
                    {

                        animales.add(idAnimal); //METES EL MONO

                        Iterator<Integer> it = animales.iterator();

                        while(it.hasNext())
                        {
                            int caduno= it.next();
                            if(caduno == 1)
                                it.remove(); //EL MONO SE COME LOS PLATANOS
                        }
                    }
                    break;
                case 1:
                    System.out.println("Meto un platano");
                    if (!animales.contains(0)) //SI NO HAY MONOS
                    {
                        animales.add(idAnimal);
                    }
                    break;
                case 2:
                    System.out.println("Meto un leon");
                    animales.add(idAnimal); //METES EL LEON

                    Iterator<Integer> it = animales.iterator();

                    while(it.hasNext())
                    {
                        int caduno= it.next();
                        if(caduno == 0)
                            it.remove(); //EL LEON SE COME LOS MONOS
                    }
                    break;
            }

            pintarJaula();
        }
        else resultado = false;

        return resultado;
    }

    public void pintarJaula()
    {
        int contMonos = 0, contLeones = 0, contPlatanos = 0;

        for (Integer id : animales)
        {
            if(id == 0)
                contMonos++;
            else if(id == 1)
                contPlatanos++;
            else contLeones++;
        }

        System.out.println("Estado de la jaula: ");
        System.out.println("Monos: " + contMonos + " Platanos: " + contPlatanos + " Leones: " + contLeones);
    }



}





class Cuidador implements Runnable{

    private Jaula j;
    private int idCuidador;

    public Cuidador(Jaula j, int idCuidador)
    {
        this.j = j;
        this.idCuidador = idCuidador;
    }

    @Override
    public void run()
    {
        while(j.meterEnJaula(idCuidador, new Random().nextInt(3)));

        System.out.println("El cuidador " + idCuidador + " acaba su trabajo");
    }
}