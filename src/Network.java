import java.util.*;

public class Network<E> {

    private ArrayList<Node<E>> nodes;
    private HashMap<E, Node<E>> nodeMap;

    public Network(List<E> nodeValues) {
        nodes = new ArrayList<>(nodeValues.size());
        nodeMap = new HashMap<>(nodeValues.size());

        for (E value : nodeValues) {
            Node<E> node = new Node<>(value);
            nodes.add(node);
            nodeMap.put(value, node);
        }
    }

    public void addConnection(E A, E B, int weight) {
        Node<E> nodeA = nodeMap.get(A);
        Node<E> nodeB = nodeMap.get(B); // Lägga till exception?

        nodeA.addAdjacent(nodeB, weight);
        //nodeB.addAdjacent(nodeA, weight);
    }

    public Node<E> getNode(E value) {
        return nodeMap.get(value);
    }

    public Iterator<Node<E>> getNodes() {
        return nodes.iterator();
    }

    public void printNetwork() {
        Iterator<Node<E>> nodesItr = getNodes();
        while (nodesItr.hasNext()) {
            Node<E> next = nodesItr.next();
            System.out.println(next.value.toString() + " has connections:");
            Iterator<Pair<Node<E>, Integer>> adjItr = next.getAdjacents();
            while (adjItr.hasNext()) {
                System.out.println(adjItr.next().toString());
            }
        }
    }

    public static class Node<E> {
        public final E value;
        private final int hash;
        private HashMap<Pair<Node<E>, Integer>,Pair<Node<E>,Integer>> adjacents;

        public Node(E value) {
            this.value = value;
            this.hash = value.hashCode();
            this.adjacents = new HashMap<>();
        }

        protected void addAdjacent(Node<E> node, Integer weight) {
            Pair<Node<E>,Integer> newNode = new Pair<>(node, weight);
            Pair<Node<E>,Integer> oldNode = adjacents.get(newNode);
            if (oldNode == null){
                adjacents.put(newNode,newNode);
            }else if(oldNode.second>newNode.second){
                adjacents.put(newNode,newNode);
            }
        }

        public Iterator<Pair<Node<E>, Integer>> getAdjacents() {
            return adjacents.values().iterator();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            return hashCode() == node.hashCode() && value == node.value;
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}

