import Lab3Help.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) throws IOException, MalformedData {
        Lab3File f = new Lab3File();
        List<BStop> stops = f.readStops("src/stops-air.txt");
        List<BLineTable> lines = f.readLines("src/lines-air.txt");
        Path<String> p = new MyPath(stops, lines);

        p.computePath("SFO", "LAX");
        System.out.println("Distance: " + p.getPathLength());
        Iterator<String> path = p.getPath();
        path.forEachRemaining(System.out::println);
        p.computePath("SFO", "MIA");
        System.out.println("Distance: " + p.getPathLength());
        path = p.getPath();
        path.forEachRemaining(System.out::println);

    }
}
