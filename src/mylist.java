import java.util.NoSuchElementException;

public class mylist<T> {

    private ListNode<T> first;  // reference to the first node
    private ListNode<T> last;   // reference to the last node
    private String name;        // label used when printing

    // Constructor: creates an empty named list
    public mylist(String name) {
        this.name = name;
        first = last = null;
    }

    // Returns true when the list has no nodes
    public boolean isEmpty() {
        return first == null;
    }

    // Adds a new node at the end and maintains the circular link
    public void insertAtBack(T item) {
        ListNode<T> newNode = new ListNode<>(item);

        if (isEmpty()) {
            first = last = newNode;
            last.nextNode = first;          // circular: single node points to itself
        } else {
            last.nextNode = newNode;
            last = newNode;
            last.nextNode = first;          // re-link tail back to head
        }
    }

    // Removes and returns the first node
    // Throws NoSuchElementException if the list is empty
    public T removeFromFront() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty.");

        T removed = first.data;

        if (first == last) {
            first = last = null;            // list becomes empty
        } else {
            first = first.nextNode;
            last.nextNode = first;          // re-link tail to new head (circular)
        }

        return removed;
    }

    // Removes and returns the last node
    // Throws NoSuchElementException if the list is empty
    public T removeFromBack() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty.");

        T removed = last.data;

        if (first == last) {
            first = last = null;            // list becomes empty
            return removed;
        }

        // Walk to the node just before last
        ListNode<T> current = first;
        while (current.nextNode != last) {
            current = current.nextNode;
        }

        last = current;
        last.nextNode = first;              // new tail links back to head (circular)

        return removed;
    }

    // Returns the data at the given 0-based index without removing it
    // Throws IndexOutOfBoundsException if the index is out of range
    public T getAtIndex(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("List is empty.");

        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is out of bounds for list of size " + size());

        ListNode<T> current = first;
        for (int i = 0; i < index; i++)
            current = current.nextNode;

        return current.data;
    }

    // Removes the node at the given 0-based index
    // Throws IndexOutOfBoundsException if the index is out of range
    public void removeAtIndex(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("List is empty.");

        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is out of bounds for list of size " + size());

        if (index == 0) {
            removeFromFront();
            return;
        }

        ListNode<T> current = first;
        for (int i = 0; i < index - 1; i++)
            current = current.nextNode;

        if (current.nextNode == last)
            removeFromBack();
        else
            current.nextNode = current.nextNode.nextNode;
    }

    // Returns the number of nodes in the list
    public int size() {
        if (isEmpty()) return 0;

        int count = 1;
        ListNode<T> current = first;

        while (current.nextNode != first) {
            count++;
            current = current.nextNode;
        }

        return count;
    }

    // Resets the list to empty
    public void clear() {
        first = last = null;
    }

    // Prints
    public void print() {
        if (isEmpty()) {
            System.out.println(name + " is empty.");
            return;
        }

        System.out.println("---- " + name + " (" + size() + " items) ----");

        ListNode<T> current = first;
        int index = 0;

        do {
            System.out.println("  [" + index + "] " + current.data.toString());
            current = current.nextNode;
            index++;
        } while (current != first);            // circular

        System.out.println();
    }
}