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


        // Insert items and show initial list

        list.insertAtBack(m1);
        list.insertAtBack(m2);
        list.insertAtBack(m3);

        System.out.println("--- Initial List ---");
        list.print();


        // Remove from back (Req 3)

        System.out.println("--- Remove From Back ---");
        System.out.println("Before:");
        list.print();
        list.removeFromBack();
        System.out.println("After:");
        list.print();


        // Search / display by index

        System.out.println("--- Search By Index (valid: index 1) ---");
        try {
            System.out.println("Found: " + list.getAtIndex(1));
            System.out.println();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("--- Search By Index (invalid: index 99) ---");
        try {
            System.out.println("Found: " + list.getAtIndex(99));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
            System.out.println();
        }


        // Remove at index (Req 5)

        System.out.println("--- Remove At Index (valid: index 0) ---");
        System.out.println("Before:");
        list.print();
        list.removeAtIndex(0);
        System.out.println("After:");
        list.print();

        System.out.println("--- Remove At Index (invalid: index -1) ---");
        try {
            list.removeAtIndex(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
            System.out.println();
        }


        // Remove from front (provided method)

        System.out.println("--- Remove From Front ---");
        System.out.println("Before:");
        list.print();
        list.removeFromFront();
        System.out.println("After:");
        list.print();


        // Clear

        System.out.println("--- Clear List ---");
        list.insertAtBack(new Meat("Lamb", 3.0, 8.99));   // re-add an item to show clear working
        System.out.println("Before:");
        list.print();
        list.clear();
        System.out.println("After clear:");
        list.print();


        // Empty-list exception tests

        System.out.println("--- Exception Tests on Empty List ---");

        try {
            list.removeFromBack();
        } catch (Exception e) {
            System.out.println("removeFromBack on empty list: " + e.getMessage());
        }

        try {
            list.removeFromFront();
        } catch (Exception e) {
            System.out.println("removeFromFront on empty list: " + e.getMessage());
        }

        try {
            list.getAtIndex(0);
        } catch (Exception e) {
            System.out.println("getAtIndex on empty list: " + e.getMessage());
        }
    }
}