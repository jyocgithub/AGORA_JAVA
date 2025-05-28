import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DAODb4O {

    String nombrebbdd;
    ObjectContainer db;

    public DAODb4O(String nombrebbdd) {
        this.nombrebbdd = nombrebbdd;

        // db = Db4o.openFile(nombrebbdd);     //DEPRECATED
        this.db = Db4oEmbedded.openFile(nombrebbdd);
    }

    public void insertarManzana(Manzana m) {
        db.store(m);
    }

    public List<Manzana> leerTodasLasManzanas() {
        // VERSION 1 : -------------- SANDO QUERYS FORMA RESUMIDA
        List<Manzana> lista =  db.query(Manzana.class);
        return lista;

        // VERSION 2 : -------------- USANDO QUERYS FORMA NORMAL
        //        Query q = db.query();
        //        q.constrain(Manzana.class);
        //        ObjectSet<Object> resultado = q.execute();
        //        ArrayList lista = new ArrayList();
        //        while (resultado.hasNext()) {
        //            lista.add(resultado.next());
        //        }
        //        return lista;

        // VERSION 3 : -------------- USANDO QBE (query by example)
        //        Manzana mm = new Manzana(0, null, 0);
        //        ObjectSet<Object> resultado = db.queryByExample(mm);
        //
        //        ArrayList lista = new ArrayList();
        //        while (resultado.hasNext()) {
        //            lista.add(resultado.next());
        //        }
        //        return lista;
    }

    public Manzana leerUnaManzanaPorId(int idbuscado) {
        // VERSION 1 : -------------- USANDO QUERYS FORMA NORMAL
        Query query=db.query();
        query.constrain(Manzana.class);
        query.descend("id").constrain(idbuscado);
        ObjectSet resultado=query.execute();

        if (resultado.hasNext()) {
            Manzana res = (Manzana) resultado.next();
            return res;
        }
        return null;  // no se encontro la manzana

        // VERSION 2 : -------------- USANDO QBE (query by example)
        //        Manzana mm = new Manzana(id, null, 0);
        //        ObjectSet<Object> resultado = db.queryByExample(mm);
        //        if (resultado.hasNext()) {
        //            Manzana res = (Manzana) resultado.next();
        //            return res;
        //        }
        //        return null;  // no se encontro la manzana
    }

    public Manzana leerUnaManzanaPorPrecio(int preciobuscado) {
        // VERSION 1 : -------------- USANDO QUERYS FORMA NORMAL
        Query query=db.query();
        query.constrain(Manzana.class);
        query.descend("precio").constrain(preciobuscado);
        ObjectSet resultado=query.execute();

        if (resultado.hasNext()) {
            Manzana res = (Manzana) resultado.next();
            return res;
        }
        return null;  // no se encontro la manzana


        // VERSION 2 : -------------- USANDO QBE (query by example)
        //        Manzana mm = new Manzana(0, null, preciobuscado);
        //        ObjectSet<Object> resultado = db.queryByExample(mm);
        //        if (resultado.hasNext()) {
        //            Manzana res = (Manzana) resultado.next();
        //            return res;
        //        }
        //        return null;  // no se encontro la manzana
    }

    public ArrayList<Manzana> leerManzanasPorPrecioSuperiorAX(int preciominimo) {
        // SERIA UNA CONSULTA SQL DE TIPO 'SELECT * FROM MANZANA WHERE PRECIO > PRECIOMINIMO ORDER BY DESC'
        Query q = db.query();
        q.constrain(Manzana.class);
        q.descend("precio").constrain(new Integer(preciominimo)).greater();  // descend no indica orden, sino uso de un campo
        q.descend("nombre").orderAscending();
        ObjectSet<Object> resultado = q.execute();

        ArrayList al = new ArrayList();
        while (resultado.hasNext()) {
            al.add(resultado.next());
        }
        return al;
    }

    public boolean modificarNombreManzana(int idmanzanabuscada, String nuevonombre) {
        // VERSION 1 : -------------- USANDO QUERYS FORMA NORMAL
        Query query=db.query();
        query.constrain(Manzana.class);
        query.descend("id").constrain(idmanzanabuscada);
        ObjectSet resultado=query.execute();

        if (resultado.hasNext()) {
            Manzana manzanaelegida = (Manzana) resultado.next();
            manzanaelegida.setNombre(nuevonombre);
            db.store(manzanaelegida);
            return true; // devolvemos true pues se pudo modificar
        }
        return false; // devolvemos false pues no se pudo modificar


        // VERSION 2 : -------------- USANDO QBE (query by example)
        //        Manzana mm = new Manzana(idmanzanabuscada, null, 0);
        //        ObjectSet<Object> resultado = db.queryByExample(mm);
        //        if (resultado.hasNext()) {
        //            Manzana manzanaelegida = (Manzana) resultado.next();
        //            manzanaelegida.setNombre(nuevonombre);
        //            db.store(manzanaelegida);
        //            return true; // devolvemos true pues se pudo modificar
        //        }
        //        return false; // devolvemos false pues no se pudo modificar
    }

    public boolean borrarUnaManzana(int idmanzanabuscada) {
        // VERSION 1 : -------------- USANDO QUERYS FORMA NORMAL
        Query query=db.query();
        query.constrain(Manzana.class);
        query.descend("id").constrain(idmanzanabuscada);
        ObjectSet resultado=query.execute();
        if (resultado.hasNext()) {
            Manzana manzanaelegida = (Manzana) resultado.next();
            db.delete(manzanaelegida);
            return true; // devolvemos true pues se pudo modificar
        }
        return false; // devolvemos false pues no se pudo modificar


        // VERSION 2 : -------------- USANDO QBE (query by example)
        //        Manzana mm = new Manzana(idmanzanabuscada, null, 0);
        //        ObjectSet<Object> resultado = db.queryByExample(mm);
        //        if (resultado.hasNext()) {
        //            Manzana manzanaelegida = (Manzana) resultado.next();
        //            db.delete(manzanaelegida);
        //            return true; // devolvemos true pues se pudo modificar
        //        }
        //        return false; // devolvemos false pues no se pudo modificar
    }

    public void cerrar() {
        db.close();
    }


}
