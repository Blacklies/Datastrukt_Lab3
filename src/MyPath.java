import Lab3Help.BLineStop;
import Lab3Help.BLineTable;
import Lab3Help.BStop;
import Lab3Help.Path;

import java.util.*;
import java.util.stream.Collectors;

public class MyPath implements Path<String> {

    private Deque<String> currentPath;
    private int pathLength;
    private Network<String> network;
    private Dijkstra<String> djikstra;

    public MyPath(List<BStop> stops, List<BLineTable> lines) {
        ArrayList<String> hplatser = stops.stream().map(BStop::getName).collect(Collectors.toCollection(ArrayList::new));

        network = new Network<>(hplatser);

        for (BLineTable line : lines){
            BLineStop[] lineStops = line.getStops();
            for (int i = 0; i < lineStops.length-1; i++) {
                network.addConnection(lineStops[i].getName(),lineStops[i+1].getName(),lineStops[i+1].getTime());
            }
        }
        network.printNetwork();
    }

    @Override
    public void computePath(String from, String to) {
        try {
            djikstra.computeFromTo(network, from, to, currentPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

