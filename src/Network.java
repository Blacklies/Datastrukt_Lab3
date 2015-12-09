import java.util.ArrayList;

public class Network<E> {
    ArrayList<Node> nodes;

    public Network() {
        nodes = new ArrayList<Node>();
    }


    private class Node{
        String name;
        Pair<Node,Integer>[] adjacents;
    }
}

