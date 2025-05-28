/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioc.dam.m9.uf2.eac1.b4;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author nel
 */
public class Principal {
    public static void main(String[] args) {
        // Defineix el límit superior per a la cerca de nombres primers
        int totalNumeros = 10000;
        // Crea un pool de threads per executar les tasques en paral·lel
        ForkJoinPool pool = new ForkJoinPool();
        
        // Registra el temps d'inici
        long inici = System.currentTimeMillis();
        
        // Executa la cerca de nombres primers utilitzant el framework Fork/Join
        // Comença des de 2 (primer nombre primer) fins a totalNumeros
        int nombrePrimers = pool.invoke(new CercaNúmerosPrimers(2, totalNumeros));
        
        // Registra el temps de finalització
        long fi = System.currentTimeMillis();

        // Mostra els resultats: nombre de primers trobats i temps d'execució
        System.out.println("Total nombres primers: " + nombrePrimers);
        System.out.println("Temps: " + (fi - inici) + " ms");
    }
}
