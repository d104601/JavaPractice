class ListNode<T extends Comparable<T>> {
    T data;
    ListNode<T> next;

    public ListNode(T data){
        this.data = data;
        next = null;
    }

    public ListNode(T data, ListNode<T> next){
        this.data = data;
        this.next = next;
    }
}