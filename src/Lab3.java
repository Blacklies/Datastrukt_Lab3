import Lab3Help.*;

import java.io.IOException;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) throws IOException, MalformedData {
        Lab3File f = new Lab3File();
        List<BStop> stops = f.readStops("stops-gbg.txt");
        List<BLineTable> lines = f.readLines("lines-gbg.txt");
        Path<String> p = new MyPath(stops, lines);

//        p.computePath("Chalmers","Angered");
//        System.out.println("Distance: " + p.getPathLength());
//        p.computePath("Chalmers","GuldHeden");
//        System.out.println("Distance: " + p.getPathLength());
    }
}
