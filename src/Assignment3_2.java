import java.io.*;
import java.util.*;

public class Assignment3_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader(args[0]));
        List<String> list = new ArrayList<>();

        while(inFile.hasNext())
        {
            list.add(inFile.next());
        }
        inFile.close();

        String temp;

        for(int i = 0; i < list.size(); i++)
        {
            for(int j = i + 1; j < list.size(); j++)
            {
                if(list.get(i).compareTo(list.get(j)) > 0)
                {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        for(String i : list)
            System.out.println(i);
    }
}
