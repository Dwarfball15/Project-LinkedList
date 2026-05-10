// ============================================================
// File:    mylist.java
// Author:  Eric
// Course:  IS 247
// Purpose: Generic, circular linked list. Supports insert at
//          back, remove from front, remove from back, remove
//          at index, search/display by index, print all,
//          size, isEmpty, and clear.  Throws appropriate
//          exceptions for invalid operations.
// ============================================================

import java.util.NoSuchElementException;

public class mylist<T> {

    public ListNode<T> first;   // reference to the first node
    public ListNode<T> last;    // reference to the last  node
    public String name;         // label used when printing

    // Default constructor
    public mylist() {
    }

    // Constructor: creates an empty named list
    public mylist(String listName) {
        name  = listName;
        first = last = null;
    }

    // ----------------------------------------------------------
    // isEmpty – returns true when the list has no nodes
    // ----------------------------------------------------------
    public boolean isEmpty() {
        return first == null;
    }

    // ----------------------------------------------------------
    // insertAtBack – adds a new node at the end of the list
    //               and maintains the circular link so that
    //               last.nextNode always points back to first.
    // ----------------------------------------------------------
    public void insertAtBack(T insertItem) {
        if (isEmpty()) {
            first = last = new ListNode<T>(insertItem);
            last.nextNode = first;          // circular: points to itself
        } else {
            ListNode<T> newNode = new ListNode<T>(insertItem, first);
            last.nextNode = newNode;        // old tail links to new node
            last = newNode;                 // advance tail pointer
        }
    }

    // ----------------------------------------------------------
    // removeFromFront – removes and returns the first node.
    //   Throws NoSuchElementException if the list is empty.
    // ----------------------------------------------------------
    public T removeFromFront() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from empty list: " + name);
        }

        T removedItem = first.data;

        if (first == last) {
            // Only one node – list becomes empty
            first = last = null;
        } else {
            first = first.nextNode;     // advance head
            last.nextNode = first;      // re-link tail to new head (circular)
        }
        return removedItem;
    }

    // ----------------------------------------------------------
    // removeFromBack – removes and returns the last node.
    //   Throws NoSuchElementException if the list is empty.
    // ----------------------------------------------------------
    public T removeFromBack() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from empty list: " + name);
        }

        T removedItem = last.data;

        if (first == last) {
            // Only one node – list becomes empty
            first = last = null;
        } else {
            // Walk to the node just before last
            ListNode<T> current = first;
            while (current.nextNode != last) {
                current = current.nextNode;
            }
            current.nextNode = first;   // new tail links back to head (circular)
            last = current;             // advance tail pointer
        }
        return removedItem;
    }

    // ----------------------------------------------------------
    // getAtIndex – returns (displays) the node data at the
    //   given 0-based index.
    //   Throws IndexOutOfBoundsException if index is invalid.
    // ----------------------------------------------------------
    public T getAtIndex(int index) throws IndexOutOfBoundsException {
        int listSize = size();
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException(
                "Index " + index + " is out of bounds for list of size " + listSize);
        }

        ListNode<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }
        return current.data;
    }

    // ----------------------------------------------------------
    // removeAtIndex – removes the node at the given 0-based
    //   index and returns its data.
    //   Throws IndexOutOfBoundsException if index is invalid.
    // ----------------------------------------------------------
    public T removeAtIndex(int index) throws IndexOutOfBoundsException {
        int listSize = size();
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException(
                "Index " + index + " is out of bounds for list of size " + listSize);
        }

        // Removing the head node
        if (index == 0) {
            return removeFromFront();
        }

        // Walk to the node just before the target
        ListNode<T> current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.nextNode;
        }

        ListNode<T> toRemove = current.nextNode;
        T removedItem        = toRemove.data;

        if (toRemove == last) {
            // Removing the tail node
            current.nextNode = first;   // re-link to head (circular)
            last = current;
        } else {
            current.nextNode = toRemove.nextNode;
        }

        return removedItem;
    }

    // ----------------------------------------------------------
    // size – returns the number of nodes in the list
    // ----------------------------------------------------------
    public int size() {
        if (isEmpty()) return 0;

        int count = 1;
        ListNode<T> current = first;
        while (current.nextNode != first) {   // stop when we've looped back
            count++;
            current = current.nextNode;
        }
        return count;
    }

    // ----------------------------------------------------------
    // print – prints every node using its toString(), along with
    //   a header and the total node count.
    // ----------------------------------------------------------
    public void print() {
        if (isEmpty()) {
            System.out.printf("  [%s] is empty.%n", name);
            return;
        }

        int listSize = size();
        System.out.printf("  ---- %s (%d item%s) ----%n",
                          name, listSize, listSize == 1 ? "" : "s");

        ListNode<T> current = first;
        int index = 0;
        do {
            System.out.printf("  [%d] %s%n", index, current.data.toString());
            current = current.nextNode;
            index++;
        } while (current != first);            // circular: stop at head

        System.out.println();
    }

    // ----------------------------------------------------------
    // clear – removes all nodes, resetting the list to empty
    // ----------------------------------------------------------
    public void clear() {
        first = last = null;
    }
}
