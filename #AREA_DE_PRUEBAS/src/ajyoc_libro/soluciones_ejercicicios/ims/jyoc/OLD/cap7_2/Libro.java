package soluciones_ejercicicios.ims.jyoc.OLD.cap7_2;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 7
 * 7.2.- (dif 1) Una biblioteca se dedica al préstamo de dos tipos de material: discos y libros.
 * Para los dos se guarda información general, como su código identificativo, el título y el autor.
 * En el caso de los libros, almacenamos también su número de páginas y un capítulo de muestra,
 * y para los discos el nombre de la discográfica . Todos los productos tienen atributos que indica si estan
 * prestados y fecha desde la que se prestaron.
 * Crear la clases Disco y Libro, y para ambas, los métodos constructores y demas necesarios para:
 * poder crear cualquier tipo de material
 * poder hacer un prestamo de un material
 * consultar los materiales que no estan prestados
 * <p>
 * MEJORA 1
 * añadir funcionalidad para:
 * consultar los productos que estan fuera de fecha de prestamo (maximo tiempo prestamo: 3 dias disco, 15 libros)
 * <p>
 * MEJORA 2
 * Crear atributo de tipo Persona (ver ej. cap 6) y añadirlo como dato de la reserva.
 * Crear metodo que enviar un mensaje personalizado al usuario que tiene prestamo fuera de fecha, donde se le informa del articulo,
 * fechas, etc y se le identifica al usuario por su nombre y dni.
 */

public class Libro {
    String nombre;
    int antiguedad;

}
