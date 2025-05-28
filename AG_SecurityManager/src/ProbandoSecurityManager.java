
import java.lang.*;
import java.security.*;

/*
  SI no se aplica SecurityManager, la salida de este programa es ;
  About to get os.name property value
  The name of your operating system is: Mac OS X
About to get java.version property value
  The version of the JVM you are running is: 1.8.0_271
About to get user.home property value
  Your user home directory is: /Users/inaki
About to get java.home property value
  Your JRE installation directory is: /Library/Java/JavaVirtualMachines/jdk1.8.0_271.jdk/Contents/Home/jre

    SI APLICAMOS SecurityManager ( añadiendo -Djava.security.manager  en los parametros de ejecucion del proyecto)
    deberia dar una excepcion.........

 */







public class ProbandoSecurityManager {

    public static void main(String[] args) {
        System.out.println(args[0]);
        getProps();
    }


    public static void getProps() {
        /* Test reading properties w & w/out security manager */
        String s;

        try {
            System.out.println("About to get os.name property value");

            s = System.getProperty("os.name", "not specified");
            System.out.println("  The name of your operating system is: " + s);

            System.out.println("About to get java.version property value");

            s = System.getProperty("java.version", "not specified");
            System.out.println("  The version of the JVM you are running is: " + s);

            System.out.println("About to get user.home property value");

            s = System.getProperty("user.home", "not specified");
            System.out.println("  Your user home directory is: " + s);

            System.out.println("About to get java.home property value");

            s = System.getProperty("java.home", "not specified");
            System.out.println("  Your JRE installation directory is: " + s);

        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
        }
    }
}