import java.util.ArrayList;

public class Assignment5 {
    public static <T> ArrayList<T> inorder(BTNode<T> a)
    {
        ArrayList<T> result = new ArrayList<>();
        inorder(a, result);
        return result;
    }

    static <T> void inorder(BTNode<T> root, ArrayList<T> list)
    {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static <T> boolean issymmetric(BTNode<T> a)
    {
        return recursion(a, a);
    }

    private static <T> boolean recursion(BTNode<T> a, BTNode<T> b)
    {
        if (a == null && b == null)
            return true;
        return a != null &&
                b != null &&
                a.data.equals(b.data) &&
                recursion(a.left, b.right) &&
                recursion(a.right, b.left);
    }

    public static int maxPathSum(BTNode<Integer> a)
    {
        return maxPathSum(a, 0);
    }

    private static int maxPathSum(BTNode<Integer> a, int b)
    {
        if (a == null)
        {
            return b;
        }
        b += a.data;
        int result = Math.max(maxPathSum(a.left, b), maxPathSum(a.right, b));
        return result;
    }

    public static <T extends Comparable> boolean isSearchTree(BTNode<T> a)
    {
        BTNode<T> temp = a;
        while (temp.left != null)
        {
            temp = temp.left;
        }
        T leftMost = temp.data;

        temp = a;
        while (temp.right != null)
        {
            temp = temp.right;
        }
        T rightMost = temp.data;


        return recursionTree(a, leftMost, rightMost);
    }

    private static <T extends Comparable> boolean recursionTree(BTNode<T> a, T left, T right)
    {
        if (a == null)
        {
            return true;
        }
        return left.compareTo(a.data) < 0 &&
                a.data.compareTo(right) <= 0 &&
                recursionTree(a.left, left, a.data) &&
                recursionTree(a.right, a.data, right);
    }

    public static <T extends Comparable<T>> boolean isinBST(BTNode<T> a, T value)
    {
        if (a == null)
            return false;
        if (value.equals(a.data))
            return true;
        else if (value.compareTo(a.data) < 0)
            return isinBST(a.left, value);
        else
            return isinBST(a.right, value);
    }

    public static <T extends Comparable> BTNode<T> insert(BTNode<T> a, T value)
    {
        if (a == null)
        {
            return new BTNode<T>(value);
        }
        if (value.compareTo(a.data) >= 0){
            a.right = insert(a.right, value);
        } else {
            a.left = insert(a.left, value);
        }
        return a;
    }

}


class BTNode<T> {
    public T data;
    public BTNode<T> left, right;

    public BTNode(T data){
        this.data = data;
        left = null;
        right = null;
    }

    public BTNode(T data, BTNode<T> left, BTNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
