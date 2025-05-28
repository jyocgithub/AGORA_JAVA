package graficobarras;
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

      ArrayList<Ejercicio> lista = new ArrayList<>();
      lista.add(new Ejercicio("21-3-25", 340));
      lista.add(new Ejercicio("20-3-25", 290));
      lista.add(new Ejercicio("19-3-25", 230));

      System.out.println(generarGraficoTexto(lista,1,30));

    }
  public static String generarGraficoTexto(
          ArrayList<Ejercicio> ejercicios,
          int largoMin,
          int largoMax
  ) {
    if (ejercicios.isEmpty()) return "No hay datos.";
    if (largoMin > largoMax) return "Error: largoMin no puede ser mayor que largoMax.";

    double minPeso = Integer.MAX_VALUE;
    double maxPeso = Integer.MIN_VALUE;

    // Calcular pesos mínimo y máximo
    for (Ejercicio e : ejercicios) {
      double peso = e.getPeso();
      if (peso < minPeso) minPeso = peso;
      if (peso > maxPeso) maxPeso = peso;
    }

    StringBuilder resultado = new StringBuilder();

    for (Ejercicio e : ejercicios) {
      double peso = e.getPeso();
      String fecha = e.getFecha();

      // Calcular largo de barra proporcional
      int largoBarra;
      if (maxPeso == minPeso) {
        largoBarra = (largoMin + largoMax) / 2;
      } else {
        largoBarra = (int) ((peso - minPeso) * (largoMax - largoMin) / (double)(maxPeso - minPeso)) + largoMin;
      }

      // Construir la barra
      StringBuilder barra = new StringBuilder();
      for (int i = 0; i < largoBarra; i++) {
        barra.append("x");
      }

      resultado.append(String.format("%-10s %4fkg %s\n", fecha, peso, barra));
    }

    return resultado.toString();
  }



}


 class Ejercicio {
  private String fecha;
  private int peso;

  public Ejercicio(String fecha, int peso) {
    this.fecha = fecha;
    this.peso = peso;
  }

  public String getFecha() {
    return fecha;
  }

  public int getPeso() {
    return peso;
  }
}
