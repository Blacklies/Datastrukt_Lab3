import Lab3Help.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents the shortest path between two bus stops in a bus network
 */
public class MyPath implements Path<String> {

    private LinkedList<String> currentPath = new LinkedList<>(); // holds information about the current path
    private int pathLength; // current path length
    private Network<String> network; //represents the bus network
    private Dijkstra<String> dijkstra = new Dijkstra<>(); // helper for computing best path

    /**
     * Constructs the bus network from a list of the stops and a list of the lines
     * @param stops bus stops
     * @param lines bus lines
     */
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
    }

    @Override
    public void computePath(String from, String to) {
        //check if the requested stops exist in our network
        if (network.getNode(from) == null || network.getNode(to) == null){
            System.out.println("Denna hållplats existerar inte i detta nätverk!");
            return;
        }
        // try to compute the shortest path with dijkstras algorithm
        try {
            pathLength = dijkstra.computeFromTo(network, from, to, currentPath);
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

