import Lab3Help.BLineTable;
import Lab3Help.BStop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Network<E> {
    private ArrayList<Node<E>> nodes;

    public Network(List<BStop> stops, List<BLineTable> lines) {
        nodes = new ArrayList(stops.size());
    }

    public Iterator<Node<E>> getNodes(){
        return nodes.iterator();
    }


    public static class Node<E>{
        E value;
        ArrayList<Pair<Node<E>,Integer>> adjacents;
    }

    
}