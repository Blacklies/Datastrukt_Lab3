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

    public MyPath(List<BStop> stops, List<BLineTable> lines) {
        network = new Network(stops, lines);
    }

    @Override
    public void computePath(E from, E to) {

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

