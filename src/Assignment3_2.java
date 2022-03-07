import java.io.*;
import java.util.*;

public class Assignment3_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader(args[0]));
        List<String> temp = new ArrayList<>();

        while(inFile.hasNext())
        {
            temp.add(inFile.next());
        }
        inFile.close();

        Collections.sort(temp);

        for(String i : temp)
            System.out.println(i);
    }
}
