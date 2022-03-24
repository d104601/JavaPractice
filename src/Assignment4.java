import java.util.*;

public class Assignment4{
    public <T extends Comparable<T>> boolean isAscending(ListNode<T> a)
    {
        ListNode<T> curr = a;
        while(curr != null)
        {
            if(curr.data.compareTo(curr.next.data) > 0)
                return false;
            curr = curr.next;
        }
        return true;
    }

    public <T extends Comparable<T>> ListNode<T> merged(ListNode<T> a, ListNode<T> b)
    {
        if(a == null)
            return b;
        if(b == null)
            return a;
        if(a.data.compareTo(b.data) <= 0)
            return new ListNode<>(a.data, merged(a.next, b));
        else
            return new ListNode<>(b.data, merged(b.next, a));
    }

    public <T extends Comparable<T>> boolean cyclic(ListNode<T> a)
    {
        ListNode<T> temp1 = a;
        ListNode<T> temp2 = a;
        while(temp1 != null & temp1.next != null)
        {
            temp2 = temp2.next;
            temp1 = temp1.next.next;
            if(temp1 == temp2)
                return true;
        }
        return false;
    }

    public <T extends Comparable<T>> void removeDuplicated(ListNode<T> a)
    {
        ListNode<T> prev = a;
        ListNode<T> curr = a.next;
        while(curr != null)
        {
            if(curr.data.equals(prev.data))
                prev.next = curr.next;
            prev = curr;
            curr = curr.next;
        }
    }

    public <T extends Comparable<T>> boolean isPalindrome(ListNode<T> a)
    {
        Deque<T> deque = new LinkedList<T>();
        ListNode<T> curr = a;

        while(curr != null)
        {
            deque.add(a.data);
            curr = curr.next;
        }

        while(!deque.isEmpty())
        {
            if(deque.getFirst() != deque.getLast())
                return false;
            deque.removeFirst();
            deque.removeLast();
        }

        return true;
    }
}


