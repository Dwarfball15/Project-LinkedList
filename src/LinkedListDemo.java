/*
 * Author: Duy Nguyen
 * Course: IS247
 * Assignment: Linked List Project (Circular Generic List)
 * Purpose: Implements a circular, generic linked list structure and demonstrates
 *          all required list operations using a custom data class.
 * Date: May 2026
 */



public class LinkedListDemo {

    public static void main(String[] args) {

        mylist<Meat> list = new mylist<>("Meat List");

        Meat m1 = new Meat("Beef", 10.0, 5.99);
        Meat m2 = new Meat("Chicken", 5.0, 3.49);
        Meat m3 = new Meat("Pork", 8.0, 4.29);

        list.insertAtBack(m1);
        list.insertAtBack(m2);
        list.insertAtBack(m3);

        System.out.println("\n--- Initial List ---");
        list.print();

        System.out.println("\n--- Remove From Back ---");
        System.out.println("Before:");
        list.print();
        list.removeFromBack();
        System.out.println("After:");
        list.print();

        System.out.println("\n--- Search By Index (1) ---");
        try {
            System.out.println("Found: " + list.getAtIndex(1));
        } catch (Exception e) {
            System.out.println("Invalid index.");
        }

        System.out.println("\n--- Remove At Index (0) ---");
        System.out.println("Before:");
        list.print();
        list.removeAtIndex(0);
        System.out.println("After:");
        list.print();

        System.out.println("\n--- Remove From Front ---");
        System.out.println("Before:");
        list.print();
        list.removeFromFront();
        System.out.println("After:");
        list.print();

        System.out.println("\n--- Clear List ---");
        list.clear();
        list.print();

        System.out.println("\n--- Exception Tests ---");
        try { list.removeFromBack(); }
        catch (Exception e) { System.out.println("removeFromBack on empty list."); }

        try { list.removeFromFront(); }
        catch (Exception e) { System.out.println("removeFromFront on empty list."); }
    }
}
