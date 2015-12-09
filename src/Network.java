import Lab3Help.BLineTable;
import Lab3Help.BStop;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Network<E> {
    private ArrayList<Node<E>> nodes;


    public Network(List<E> nodeValues) {
        nodes = new ArrayList(nodeValues.size());
    }

    public Iterator<Node<E>> getNodes(){
        return nodes.iterator();
    }


    public static class Node<E>{
        E value;
        ArrayList<Pair<Node<E>,Integer>> adjacents;
    }

    
}