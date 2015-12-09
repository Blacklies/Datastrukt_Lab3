import Lab3Help.BLineTable;
import Lab3Help.BStop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Network<E> {
    private ArrayList<Node<E>> nodes;
    private HashMap<E, Node<E>> nodeMap;

    public Network(List<E> nodeValues) {
        nodes = new ArrayList<>(nodeValues.size());

        for (E value : nodeValues) {
            Node<E> node = new Node<>(value);
            nodes.add(node);
        }
    }

    public addConnection(E a, E b, int weight) {
        a.addAdjacent(b.weight));
        b.addAdjecent(a.weight);
    }

    public Iterator<Node<E>> getNodes() {
        return nodes.iterator();
    }


    public static class Node<E> {

        public Node(E value) {
            this.value = value;
        }

        public void addAdjacent(Node<E> node, Integer weight) {
            adjacents.add(new Pair<>(node, weight));
        }

        E value;
        ArrayList<Pair<Node<E>, Integer>> adjacents;
    }


}