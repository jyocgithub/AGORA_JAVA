package AUX_componentes_MacarenaCuenca;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author macarena
 * 
 * Este ejemplo est� picado en c�digo, no se usa la vista Design.
 *
 */

public class EjemploMenu extends JFrame {

    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem menuItem;
    private JTextArea areaTexto;
    private EjemploMenuControlador c;

    public EjemploMenu() {
        this.setTitle("Ejemplo Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        c = new EjemploMenuControlador(this);

        crearMenu();
        areaTexto = new JTextArea();

        this.setJMenuBar(barraMenu); //asignamos la barra de men�s a la ventana
        this.getContentPane().add(areaTexto, BorderLayout.CENTER);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);  //maximizamos la pantalla
        this.setVisible(true);
    }

    public JTextArea getAreaTexto() {
        return areaTexto;
    }

    private void crearMenu() {

        //creamos la barra de menus
        barraMenu = new JMenuBar();

        //creamos el menu Fichero
        menu = new JMenu("Fichero");
        menu.setMnemonic('F');
        barraMenu.add(menu); //añadimos el menu a a la barra

        //creamos las acciones del menu Fichero
        menuItem = new JMenuItem("Abrir", new ImageIcon(this.getClass().getResource("Imagenes/abrir.gif")));
        menuItem.setAccelerator(KeyStroke.getKeyStroke('A', java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItem.addActionListener(c);
        menu.add(menuItem); //añadimos el item al menu Fichero

        menuItem = new JMenuItem("Cerrar");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('C', java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItem.addActionListener(c);
        menu.add(menuItem);

        menuItem = new JMenuItem("Comprimir", new ImageIcon(this.getClass().getResource("Imagenes/comprimir.gif")));
        menuItem.setAccelerator(KeyStroke.getKeyStroke('Z', java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItem.addActionListener(c);
        menu.add(menuItem);
        menu.addSeparator();

        menuItem = new JMenuItem("Salir");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('S', java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItem.addActionListener(c);
        menu.add(menuItem);

        //creamos el menu Edicion
        menu = new JMenu("Edicion");
        menu.setMnemonic('E');
        barraMenu.add(menu);

        //creamos el menu Ayuda
        menu = new JMenu("Ayuda");
        menu.setMnemonic('A');
        barraMenu.add(menu);
    }

    public static void main(String[] args) {
        EjemploMenu ej = new EjemploMenu();
    }
}
