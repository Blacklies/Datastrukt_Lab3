import Lab3Help.BLineStop;
import Lab3Help.BLineTable;
import Lab3Help.BStop;
import Lab3Help.Path;

import java.util.*;
import java.util.stream.Collectors;

public class MyPath implements Path<String> {

    private LinkedList<String> currentPath = new LinkedList<>();
    private int pathLength;
    private Network<String> network;
    private Dijkstra<String> djikstra = new Dijkstra<>();

    public MyPath(List<BStop> stops, List<BLineTable> lines) {
        //initialise network with the bus stops
        ArrayList<String> hplatser = stops.stream().map(BStop::getName).collect(Collectors.toCollection(ArrayList::new));
        network = new Network<>(hplatser);

        //add all the connections
        for (BLineTable line : lines){
            BLineStop[] lineStops = line.getStops();
            for (int i = 0; i < lineStops.length-1; i++) {
                network.addConnection(lineStops[i].getName(),lineStops[i+1].getName(),lineStops[i+1].getTime());
            }
        }
        //print for debug
        //network.printNetwork();
    }

    @Override
    public void computePath(String from, String to) {
        if (network.getNode(from) == null || network.getNode(to) == null){
            System.out.println("Denna hållplats existerar inte i detta nätverk!");
            return;
        }
        try {
            pathLength = djikstra.computeFromTo(network, from, to, currentPath);
        } catch (NoPathException e) {
            System.out.println("Det finns ingen väg mellan "+from+" till "+to+".");
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

