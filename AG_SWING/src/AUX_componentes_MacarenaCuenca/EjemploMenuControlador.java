package AUX_componentes_MacarenaCuenca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploMenuControlador implements ActionListener {

    private EjemploMenu ventana;

    public EjemploMenuControlador(EjemploMenu ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String accion = arg0.getActionCommand();
        ventana.getAreaTexto().append(accion + "\n");
        if (accion.equals("Salir")) {
            System.exit(0);
        }
    }
}
