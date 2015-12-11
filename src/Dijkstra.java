import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;

public class Dijkstra<T> {

    private void dijkstra(Network<T> n, T start) {
        n.getNode(start);
//        procedure UniformCostSearch(Graph, start, goal)
//        node ← start
//        cost ← 0
//        frontier ← priority queue containing node only
//        explored ← empty set
//        do
//            if frontier is empty
//        return failure
//        node ← frontier.pop()
//        if node is goal
//        return solution
//        explored.add(node)
//        for each of node's neighbors n
//        if n is not in explored
//        if n is not in frontier
//        frontier.add(n)
//        else if n is in frontier with higher cost
//        replace existing node with n
    }

    public int computeFromTo(Network<T> n, T start, T end, Deque<T> resultingPath) throws Exception {
        PriorityQueue<DijkstraNode<T>> frontier = new PriorityQueue<>((o1, o2) -> o1.cost.compareTo(o2.cost));
        HashSet<DijkstraNode<T>> explored = new HashSet<>();
        DijkstraNode<T> node = new DijkstraNode<T>(n.getNode(start), 0, null);
        frontier.suggest(node);
        Network.Node<T> goal = n.getNode(end);

        while (frontier.size() > 0) {
            //pick the best available node
            node = frontier.poll();
            //see if we have reached the goal
            if (node.node.equals(goal)) {
                int totalLength = node.cost;
                while (node.previous != null) {
                    resultingPath.addFirst(node.node.value);
                    node = node.previous;
                }
                return totalLength;
            }
            //iterate through all the connected nodes
            Iterator<Pair<Network.Node<T>, Integer>> adjacentsItr = node.node.getAdjacents();
            while (adjacentsItr.hasNext()) {
                Pair<Network.Node<T>, Integer> adjacentInfo = adjacentsItr.next();
                DijkstraNode<T> adjacentNode = new DijkstraNode<>(adjacentInfo.first, adjacentInfo.second + node.cost, node);
                if (!explored.contains(adjacentNode)) {
                    frontier.suggest(adjacentNode);
                }

            }
            explored.add(node);

        }
        throw new Exception("det har ballat ur som fan");

    }

    private class DijkstraNode<T> {
        Network.Node<T> node;
        Integer cost;
        DijkstraNode<T> previous;

        public DijkstraNode(Network.Node<T> node, Integer cost, DijkstraNode<T> previous) {
            this.node = node;
            this.cost = cost;
            this.previous = previous;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DijkstraNode<?> that = (DijkstraNode<?>) o;

            return !(node != null ? !node.equals(that.node) : that.node != null);
        }

        @Override
        public int hashCode() {
            return node != null ? node.hashCode() : 0;
        }
    }
}
