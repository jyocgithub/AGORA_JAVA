package JTableConImagenes;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class JTableConImagenes {

     public static void main (String[] args) throws IOException {

          Ventana frame = new Ventana();

          // The pack method sizes the frame so that all its contents are 
          // at or above their preferred sizes. 
          // An alternative to pack is to establish a frame size explicitly 
          // by calling setSize or setBounds (which also sets the frame location). 
          // In general, using pack is preferable to calling setSize, 
          // since pack leaves the frame layout manager in charge of the frame size, 
          // and layout managers are good at adjusting to platform 
          //  dependencies and other factors that affect component size.
          //frame.pack();

          frame.setVisible(true);
     }
}


class Ventana extends JFrame {

     public Ventana () {
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          ImageIcon aboutIcon = new ImageIcon("img1.png");
          ImageIcon addIcon = new ImageIcon("img2.png");
          ImageIcon copyIcon = new ImageIcon("img3.png");
          // -- Se puede usr setpreferredzie o pack()
          setSize(new Dimension(200, 200));
          // -- Centra el frame en la pantalla
          setLocationRelativeTo(null);



          // -- Para el modelo de datos que tenga la tabla, necesito crear un
          // -- array con los nombre de columnas y otro con los datos
          // -- Si no se ponen los nombres de columnas, no se muestran estas,
          // -- pero se puede meter los nombres vacios
          String[] columnNames = {"", "", "", "", ""};

          // -- El array de datos puede ser de Object, y asi meter cualquier cosa
          // -- uncluidas imagenes
          Object[][] data = new Object[2][5];
          data[0][0] = aboutIcon;
          data[0][1] = aboutIcon;
          data[0][2] = aboutIcon;
          data[0][3] = copyIcon;
          data[0][4] = copyIcon;
          data[1][0] = addIcon;
          data[1][1] = addIcon;
          data[1][2] = addIcon;
          data[1][3] = copyIcon;
          data[1][4] = copyIcon;


          // -- 1.- Para hacer la celdas no editables, lo hago con una clase propia 
          // -- que herede de DefaultTableModelo, o como en el codigo comentado despues,
          // -- crear una DefaultTableModel con una clase sobrescrita directamente 
          ModeloNoEditable model = new ModeloNoEditable(data, columnNames);
          //   DefaultTableModel model = new DefaultTableModel(data, columnNames) {
          //        @Override
          //        public boolean isCellEditable (int row, int column) {
          //             return false;
          //        }
          //   };
          // -- 2.- Si la JTable puede editarse, el modelo se crea sencillo asi: 
          // DefaultTableModel model2 = new DefaultTableModel(data, columnNames);

          // -- Para añadir un modelo a la JTable que permita imagenes, 
          // -- puedo crear una clase JTable propia, o como en el codigo comentado despues,
          // -- crear una JTable con una clase sobrescrita directamente
          MiTabla table = new MiTabla(model);
          //JTable table = new JTable( model )
          //{
          //  public Class getColumnClass(int column)
          //  {
          //      return getValueAt(0, column).getClass();
          //  }
          //};

          // -- Evita seleccionar una fila entera y asi se selecciona solo una celda
          table.setRowSelectionAllowed(false);
          // -- Definir el ancho de cada columna
          table.getColumnModel().getColumn(0).setMaxWidth(40);
          table.getColumnModel().getColumn(1).setMaxWidth(40);
          table.getColumnModel().getColumn(2).setMaxWidth(40);
          table.getColumnModel().getColumn(3).setMaxWidth(40);
          table.getColumnModel().getColumn(4).setMaxWidth(40);
          // -- Definir el alto de todas las filas iguales
          table.setRowHeight(40);
          // -- Damos tamaño a la tabla
          table.setPreferredScrollableViewportSize(new Dimension(100, 100));
          // -- Evitamos que las columnas se hagan resize y se adaptane al tamaño del contenedor 
          table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
          
          JScrollPane scrollPane = new JScrollPane(table);
          // -- Otra forma de crear un JScrollPane
          // -- Advertir que para añadir un objeto a un scrollpane no se usa add
          //JScrollPane scrollPane = new JScrollPane();

          // -- Estas lineas son para mostrar los scrollbars siempre
          scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
          scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          // -- Esta linea modela la tabla para que los scrolls se 
          // -- muestren solo si son necesarios
          // JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

          JPanel mipanel = new JPanel();
          mipanel.setPreferredSize(new Dimension(90, 90));
          mipanel.add(scrollPane);
          getContentPane().add(mipanel);
     }


}

/**
 * Clase que sustituye a JTable y que sobrescribe el metodo getColumnClass
 * Asi se facilita que el contenido de la JTable sean objetos, como imagenes
 *
 * @author inaki
 */
class MiTabla extends JTable {

     // -- El constructor recibe el modelo a aplicar y lo envia a la 
     // -- superclase (JTable) 
     // -- Asi es igual que se usa el constructor normal de JTable,
     // JTable tabla = new JTable(modelo);
     MiTabla (DefaultTableModel model) {
          super(model);
     }

     //  -- Metodo que para cada columna devuelve la "Clase" que contiene 
     //  -- Permite que se use por los "renderers" que se basen en tratar una clase
     public Class getColumnClass (int column) {
          return getValueAt(0, column).getClass();
     }
}

/**
 * Clase modelo propia, que evita que las celdas sean editables
 * 
 * @author inaki
 */
class ModeloNoEditable extends DefaultTableModel {
     ModeloNoEditable (Object[][] data, String[] columnNames) {
          super(data, columnNames);
     }
     @Override
     public boolean isCellEditable (int row, int column) {
          return false;
     }
}


