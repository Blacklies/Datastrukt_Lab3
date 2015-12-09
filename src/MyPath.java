import Lab3Help.BLineTable;
import Lab3Help.BStop;
import Lab3Help.Path;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyPath<E> implements Path<E> {

    public MyPath(List<BStop> stops, List<BLineTable> lines) {

    }

    private LinkedList<E> currentPath;
    private int pathLength;

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

