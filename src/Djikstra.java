import java.util.HashMap;
import java.util.PriorityQueue;

public class Djikstra {

    private PriorityQueue<Network.Node> pq;
    private HashMap<Network.Node, Integer> dist;
    private HashMap<Network.Node, Network.Node> prev;

    public void doDijkstra(Network n, Network.Node start) {

//        dist[source]←0                            // Initialization
//
//        create vertex set Q
//
//        for each vertex v in Graph:
//        if v≠source
//        dist[v]←INFINITY                          // Unknown distance from source to v
//        prev[v]←UNDEFINED                         // Predecessor of v
//
//        Q.add_with_priority(v, dist[v])
//
//
//        while Q is not empty:                              // The main loop
//        u←Q.extract_min()                            // Remove and return best vertex
//        for each neighbor v of u:
//        // only v that is still in Q
//        alt = dist[u] + length(u, v)
//        if alt<dist[v]
//        dist[v]←alt
//        prev[v]←u
//        Q.decrease_priority(v, alt)
//
//        return dist[],prev[]
    }
}
