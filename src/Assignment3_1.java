import java.util.*;

public class Assignment3_1 {
    /*
    The function take(n, lst) returns a list that takes n elements from lst.
     */
    public static <E> List<E> take(int n, List<E> lst)
    {
        return lst.subList(0, n);
    }

    /*
    The function drop(n, lst) returns a list that keeps all the elements of
    lst except for the first n elements.
    For example, drop(5,[1,2,3,4,5,6,7,8,9,10]) returns [6,7,8,9,10].
    */
    public static <E> List<E> drop(int n, List<E> lst)
    {
        return lst.subList(n, lst.size());
    }

    /*
    The function reverse(lst) returns a copy of the list lst with the elements reversed.
     */
    public static <E> List<E> reverse(List<E> lst)
    {
        List<E> temp = new ArrayList<>();
        for(int i = lst.size() - 1; i >= 0; i--)
            temp.add(lst.get(i));
        return temp;
    }

    /*
    The function sortedDown(lst) checks if lst is sorted in non-increasing order.
    For example, for lst = [3,3,2,1], it returns true.
     */
    public static <E extends Comparable<E>> boolean sortedDown(List<E> lst)
    {
        for(int i = 0; i < lst.size() - 1; i++)
        {
            if(lst.get(i).compareTo(lst.get(i + 1)) < 0)
                return false;
        }
        return true;
    }
}
