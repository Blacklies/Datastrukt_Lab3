import Lab3Help.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Lab3 {

    public static void main(String[] args) throws IOException, MalformedData {

        if(args.length != 4){
            System.out.println("GÅR INTE DÖÖÖ");
            return;
        }
        Lab3File f = new Lab3File();
        List<BStop> stops = f.readStops(args[0]);
        List<BLineTable> lines = f.readLines(args[1]);
        Path<String> p = new MyPath(stops, lines);

        p.computePath(args[2], args[3]);
        System.out.println(p.getPathLength());
        Iterator<String> path = p.getPath();
        path.forEachRemaining(System.out::println);

    }
}
