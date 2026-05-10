public class ListNode<T> {

    T data;
    ListNode<T> nextNode;

    // Constructor
    ListNode(T object) {
        this(object, null);
    }

    // Constructor
    ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    // Return
    T getData() {
        return data;
    }

    // Return
    ListNode<T> getNext() {
        return nextNode;
    }
}
