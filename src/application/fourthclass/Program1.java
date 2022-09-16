package application.fourthclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = null;

        File file = new File("/Users/joaomarques/Desktop/InterfacesPractice/testNames.txt");

        sc = new Scanner(file);

        ArrayList <String> names = new ArrayList<String>();

        while (sc.hasNextLine()) {
            names.add(sc.nextLine());
        }

        Collections.sort(names);
        System.out.println(names);

    }

}



/*
public class Program {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); String path = "C:\\temp\\in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String name = br.readLine(); while (name != null) {
                list.add(name);
                name = br.readLine(); }
            Collections.sort(list); for (String s : list) {
                System.out.println(s); }
        } catch (IOException e) { System.out.println("Error: " + e.getMessage());
        } }
}*/
