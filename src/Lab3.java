/**
 * Created by OlofEkborg on 2015-12-09.
 */

import Lab3Help.BLineTable;
import Lab3Help.BStop;
import Lab3Help.Lab3File;
import Lab3Help.Path;

import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        Lab3File f = new Lab3File();
        List<BStop> stops = f.readStops("stops-gbg.txt");
        List<BLineTable> lines = f.readLines("lines-gbg.txt");
        Path<String> p = new MyPath(stops, lines);
        p.computePath("Chalmers","Angered");
        System.out.println("Distance: " + p.getPathLength());
        p.computePath("Chalmers","GuldHeden");
        System.out.println("Distance: " + p.getPathLength());
    }
}
