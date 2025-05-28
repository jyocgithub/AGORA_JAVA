package Alfombras;

/*
Crear una clase Alfombra, con atributos privados String color, int precioMetro.
• Crear clase AlfombraRedonda (hereda de Alfombra) con atributo int radio
• Crear clase AlfombraCuadrada (hereda de Alfombra) con atributo int lado
• Hace Constructores, getters y setters para todas las clases
Añade a la clase Alfombra los siguientes métodos abstractos
double calcularSuperficie() calcula la superficie de la alfombra
double calcularPrecio() que calcula el precio de la alfombra (que será la superficie*precioMetro)
• Hacer una interfaz IAlfombras con los métodos
double actualizarPrecio() que cambia el precio de una alfombra subiendo 10 euros
double ponerEnRebajas() que cambia el precio de una alfombra a la mitad. 
• Aplica la interfaz a las clases AlfombraCuadrada y a AlfombraRedonda, y escribir el contenido real de los métodos en donde corresponda.
Hacer un programa Main que cree objetos de las dos clases hijas y pruebe los métodos



MEJORA 1:
• Crear la clase Habitacion estos atributos
String nombre 
Alfombra[]  alfombras
• Hacer getters, setters y constructor (solo con el nombre, el array se crea siempre vacío al crear un objeto)
• Hacer un método en la clase Habitacion que sea  boolean agregarAlfombra(Alfombra alf) y que introduzca alfombras en la habitacion (el método puede añadir alfombras redondas o cuadradas)
• Hacer un método en la clase Habitacion que calcule el precio de todas las alfombras de la habitación. 
• Hacer un método en la clase Habitacion que calcule el precio de todas las alfombras cuadradas de la habitación. 
• En el programa Main,  crear una habitación, agregar varias alfombras y probar todos los métodos de las alfombras y de las habitaciones.


MEJORA 2:
• Tras la Mejora 1, crear la clase   Mansion,  que tiene un único atributo:
Habitacion[] arrayHabitaciones
• Hacer un método en la clase Mansion que sea  boolean agregarHabitacion(Habitacio hab) y que introduzca habitaciones en la mansión.
• Hacer un método en la clase mansión que calcule el precio de todas las alfombras de la mansión. 
• Hacer un método en la clase mansión que calcule el precio de todas las alfombras cuadradas de la mansión.
• Hacer un método en la clase mansión que ponga todas las alfombras en precio de rebajas.
• En el programa Main crear una mansión, agregar varias habitaciones, que contendrán varias alfombras, y probar todos los métodos de las alfombras, habitaciones y mansión.







 */
public class Principal {

	public static void main(String[] args) {

		Alfombra_Cuadrada alfombra1 = new Alfombra_Cuadrada(2, "Rojo", 3);
		Alfombra_Redonda alfombra2 = new Alfombra_Redonda(4, "Azul", 7);

		System.out.println(alfombra1.actualizarPrecio());

		System.out.println(alfombra1.calcularPrecio());
		System.out.println(alfombra2.calcularPrecio());

		Habitacion habitacion1 = new Habitacion("Salon");
		habitacion1.agregarAlfombra(alfombra2);
		habitacion1.agregarAlfombra(alfombra1);
		habitacion1.calcularpreciototal();

	}

}
