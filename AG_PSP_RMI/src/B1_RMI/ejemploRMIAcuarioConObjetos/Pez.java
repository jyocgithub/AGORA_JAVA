package B1_RMI.ejemploRMIAcuarioConObjetos;

import java.io.Serializable;


// Clase que viaja entre procesos
public class Pez implements Serializable {

    private String tipoPescado;

    // Para evitar posibles problemas de serializacion, es aconsejable que esta clase
    // tenga el mismo serialVersionUID en cliente y servidor
    private static final long serialVersionUID = 111122223333444455L;

    public Pez(String tipoPescado) {
        this.tipoPescado = tipoPescado;
    }

    public String getFamilia() {

        if (tipoPescado.equals("Caballa")) {
            return "Pelágico";
        } else if (tipoPescado.equals("Bacalao")) {
            return "Demersal";
        } else {
            return "Ni idea";
        }
    }
}
