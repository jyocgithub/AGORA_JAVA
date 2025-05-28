package aaPruebasSencillas;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        String s;
        try {
            s = System.getProperty("user.name", "desconocido");
            System.out.print("Mirando la propiedad user.name, ");
            System.out.println("el nombre del usuario actual es: " + s);

            s = System.getProperty("os.name", "desconocido");
            System.out.print("Mirando la propiedad os.name, ");
            System.out.println("el nombre de tu Sistema Operativo es: " + s);

            s = System.getProperty("os.version", "desconocido");
            System.out.print("Mirando la propiedad os.version, ");
            System.out.println("la version de tu Sistema Operativo es: " + s);

            s = System.getProperty("java.version", "desconocido");
            System.out.print("Mirando la propiedad java.version, ");
            System.out.println("la version de JVM que estamos ejecutando es: " + s);

            s = System.getProperty("user.home", "desconocido");
            System.out.print("Mirando la propiedad user.home, ");
            System.out.println("el directorio home de tu usuario es: " + s);

            System.out.print("Mirando la propiedad java.home, ");
            s = System.getProperty("java.home", "desconocido");
            System.out.println("el directorio donde esta instalado el actual JRE: " + s);

        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
        }
    }
}
