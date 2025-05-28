/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioc.dam.m9.uf2.eac1.b2;

/**
 *
 * @author nel
 */
// Classe que monitoritza i imprimeix el nombre d'alertes generades cada 10 segons
class TascaEstadistiques implements Runnable {
    
    public TascaEstadistiques() {
    }
    
    @Override
    public void run() {
        System.out.println("Total d'alertes generades: " + SensorTemperatura.getTotalAlertes());
    }
}