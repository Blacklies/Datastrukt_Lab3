
import Lab3Help.Lab3File;

public class Test {

    public static void main(String[] args) {

        Lab3File fileHelp = new Lab3File();
        try {
            fileHelp.readLines("hejhej");
        }catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println("hej");
    }
}
