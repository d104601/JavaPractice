import java.io.*;
import java.util.*;

public class Assignment3_3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader(args[0]));
        Stack<Character> stack = new Stack<>();

        String a;
        char temp;
        boolean flag = true;

        while(inFile.hasNext())
        {
            a = inFile.nextLine();
            for(int i = 0; i < a.length(); i++)
            {
                switch (a.charAt(i))
                {
                    case '(':
                        stack.push(a.charAt(i));
                        break;
                    case '{':
                        stack.push(a.charAt(i));
                        break;
                    case '[':
                        stack.push(a.charAt(i));
                        break;
                    case ')':
                        temp = stack.pop();
                        if(temp != '(')
                            flag = false;
                        break;
                    case '}':
                        temp = stack.pop();
                        if(temp != '{')
                            flag = false;
                        break;
                    case ']':
                        temp = stack.pop();
                        if(temp != '[')
                            flag = false;
                        break;
                    default:
                        break;
                }
                if(!flag)
                    break;
            }
            if(!flag)
                break;
        }

        inFile.close();

        if(flag)
            System.out.println("Source code file " + args[0] + " has correct pairs of grouping");
        else
            System.out.println("Source code file " + args[0] + " has not correct pairs of grouping");
    }

}
