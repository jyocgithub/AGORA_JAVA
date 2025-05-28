package aed.recursion;

import es.upm.aedlib.Pair;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;


public class Explorador {

    public static Pair<Object, PositionList<Lugar>> explora(Lugar inicialLugar) {

        inicialLugar.printLaberinto();
        PositionList<Lugar> camino = new NodePositionList<>();

        camino.addLast(inicialLugar);
        Pair<Object, PositionList<Lugar>> resp = paso(inicialLugar, camino);
        return resp;

    }

    public static Pair<Object, PositionList<Lugar>> paso(Lugar lugaractual, PositionList<Lugar> camino) {


        if (lugaractual.tieneTesoro()) {
            Pair<Object, PositionList<Lugar>> pair = new Pair<Object, PositionList<Lugar>>(lugaractual.getTesoro(), camino);
            return pair;
        }
        lugaractual.marcaSueloConTiza();
        for (Lugar lugarpotencial : lugaractual.caminos()) {
            if (!lugarpotencial.sueloMarcadoConTiza()) {
                camino.addLast(lugarpotencial);
                Pair<Object, PositionList<Lugar>> resp = paso(lugarpotencial, camino);
                if (resp != null && resp.getLeft() != null) {
                    return resp;
                }
                camino.remove(camino.last());
            }
        }

        if (lugaractual.tieneTesoro()) {
            Pair<Object, PositionList<Lugar>> pair = new Pair<Object, PositionList<Lugar>>(lugaractual.getTesoro(), camino);
            return pair;
        } else {
            return null;
        }
    }
}
