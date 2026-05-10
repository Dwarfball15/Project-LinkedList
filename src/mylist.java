import java.util.NoSuchElementException;

public class mylist<T> {

    private ListNode<T> first;
    private ListNode<T> last;
    private String name;

    public mylist(String name) {
        this.name = name;
        first = last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // Insert at back (maintains circular structure)
    public void insertAtBack(T item) {
        ListNode<T> newNode = new ListNode<>(item);

        if (isEmpty()) {
            first = last = newNode;
            last.nextNode = first;
        } else {
            last.nextNode = newNode;
            last = newNode;
            last.nextNode = first;
        }
    }

    // Remove from front
    public T removeFromFront() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty.");

        T removed = first.data;

        if (first == last) {
            first = last = null;
        } else {
            first = first.nextNode;
            last.nextNode = first;
        }

        return removed;
    }

    // Remove from back
    public T removeFromBack() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty.");

        T removed = last.data;

        if (first == last) {
            first = last = null;
            return removed;
        }

        ListNode<T> current = first;
        while (current.nextNode != last) {
            current = current.nextNode;
        }

        last = current;
        last.nextNode = first;

        return removed;
    }

    // Get item at index
    public T getAtIndex(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("List is empty.");

        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index.");

        ListNode<T> current = first;
        for (int i = 0; i < index; i++)
            current = current.nextNode;

        return current.data;
    }

    // Remove at index
    public void removeAtIndex(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("List is empty.");

        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index.");

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

    // Size of circular list
    public int size() {
        if (isEmpty())
            return 0;

        int count = 1;
        ListNode<T> current = first;

        while (current.nextNode != first) {
            count++;
            current = current.nextNode;
        }

        return count;
    }

    // Clear list
    public void clear() {
        first = last = null;
    }

    // Minimal print
    public void print() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        ListNode<T> current = first;
        int index = 0;

        do {
            System.out.println("[" + index + "] " + current.data);
            current = current.nextNode;
            index++;
        } while (current != first);

        System.out.println("Total items: " + size());
    }
}
