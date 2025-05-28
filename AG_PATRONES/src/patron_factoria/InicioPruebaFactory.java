package patron_factoria;
/*
El patrón factoría consiste en construir una estructura (una clase Factoría)
que ofrezca métodos para crear objetos de otra clase X.
El objeto es “esconder” la clase X al público, a quien no le interesa ni cómo trabaja X ni cómo se implementa.
El patrón se ve mejor con una estructura de herencia,
y mejor aun con un ejemplo.

La factoría no dice que lo que devuelve es un Doberman, Caniche o Bulldog.
Simplemente devuelve algo que implemente la interfaz IPerro

En el main solo le decimos a la factoría qué queremos,
y la clase factoría decide qué subclase ha de crear y devolver al main.

No se sabe qué clase ha creado el perro que recibimos, ni siquiera como se llama.
Por supuesto, también podemos hacer que el método getter de la factoría reciba directamente el nombre del perro.

Aun y así, no se sabe qué clase o qué componente java está desarrollado para “construir” el perro solicitado,
pues el nombre no es mas que una “característica” que igualmente usa la factoría para elegir lo que devuelve

El criterio de selección en este caso es sencillo, pero puede ser muy complejo,
por ejemplo con más información de entrada al getter y más lógica de selección de objeto a devolver.
 */

public class InicioPruebaFactory {

  public static void main(String[] args) {

    // crear un perro para ancianos
    IPerro miPerro;
    miPerro= PerroFactory.getPerro("ancianos");
    miPerro.ladrar();

    // crear un perro para defensa
    miPerro = PerroFactory.getPerro("defensa");
    miPerro.ladrar();

    // crear un perro para niños
    miPerro = PerroFactory.getPerro("niños");
    miPerro.ladrar();
  }


}
