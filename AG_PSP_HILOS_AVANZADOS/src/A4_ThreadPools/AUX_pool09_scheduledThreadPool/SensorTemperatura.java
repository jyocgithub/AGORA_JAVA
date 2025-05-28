/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioc.dam.m9.uf2.eac1.b2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author nel
 */
class SensorTemperatura implements Runnable {
    private final int sensorId;
    private double ultimaTemperatura = 20.0; // Temperatura inicial
    private static final AtomicInteger alertesGenerades = new AtomicInteger(0); // Comptador compartit
    
    public SensorTemperatura(int sensorId) {
        this.sensorId = sensorId;
    }
    
    @Override
    public void run() {
        // Simulem una lectura de temperatura amb una variació aleatòria
        double variacio = Math.random() * 2 - 1; // Variació entre -1 i 1 grau
        ultimaTemperatura += variacio;
        System.out.printf("Sensor %d: Temperatura actual: %.2f°C%n", sensorId, ultimaTemperatura);

        // Generem una alerta si la temperatura supera els 25 graus
        if (ultimaTemperatura > 25.0) {
            System.out.printf("ALERTA! Sensor %d: Temperatura alta detectada: %.2f°C%n", 
                    sensorId, ultimaTemperatura);
            alertesGenerades.incrementAndGet(); // Incrementa el comptador de manera segura
        }
    }
    
    public static int getTotalAlertes() {
        return alertesGenerades.get();
    }
}