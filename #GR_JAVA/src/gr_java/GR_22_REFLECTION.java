package gr_java;

import java.lang.reflect.*;
import java.util.ArrayList;

public class GR_22_REFLECTION {


    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class classzepelin = Zepelin.class;
        System.out.println("---------------------------INFORMACION GENERAL -----------------------");
        System.out.println(classzepelin.getName());             // gr_java.Zepelin
        System.out.println(classzepelin.getSimpleName());       // Zepelin
        System.out.println(classzepelin.getCanonicalName());    // gr_java.Zepelin
        System.out.println(classzepelin.isArray());             // false
        System.out.println(classzepelin.isInterface());         // false
        System.out.println(classzepelin.isInstance("Trapos"));  // false
        Class cint = int.class;
        System.out.println(cint.isPrimitive());                 // true

        System.out.println("----------------------------- CLASES --------------");
        Class[] ca = Aeroplano.class.getClasses();
        for (Class c : ca)
            System.out.println(c.getName());                    // gr_java.Aeroplano$AeroplanoInterno


        System.out.println("----------------------------- FIELDS --------------");
        Field[] ff = classzepelin.getFields();
        for (Field c : ff)
            System.out.println(c.getName());                   // public volatile java.lang.String gr_java.Zepelin.modelo
                                                               // public java.util.ArrayList gr_java.Zepelin.extras
                                                                // public java.lang.String gr_java.Aeroplano.constructor

        System.out.println("----------------------------- DECLARED FIELDS --------------------");
        Field[] df = classzepelin.getDeclaredFields();
        for (Field c : df) {
            System.out.println("--> NOMBRE DEL ATRIBUTO: " + c.getName());  // --> NOMBRE   DEL ATRIBUTO: modelo
                                                                            // --> NOMBRE   DEL ATRIBUTO: nummotores
                                                                            // --> NOMBRE   DEL ATRIBUTO: extras
        }

        System.out.println("----------------------------- METHODS --------------------");
        Method[] mm = classzepelin.getMethods();
        for (Method c : mm) {
            System.out.println("NOMBRE DEL METODO: " + c.getName());
                                                                            // NOMBRE DEL METODO: setNummotores
                                                                            // NOMBRE DEL METODO: getNummotores
                                                                            // NOMBRE DEL METODO: setReferencia
                                                                            // NOMBRE DEL METODO: getReferencia
                                                                            // NOMBRE DEL METODO: wait
                                                                            // NOMBRE DEL METODO: wait
                                                                            // NOMBRE DEL METODO: wait
                                                                            // NOMBRE DEL METODO: equals
                                                                            // NOMBRE DEL METODO: toString
                                                                            // NOMBRE DEL METODO: hashCode
                                                                            // NOMBRE DEL METODO: getClass
                                                                            // NOMBRE DEL METODO: notify
                                                                            // NOMBRE DEL METODO: notifyAll
        }

        System.out.println("----------------------------- DECLARED METHODS --------------------");
        Method[] dm = classzepelin.getDeclaredMethods();
        for (Method c : dm)
            System.out.println("NOMBRE DEL METODO: " + c.toString());
                                                                            // NOMBRE DEL METODO: public final void gr_java.Zepelin.setNummotores(int) throws java.lang.IllegalArgumentException
                                                                            // NOMBRE DEL METODO: public int gr_java.Zepelin.getNummotores()
        System.out.println("----------------------------- CONSTRUCTORES---------------------");
        Constructor[] xxxx = classzepelin.getConstructors();
        for (Constructor c : xxxx)
            System.out.println(c.getName());                                // gr_java.Zepelin

        Field aaa = classzepelin.getDeclaredField("modelo");
        System.out.println("MODIFICADORES :" + aaa.getModifiers());         // MODIFICADORES :65
        System.out.println("MODIFICADORES :" + Modifier.toString(aaa.getModifiers()));         // MODIFICADORES :public volatile

        System.out.println("------------------------- INFO DE UN ATRIBUTO ------------------------");
        // devuelve un objeto de la clase Field que describe el atributo “modelo”
        Field a = classzepelin.getDeclaredField("modelo");
        System.out.println("NOMBRE LARGO DEL ATRIBUTO: " + a.getName());    // NOMBRE LARGO DEL ATRIBUTO: modelo
        System.out.println("NOMBRE LARGO DEL ATRIBUTO: " + a.toString());  // NOMBRE LARGO DEL ATRIBUTO: public volatile java.lang.String gr_java.Zepelin.modelo
        System.out.println("NOMBRE LARGO DEL ATRIBUTO: " + a.toGenericString());  // NOMBRE LARGO DEL ATRIBUTO: public volatile java.lang.String gr_java.Zepelin.modelo
        System.out.println("TIPO DEL ATRIBUTO        : " + a.getType());         // TIPO DEL ATRIBUTO        : class java.lang.String
        System.out.println("DIME SI ES UN ENUMERADO  : " + a.isEnumConstant());     // DIME SI ES UN ENUMERADO  : false
        System.out.println("MODIFICADORES :" + a.getModifiers());         // MODIFICADORES :65
        System.out.println("MODIFICADORES :" + Modifier.toString(a.getModifiers()));         // MODIFICADORES :public volatile
        Field of = classzepelin.getDeclaredField("extras");
        System.out.println("NOMBRE DE LA CLASE DONDE ESTA EL ATRIBUTO: " +of.getDeclaringClass());    // NOMBRE DE LA CLASE DONDE ESTA EL ATRIBUTO: class gr_java.Zepelin

        System.out.println("------------------------- INFO DE UN METODO ------------------------");
        // devuelve un objeto de la clase Field que describe el metodo “setNummotores”
        Method m = classzepelin.getDeclaredMethod("setNummotores", int.class);
        System.out.println("NOMBRE DEL METODO: " + m.getName());     // NOMBRE DEL METODO: setNummotores
        System.out.println("CLASE A LA QUE PERTENECE: " + m.getDeclaringClass()); // CLASE A LA QUE PERTENECE: class gr_java.Zepelin
        System.out.println("LISTA CON LAS EXCEPCIONES QUE LANZA: ");
        for (Class<?> qq : m.getExceptionTypes())
            System.out.println(qq.getName());                                // IllegalArgumentException

        System.out.println("CUANTOS PARAMETROS: " + m.getParameterCount()); // NOMBRE DEL METODO: setNummotores
        System.out.println("LISTA CON LOS TIPOS DE LOS PARAMETROS: " );
        for (Class<?> ww :  m.getParameterTypes())
            System.out.println(ww.getName());                                // int

        System.out.println("MODIFICADORES: " + m.getModifiers()); // MODIFICADORES: 17
        System.out.println("MODIFICADORES: " + Modifier.toString(m.getModifiers())); // MODIFICADORES: public final

        // ACTUANDO-------------------------------
        System.out.println("------------------------- CREAR UN OBJETO DINAMICAMENTE CON OBJETO CLASS -------");
        Class<?> stringBuilderClass = StringBuilder.class;
        StringBuilder b = (StringBuilder) stringBuilderClass.newInstance();
        b.append("Saludos desde Vulcano");
        System.out.println(b);  // Saludos desde Vulcano


        System.out.println("------------------------- CREAR UN OBJETO DINAMICAMENTE CON OBJETO CONSTRUCTOR ----");
        Class<?> thisClass = StringBuilder.class;
        Constructor<?>[] cons = thisClass.getConstructors();
        for (Constructor<?> constructor : cons) {
            if (constructor.toString().equals("public java.lang.StringBuilder(java.lang.String)")) {
                StringBuilder stringBuilder = (StringBuilder) constructor.newInstance("");
                stringBuilder.append("Bienvenidos desde Klingon !");
                System.out.println(stringBuilder);   // Bienvenidos desde Klingon !
            }
        }

        System.out.println("------------------------- MODIFICAR EL ATRIBUTO DE UN OBJETO  ------------------------");
        Aeroplano aeroplano = new Aeroplano("CASA", 12312);
        System.out.println(aeroplano.getReferencia() + " es de " + aeroplano.empresa); // 12312 es de CASA

        Class<?> aeroplanoclass = aeroplano.getClass();

        Field[] fields = aeroplanoclass.getDeclaredFields();
        for (Field f : fields) {
            if (f.getName().equals("constructor")) {
                f.setAccessible(true);
                f.set(aeroplano, "BOEING");
            }
        }
        System.out.println(aeroplano.getReferencia() + " es de " + aeroplano.empresa); // 12312 es de BOEING


        System.out.println("------------------------- MODIFICAR EL ATRIBUTO DE UN OBJETO  ------------------------");
        Aeroplano aeroplano_2 = new Aeroplano("CASA", 12312);
        System.out.println(aeroplano_2.getReferencia() + " es de " + aeroplano.empresa); // 12312 es de BOEING
        Class<?> aeroplanoclass_2 = aeroplano.getClass();

        Method[] methods = aeroplanoclass_2.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("setReferencia")) {
                method.setAccessible(true);
                int maxSize = 100;
                method.invoke(aeroplano_2, 55445);
            }
        }
        System.out.println(aeroplano_2.getReferencia() + " es de " + aeroplano.empresa); // 55445 es de BOEING

    }
}

class Aeroplano {
    public String empresa;
    private int referencia;

    public Aeroplano(String empresa, int referencia) {
        this.empresa = empresa;
        this.referencia = referencia;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public class AeroplanoInterno {
        public String[] componentesBase;
    }
}


class Zepelin extends Aeroplano {

    public volatile String modelo;
    private int nummotores;
    public ArrayList<String> extras;

    public Zepelin(String empresa, int referencia, String modelo, int nummotores) {
        super(empresa, referencia);
        this.modelo = modelo;
        this.nummotores = nummotores;
    }

    public int getNummotores() {
        return nummotores;
    }

    public final void setNummotores(int nummotores) throws IllegalArgumentException{
        this.nummotores = nummotores;
    }

}
