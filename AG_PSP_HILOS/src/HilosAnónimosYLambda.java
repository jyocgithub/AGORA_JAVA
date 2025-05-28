public class HilosAnónimosYLambda {


    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Método anónimo de clase interna");
                System.out.println("Este es el contenido del hilo");
                for (int i = 0; i < 100; i++) {
                    System.out.println("Voy por paso " + i);
                }
            }
        }).start();




    }


}
