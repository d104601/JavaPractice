import java.io.*;
import java.util.*;

public class Assignment3_3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader(args[0]));
        Stack<Character> stack = new Stack<>();

        String a;
        boolean flag = true;

        while(inFile.hasNext())
        {
            a = inFile.next();
            for(int i = 0; i < a.length(); i++)
            {
                if(a.charAt(i) == '(' || a.charAt(i) == '{' || a.charAt(i) == '[')
                    stack.push(a.charAt(i));

                switch (a.charAt(i))
                {
                    case ')':
                        if(stack.pop() != '(')
                        {
                            flag = false;
                            break;
                        }
                    case '}':
                        if(stack.pop() != '{')
                        {
                            flag = false;
                            break;
                        }
                    case ']':
                        if(stack.pop() != '[')
                        {
                            flag = false;
                            break;
                        }
                }
            }
        }

        inFile.close();

        if(flag)
            System.out.println("Source code file " + args[0] + " has correct pairs of grouping");
        else
            System.out.println("Source code file " + args[0] + " has not correct pairs of grouping");
    }

}
