import Lab3Help.BLineTable;
import Lab3Help.BStop;
import Lab3Help.Path;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyPath implements Path<String > {

    private LinkedList<String> currentPath;
    private int pathLength;
    private Network<String> network;
    private Djikstra<String> djikstra;

    public MyPath(List<BStop> stops, List<BLineTable> lines) {
    ArrayList<String> hplatser = new ArrayList<>();
        for (BStop stop:stops) {
            hplatser.add(stop.getName());
        }

        network = new Network<>(hplatser);

    }

    @Override
    public void computePath(String from, String to) {
        djikstra.computeFromTo(network, from, to);

    }

    @Override
    public Iterator<String> getPath() {
        return currentPath.iterator();
    }

    @Override
    public int getPathLength() {
        return pathLength;
    }
}

