// ============================================================
// File:    LinkedListDemo.java
// Author:  Eric
// Course:  IS 247
// Purpose: Test driver that demonstrates all required linked
//          list operations using the Meat custom class:
//            1) Generic list with Meat objects
//            2) Circular structure maintained throughout
//            3) removeFromBack with empty-list exception
//            4) getAtIndex with bounds validation / exception
//            5) removeAtIndex with bounds validation / exception
//            6) print (all items, formatted with toString)
//            7) size (total node count)
//            8) clear
// ============================================================

import java.util.NoSuchElementException;

public class LinkedListDemo {

    // Helper: prints a section banner for readability
    private static void banner(String title) {
        System.out.println();
        System.out.println("=".repeat(60));
        System.out.println("  " + title);
        System.out.println("=".repeat(60));
    }

    public static void main(String[] args) {

        // -------------------------------------------------------
        // Setup – create the generic circular linked list
        // -------------------------------------------------------
        banner("CREATE LIST & INSERT ITEMS (insertAtBack)");

        mylist<Meat> meatList = new mylist<>("Butcher's Selection");

        meatList.insertAtBack(new Meat("Ribeye Steak",    2.5,  18.99));
        meatList.insertAtBack(new Meat("Chicken Breast",  3.0,   5.49));
        meatList.insertAtBack(new Meat("Pork Tenderloin", 1.8,   7.99));
        meatList.insertAtBack(new Meat("Lamb Chops",      2.0,  14.50));
        meatList.insertAtBack(new Meat("Ground Beef",     4.0,   6.25));

        System.out.println("  Items inserted successfully.");
        meatList.print();

        // -------------------------------------------------------
        // Req 7: size
        // -------------------------------------------------------
        banner("SIZE – Total Number of Nodes");
        System.out.println("  Total items in list: " + meatList.size());

        // -------------------------------------------------------
        // Req 3: removeFromBack (normal and empty-list exception)
        // -------------------------------------------------------
        banner("REMOVE FROM BACK");
        System.out.println("  List BEFORE remove from back:");
        meatList.print();

        Meat removed = meatList.removeFromBack();
        System.out.println("  Removed: " + removed.getName());
        System.out.println();
        System.out.println("  List AFTER remove from back:");
        meatList.print();

        // Test empty-list exception for removeFromBack
        System.out.println("  --- Testing empty-list exception ---");
        mylist<Meat> emptyList = new mylist<>("Empty List");
        try {
            emptyList.removeFromBack();
        } catch (NoSuchElementException e) {
            System.out.println("  Caught expected exception: " + e.getMessage());
        }

        // -------------------------------------------------------
        // Req 4: getAtIndex / display by index
        // -------------------------------------------------------
        banner("SEARCH & DISPLAY BY INDEX (getAtIndex)");

        int searchIndex = 2;
        System.out.println("  Searching for item at index " + searchIndex + ":");
        Meat found = meatList.getAtIndex(searchIndex);
        System.out.println("  Found -> " + found);

        // Test out-of-bounds exception
        System.out.println();
        System.out.println("  --- Testing out-of-bounds exception (index 99) ---");
        try {
            meatList.getAtIndex(99);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  Caught expected exception: " + e.getMessage());
        }

        // -------------------------------------------------------
        // Req 5: removeAtIndex
        // -------------------------------------------------------
        banner("REMOVE AT INDEX (removeAtIndex)");

        int removeIndex = 1;
        System.out.println("  List BEFORE removing index " + removeIndex + ":");
        meatList.print();

        Meat removedByIndex = meatList.removeAtIndex(removeIndex);
        System.out.println("  Removed at index " + removeIndex + ": " + removedByIndex.getName());
        System.out.println();
        System.out.println("  List AFTER removing index " + removeIndex + ":");
        meatList.print();

        // Test out-of-bounds exception
        System.out.println("  --- Testing out-of-bounds exception (index -1) ---");
        try {
            meatList.removeAtIndex(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  Caught expected exception: " + e.getMessage());
        }

        // -------------------------------------------------------
        // Req 6: print (via Meat.toString)
        // -------------------------------------------------------
        banner("PRINT ALL ITEMS (print / toString)");
        meatList.print();

        // -------------------------------------------------------
        // Demonstrate removeFromFront (provided method)
        // -------------------------------------------------------
        banner("REMOVE FROM FRONT (removeFromFront)");
        System.out.println("  List BEFORE remove from front:");
        meatList.print();

        Meat removedFront = meatList.removeFromFront();
        System.out.println("  Removed: " + removedFront.getName());
        System.out.println();
        System.out.println("  List AFTER remove from front:");
        meatList.print();

        // -------------------------------------------------------
        // Req 7: size again after removals
        // -------------------------------------------------------
        banner("SIZE AFTER REMOVALS");
        System.out.println("  Total items remaining: " + meatList.size());

        // -------------------------------------------------------
        // Req 8: clear
        // -------------------------------------------------------
        banner("CLEAR THE LIST (clear)");
        System.out.println("  List BEFORE clear:");
        meatList.print();

        meatList.clear();
        System.out.println("  List cleared.");
        System.out.println();
        System.out.println("  List AFTER clear:");
        meatList.print();
        System.out.println("  isEmpty() returns: " + meatList.isEmpty());

        // -------------------------------------------------------
        // Final removeFromFront exception on now-empty list
        // -------------------------------------------------------
        banner("REMOVE FROM FRONT ON EMPTY LIST (exception test)");
        try {
            meatList.removeFromFront();
        } catch (NoSuchElementException e) {
            System.out.println("  Caught expected exception: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=".repeat(60));
        System.out.println("  All operations demonstrated successfully.");
        System.out.println("=".repeat(60));
    }
}
