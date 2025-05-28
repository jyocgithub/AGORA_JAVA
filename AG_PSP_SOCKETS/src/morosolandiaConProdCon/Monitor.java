package morosolandiaConProdCon;

public class Monitor {

    int depositolingotes = 10;
    int capacidadMaximaDeposito = 200;

    public synchronized void meter (int cuantoMeten){
        while(depositolingotes+cuantoMeten>capacidadMaximaDeposito){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        depositolingotes += cuantoMeten;
        notifyAll();
    }
    public synchronized void sacar(int cuantoSacan){
        while(depositolingotes-cuantoSacan<0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        depositolingotes -= cuantoSacan;
        notifyAll();
    }

}
