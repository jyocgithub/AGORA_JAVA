package aed.individual6;

import es.upm.aedlib.graph.DirectedGraph;
import es.upm.aedlib.graph.Edge;
import es.upm.aedlib.graph.Vertex;
import es.upm.aedlib.map.HashTableMap;
import es.upm.aedlib.map.Map;
import java.util.ArrayList;
import java.util.List;

public class Suma {
  static Map<Vertex<Integer>,Integer> mapa;
  public static <E> Map<Vertex<Integer>,Integer> sumVertices(DirectedGraph<Integer,E> g) {

      mapa =  new  HashTableMap<Vertex<Integer>,Integer>();

      for( Vertex<Integer> vertice  : g.vertices()  ){
          List<Vertex<Integer>>  visitados = new ArrayList<>();
          recorrer(g, vertice, vertice, visitados);
      }
    return mapa;
  }

  public static <E> void recorrer(DirectedGraph<Integer,E> g,  Vertex<Integer> verticeinicial, Vertex<Integer> vertice, List<Vertex<Integer>> visitados ){
      visitados.add(vertice);
      aumentar(verticeinicial, vertice);
      for( Edge<E> e  :  g.outgoingEdges(vertice)  ){
          Vertex<Integer> verticedestino =  g.endVertex(e);

          if(! visitados.contains(verticedestino)) {
              recorrer(g, verticeinicial, verticedestino, visitados);
          }
      }
  }

    public static void aumentar(Vertex<Integer> verticeinicial, Vertex<Integer> vertice){
        if(mapa.containsKey(verticeinicial)){
            int valor = mapa.get(verticeinicial);
            mapa.put(verticeinicial, valor+vertice.element());
        }else{
            mapa.put(verticeinicial, vertice.element());
        }
    }
}
