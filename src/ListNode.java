// ============================================================
// File:    ListNode.java
// Author:  Eric
// Course:  IS 247
// Purpose: Generic node class for a circular linked list.
//          Each node holds a data item and a reference to
//          the next node in the list.
// ============================================================

public class ListNode<T> {

    T data;                   // data stored in this node
    ListNode<T> nextNode;     // reference to the next node

    // Constructor: creates a ListNode that refers to object only
    ListNode(T object) {
        this(object, null);
    }

    // Constructor: creates a ListNode with data and a next pointer
    ListNode(T object, ListNode<T> node) {
        data    = object;
        nextNode = node;
    }

    // Returns the data stored in this node
    T getData() {
        return data;
    }

    // Returns a reference to the next node
    ListNode<T> getNext() {
        return nextNode;
    }
}
