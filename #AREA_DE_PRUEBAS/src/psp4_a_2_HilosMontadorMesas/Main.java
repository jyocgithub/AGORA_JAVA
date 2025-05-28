package psp4_a_2_HilosMontadorMesas;

/*
 Se pretende sincronizar la fabricaci�n en una l�nea de ensamblado de mesas.
Hay 4 fabricantes de patas, que las depositan en un almacen con un l�mite de capacidad MAX_NUM_PATAS.
Cuando se llena, los fabricantes dejan de producir patas hasta que haya hueco libre.
Hay 2 fabricantes de tableros, que depositan en un almacen de capacidad limitada MAX_NUM_TABLEROS.

Por �ltimo, hay dos ensambladores de mesas: cada uno coge cuatro patas del almacen de patas y un tablero del almacen de tableros y ensambla una mesa.
No puede montar una mesa si no hay patas o tableros suficientes.
Se trata de escribir en Java un monitor que sincronice estos tres sistemas,
de forma que la producci�n se detenga cuando se alcanza la capacidad m�xima de almacenamiento (de patas o tableros independientemente)
 y sistema de ensamblaje no avance si le faltan piezas para hacer una nueva mesa
 cada fabricante de patas fabrica una pata cada TIEMPO_PATA milisegundos (x es una constante de la clase)
  cada fabrricante de tableros fabrica una pata cada TIEMPO_TABLERO milisegundos (x es una constante de la clase)
  cada montador de meses tarda TIEMPO_MESA milisegundos en montar una mesa (x es una constante de la clase)


 */
public class Main {

    public static void main(String[] args) {

        Almacen almacen = new Almacen();

        ProductorPatas productor1 = new ProductorPatas("pepe", almacen);
        ProductorPatas productor2 = new ProductorPatas("luis", almacen);
        ProductorPatas productor3 = new ProductorPatas("jose", almacen);
        ProductorPatas productor4 = new ProductorPatas("mario", almacen);

        ProductorTablas tablas1 = new ProductorTablas("TablasCarlos", almacen);
        ProductorTablas tablas2 = new ProductorTablas("TablasMariano", almacen);

        Ensamblador en1 = new Ensamblador("EnsamblesAntonio" , almacen);
        Ensamblador en2 = new Ensamblador("EnsamblesJuan" , almacen);

        productor4.start();
        productor2.start();
        productor3.start();
        productor1.start();

        tablas1.start();
        tablas2.start();

        en1.start();
        en2.start();
    }
}

