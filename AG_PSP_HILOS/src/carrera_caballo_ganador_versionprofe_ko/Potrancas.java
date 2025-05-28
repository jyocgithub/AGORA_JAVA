package carrera_caballo_ganador_syncro;


import java.util.*;


// version del profe de Mario, que no funciona......
public class Potrancas{
    public static void main(String[] args){
        Potrancas ap=new Potrancas();
    }

    public Potrancas(){
        System.out.print("Pick one (1.Horse1, 2.Horse2, 3.Horse3): ");
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        switch(st){
            case "1":
                HorseSelected.selectedname="Horse1";
                break;
            case "2":
                HorseSelected.selectedname="Horse2";
                break;
            case "3":
                HorseSelected.selectedname="Horse3";
                break;
            default:
                System.out.println("Pick a horse!");
                break;
        }
        System.out.println("");
        Horse horse1=new Horse("Horse1");
        Horse horse2=new Horse("Horse2");
        Horse horse3=new Horse("Horse3");
        Thread t=new Thread(horse1);
        Thread t2=new Thread(horse2);
        Thread t3=new Thread(horse3);
        t.start();
        t2.start();
        t3.start();
    }
}
class HorseSelected{
    static String selectedname="";
}

class Score{
    int position=0;
    static boolean winner=false;
}

class Horse implements Runnable{
    Score s=new Score();
    String horsename=null;
    Random rand=new Random();

    public Horse(String stemp){
        horsename=stemp;
    }

    public void run(){
        System.out.println(horsename+" is start running.");
        try{
            for(int i=0;i<5;i++){
                Thread.currentThread().sleep(rand.nextInt(10));
                s.position++;
                if(s.winner==false){
                    System.out.println("Position "+horsename+":"+s.position);
                }
                if((s.position==5)&&(s.winner==false)){
                    System.out.println(horsename+" wins!");
                    s.winner=true;
                    if((HorseSelected.selectedname).equals(horsename)){
                        System.out.println("Congratulation! You selected the right horse.");
                    }
                    else{
                        System.out.println("You selected the wrong horse!");
                    }
                    Thread.currentThread().interrupt();
                }
            }
        }catch(Exception e){

        }
    }
}
