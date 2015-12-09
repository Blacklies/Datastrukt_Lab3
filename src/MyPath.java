import Lab3Help.BLineTable;
import Lab3Help.BStop;
import Lab3Help.Path;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyPath<E> implements Path<E> {

    private LinkedList<E> currentPath;
    private int pathLength;
    private Network network;
    private Djikstra<E> djikstra;

    public MyPath(List<BStop> stops, List<BLineTable> lines) {

        //magic
        lines.get(0).getStops()
        network = new Network((List<String>) stops);
    }

    @Override
    public void computePath(E from, E to) {
        djikstra.computeFromTo(network, from, to);

    }

    @Override
    public Iterator<E> getPath() {
        return currentPath.iterator();
    }

    @Override
    public int getPathLength() {
        return pathLength;
    }
}

