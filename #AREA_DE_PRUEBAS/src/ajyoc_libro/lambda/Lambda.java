package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


class prueba {

    public static void main(String[] args) {
        int[] x = {2, 3, 4, 5, 6};


    }


}


// UNA INTERFAZ NORMAL CON SOLO UN METODO
interface IMathOperation {

    public int operacion(int a, int b);
}

// MODO CLASICO DE INVOCAR UN METODO DE UNA INTERFAZ
class MathOperationImpl implements IMathOperation {

    public int operacion(int a, int b) {
        return a + b;
    }
}

class ProbarMathOperationImpl {

    public static void main(String args[]) {
        MathOperationImpl objetoMathImpl = new MathOperationImpl();
        System.out.println(objetoMathImpl.operacion(3, 12));
    }
}

class ProbarLambdaListenerTradicional {

    public static void main(String args[]) {
        JButton button = new JButton("Pusar aqui");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("ha pulsado el boton!");
            }

        });
    }
}

class ProbarLambdaListener {

    public static void main(String args[]) {

        JButton button = new JButton("Pusar aqui");
        // Implementacion de escuchador CON clase anonima
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("ha pulsado el boton!");
            }

        });

        // Como ActionListener es una interface que tiene solo un metodo, actionPerformed(), 
        // es una interface funcional, asi que des idonea para usar una expresion Lambda
        button.addActionListener(e -> System.out.println("ha pulsado el boton!"));

    }
}

class miActionListener implements ActionListener {

    public void actionPerformed(ActionEvent evt) {
        System.out.println("ha pulsado el boton!");
    }
}

class ProbarListenerSinAnonima {

    public static void main(String args[]) {
        JButton button = new JButton("Pusar aqui");

        // Implementacion de escuchador SIN clase anonima
        button.addActionListener(new miActionListener());
    }
}


class ProbarLambdaDirecto {

    public static void main(String args[]) {
        // Creamos un objeto de la interfaz, que desarrolla realmente el metodo de la interfaz
        IMathOperation sumar = (int a, int b) -> a + b;
        // Con ese objeto "interfaz-metodo", llamamos al metodo original con los atributos
        int s = sumar.operacion(2, 4);

        // Con polimorfismo se puede ver mejor la utilidad 
        // Creamos un objeto de la interfaz, que desarrolla realmente el metodo de la interfaz
        IMathOperation multiplicar = (int a, int b) -> a * b;
        IMathOperation restar = (int a, int b) -> a - b;

        int res1 = llamarAOperacion(3, 4, multiplicar);
        int res2 = llamarAOperacion(3, 4, restar);

        System.out.println(res1);
        System.out.println(res2);

    }

    public static int llamarAOperacion(int a, int b, IMathOperation objMath) {
        return objMath.operacion(a, b);
    }
}


// MODO CLASICO DE INVOCAR UN METODO DE UNA INTERFAZ
interface MathOperation {

    abstract public int operacion(int a, int b);

}


