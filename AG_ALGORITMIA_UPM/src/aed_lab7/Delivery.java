package aed_lab7;

import es.upm.aedlib.graph.DirectedGraph;
import es.upm.aedlib.graph.Vertex;
import es.upm.aedlib.positionlist.PositionList;

public class Delivery<V> {

  // Construct a graph out of a series of vertices and an adjacency matrix.
  // There are 'len' vertices. A negative number means no connection. A non-negative
  // number represents distance between nodes.
  public Delivery(V[] places, Integer[][] gmat) {
  }
  
  // Just return the graph that was constructed
  public DirectedGraph<V, Integer> getGraph() {
    DirectedGraph<V, Integer> v;


    return null;
  }

  // Return a Hamiltonian path for the stored graph, or null if there is none.
  // The list containts a series of vertices, with no repetitions (even if the path
  // can be expanded to a cycle).
  public PositionList <Vertex<V>> tour() {
    return null;
  }

  public int length(PositionList<Vertex<V>> path) {
    return 0;
  }

  public String toString() {
    return "Delivery";
  }
}
