package LockCondition;


public class LockCondition {
    public static void main(String[] args) {
       BufferConditions bf = new BufferConditions(5);
        new HiloConsumidor(bf).start();
        new HiloProductor(bf).start();
    }
}


class HiloProductor extends Thread {
 BufferConditions bc;

    public HiloProductor(BufferConditions bc) {
        this.bc = bc;
    }

    public void run() {

        for (int i = 0; i <1000 ; i++) {
            try {
                sleep(20);
                bc.put(i);
                System.out.println("pongo "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class HiloConsumidor extends Thread {
    BufferConditions bc;

    public HiloConsumidor(BufferConditions bc) {
        this.bc = bc;
    }

    public void run() {

        for (int i = 0; i <1000 ; i++) {
            try {
                sleep(2000);
                System.out.println(bc.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
