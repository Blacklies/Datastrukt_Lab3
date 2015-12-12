import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;

public class Dijkstra<T> {

    public int computeFromTo(Network<T> n, T start, T end, Deque<T> resultingPath) throws NoPathException {
        PriorityQueue<DijkstraNode> frontier = new PriorityQueue<>((o1, o2) -> o1.cost.compareTo(o2.cost));
        HashSet<DijkstraNode> explored = new HashSet<>();
        DijkstraNode currentNode = new DijkstraNode(n.getNode(start), 0, null);
        frontier.suggest(currentNode);
        Network.Node<T> goal = n.getNode(end);

        while (frontier.size() > 0) {

            //pick the best available node
            currentNode = frontier.poll();

            //see if we have reached the goal
            if (currentNode.node.equals(goal)) {
                int totalLength = currentNode.cost;

                //write to the passed path queue
                while (currentNode != null) {
                    resultingPath.addFirst(currentNode.node.value);
                    currentNode = currentNode.previous;
                }
                return totalLength;
            }

            //if we didnt find the goal yet, add this node to explored
            explored.add(currentNode);

            //iterate through all the connected nodes
            Iterator<Pair<Network.Node<T>, Integer>> adjacentsItr = currentNode.node.getAdjacents();
            while (adjacentsItr.hasNext()) {
                Pair<Network.Node<T>, Integer> adjacentInfo = adjacentsItr.next();
                // create a new node based on our current position and cost
                DijkstraNode adjacentNode = new DijkstraNode(adjacentInfo.first, adjacentInfo.second + currentNode.cost, currentNode);
                // if we have not already explored this node, we add it to the frontier
                if (!explored.contains(adjacentNode)) {
                    frontier.suggest(adjacentNode);
                }
            }
        }
        throw new NoPathException("there is no path");
    }

    private class DijkstraNode {
        Network.Node<T> node;
        Integer cost;
        DijkstraNode previous;

        public DijkstraNode(Network.Node<T> node, Integer cost, DijkstraNode previous) {
            this.node = node;
            this.cost = cost;
            this.previous = previous;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DijkstraNode that = (DijkstraNode) o;

            return !(node != null ? !node.equals(that.node) : that.node != null);
        }

        @Override
        public int hashCode() {
            return node != null ? node.hashCode() : 0;
        }
    }
}

class NoPathException extends Exception {
    public NoPathException(String message) {
        super(message);
    }
}