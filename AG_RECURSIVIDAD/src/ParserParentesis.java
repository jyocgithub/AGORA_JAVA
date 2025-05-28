package parsearParentesisFormula;

public class ParserParentesis {


    public static void main(String[] args) {
        new ParserParentesis().inicio();
    }

    public void inicio(){
        String instruccion = "([][]())";
        boolean hayerror = analizar(instruccion);
        System.out.println(hayerror);
    }

    public  boolean analizar(String lista) {
        boolean errorenesteanalisis = false;
        boolean errorennuevoanalisis = false;
        char inicial='0';
        if (lista.length() < 2) {
            errorenesteanalisis = true;
        } else {
            if(lista.charAt(0)==contrario(lista.charAt(lista.length()-1))){
                lista = lista.substring(1,lista.length()-2);
            }


            inicial = lista.charAt(0);
            int posfinal = lista.lastIndexOf(inicial);
            if(posfinal==-1){
                errorenesteanalisis = true;
            }else{
                String trozo1 = lista.substring(0,posfinal-1 );
                String trozo2 = lista.substring(posfinal);
                boolean res1 = analizar(trozo1);
                boolean res2 = analizar(trozo2);
                errorennuevoanalisis = res1|| res2;
            }
        }
        return errorenesteanalisis || errorennuevoanalisis;
    }

    char contrario(char uno){
        char res='0';
        if (uno == ')') res = '(';
        if (uno == '(') res = ')';
        if (uno == '[') res = ']';
        if (uno == ']') res = '[';
        return res;
    }

}


interface Count
{
    short counter = 0;
    void countUp();
}