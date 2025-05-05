package homework0;

public class Bookshelf2Test {

    public static boolean testBookshelfConstructor() {
        System.out.println("Running testBookshelfConstructor...");
        try {
            Bookshelf2 bookshelf = new Bookshelf2();
            if (bookshelf.size() != 0) {
                System.out.println("testBookshelfConstructor failed: Bookshelf should be empty after construction.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookshelfConstructor failed: Unexpected exception: " + e.getMessage());
            return false;
        }
        System.out.println("testBookshelfConstructor passed");
        return true;
    }

    public static boolean testAddBook() {
        System.out.println("Running testAddBook...");
        Bookshelf2 bookshelf = new Bookshelf2();
        Book book1 = new Book(100);
        Book book2 = new Book(200);

        // Test case 1: Add a book to an empty bookshelf
        if (!bookshelf.addBook(book1)) {
            System.out.println("testAddBook failed: Test Case 1: addBook should return true when adding to an empty bookshelf.");
            return false;
        }
        if (bookshelf.size() != 1) {
            System.out.println("testAddBook failed: Test Case 1: Bookshelf size should be 1 after adding one book.");
            return false;
        }
        if (!bookshelf.contains(book1)) {
            System.out.println("testAddBook failed: Test Case 1: Bookshelf should contain the added book.");
            return false;
        }

        // Test case 2: Add the same book again
        if (bookshelf.addBook(book1)) {
            System.out.println("testAddBook failed: Test Case 2: addBook should return false when adding the same book again.");
            return false;
        }
        if (bookshelf.size() != 1) {
            System.out.println("testAddBook failed: Test Case 2: Bookshelf size should remain 1 after adding the same book again.");
            return false;
        }

        // Test case 3: Add a different book
        if (!bookshelf.addBook(book2)) {
            System.out.println("testAddBook failed: Test Case 3: addBook should return true when adding a different book.");
            return false;
        }
        if (bookshelf.size() != 2) {
            System.out.println("testAddBook failed: Test Case 3: Bookshelf size should be 2 after adding two different books.");
            return false;
        }
        if (!bookshelf.contains(book2)) {
            System.out.println("testAddBook failed: Test Case 3: Bookshelf should contain the second added book.");
            return false;
        }

        System.out.println("testAddBook passed");
        return true;
    }

    public static boolean testRemoveBook() {
        System.out.println("Running testRemoveBook...");
        Bookshelf2 bookshelf = new Bookshelf2();
        Book book1 = new Book(100);
        Book book2 = new Book(200);
        bookshelf.addBook(book1);
        bookshelf.addBook(book2);

        // Test case 1: Remove an existing book
        if (!bookshelf.removeBook(book1)) {
            System.out.println("testRemoveBook failed: Test Case 1: removeBook should return true when removing an existing book.");
            return false;
        }
        if (bookshelf.size() != 1) {
            System.out.println("testRemoveBook failed: Test Case 1: Bookshelf size should be 1 after removing one book.");
            return false;
        }
        if (bookshelf.contains(book1)) {
            System.out.println("testRemoveBook failed: Test Case 1: Bookshelf should not contain the removed book.");
            return false;
        }

        // Test case 2: Remove a non-existing book
        if (bookshelf.removeBook(book1)) {
            System.out.println("testRemoveBook failed: Test Case 2: removeBook should return false when removing a non-existing book.");
            return false;
        }
        if (bookshelf.size() != 1) {
            System.out.println("testRemoveBook failed: Test Case 2: Bookshelf size should remain 1 after attempting to remove a non-existing book.");
            return false;
        }

        // Test case 3: Remove the last book
        if (!bookshelf.removeBook(book2)) {
            System.out.println("testRemoveBook failed: Test Case 3: removeBook should return true when removing the last book.");
            return false;
        }
        if (bookshelf.size() != 0) {
            System.out.println("testRemoveBook failed: Test Case 3: Bookshelf size should be 0 after removing the last book.");
            return false;
        }
        if (bookshelf.size() != 0) // corrected line
        {
            System.out.println("testRemoveBook failed: Test Case 3: The booklist should be empty after removing the last book.");
            return false;
        }

        System.out.println("testRemoveBook passed");
        return true;
    }

    public static boolean testGetTotalPages()
    {
        System.out.println("Running testGetTotalPages...");
        Bookshelf2 bookshelf = new Bookshelf2();
        Book book1 = new Book(100);
        Book book2 = new Book(200);
        Book book3 = new Book(50);
        // Test case 1: Empty Bookshelf
        if(bookshelf.getTotalPages() != 0)
        {
            System.out.println("testGetTotalPages failed: Test Case 1: Empty bookshelf should have 0 pages");
            return false;
        }
        // Test case 2: One book
        bookshelf.addBook(book1);
        if(bookshelf.getTotalPages() != 100)
        {
            System.out.println("testGetTotalPages failed: Test Case 2: One book with 100 pages should return 100");
            return false;
        }
        // Test case 3: Multiple books
        bookshelf.addBook(book2);
        bookshelf.addBook(book3);
        if(bookshelf.getTotalPages() != 350)
        {
            System.out.println("testGetTotalPages failed: Test Case 3: Three books with 100, 200, 50 pages should return 350.  Actual total was: " + bookshelf.getTotalPages());
            return false;
        }
        System.out.println("testGetTotalPages passed");
        return true;
    }

    public static boolean testSize() {
        System.out.println("Running testSize...");
        Bookshelf2 bookshelf = new Bookshelf2();
        Book book1 = new Book(100);
        Book book2 = new Book(200);

        // Test case 1: Empty bookshelf
        if (bookshelf.size() != 0) {
            System.out.println("testSize failed: Test Case 1: Size of an empty bookshelf should be 0.");
            return false;
        }

        // Test case 2: Add one book
        bookshelf.addBook(book1);
        if (bookshelf.size() != 1) {
            System.out.println("testSize failed: Test Case 2: Size should be 1 after adding one book.");
            return false;
        }

        // Test case 3: Add another book
        bookshelf.addBook(book2);
        if (bookshelf.size() != 2) {
            System.out.println("testSize failed: Test Case 3: Size should be 2 after adding two books.");
            return false;
        }

        // Test case 4: Remove a book
        bookshelf.removeBook(book1);
        if (bookshelf.size() != 1) {
            System.out.println("testSize failed: Test Case 4: Size should be 1 after removing one book.");
            return false;
        }
        System.out.println("testSize passed");
        return true;
    }

    public static boolean testClear() {
        System.out.println("Running testClear...");
        Bookshelf2 bookshelf = new Bookshelf2();
        Book book1 = new Book(100);
        Book book2 = new Book(200);
        bookshelf.addBook(book1);
        bookshelf.addBook(book2);

        // Test case 1: Clear a non-empty bookshelf
        bookshelf.clear();
        if (bookshelf.size() != 0) {
            System.out.println("testClear failed: Test Case 1: Size should be 0 after clearing a non-empty bookshelf.");
            return false;
        }
        if (bookshelf.size() != 0) // corrected line
        {
            System.out.println("testClear failed: Test Case 1: The booklist should be empty after clearing a non-empty bookshelf.");
            return false;
        }

        // Test case 2: Clear an empty bookshelf (should not cause an error)
        bookshelf.clear();
        if (bookshelf.size() != 0) {
            System.out.println("testClear failed: Test Case 2: Size should be 0 after clearing an empty bookshelf.");
            return false;
        }
        if (bookshelf.size() != 0) // corrected line
        {
            System.out.println("testClear failed: Test Case 2: The booklist should be empty after clearing an empty bookshelf.");
            return false;
        }
        System.out.println("testClear passed");
        return true;
    }

    public static boolean testContains() {
        System.out.println("Running testContains...");
        Bookshelf2 bookshelf = new Bookshelf2();
        Book book1 = new Book(100);
        Book book2 = new Book(200);
        bookshelf.addBook(book1);

        // Test case 1: Check for a book that is in the bookshelf
        if (!bookshelf.contains(book1)) {
            System.out.println("testContains failed: Test Case 1: contains should return true for a book that is in the bookshelf.");
            return false;
        }

        // Test case 2: Check for a book that is not in the bookshelf
        if (bookshelf.contains(book2)) {
            System.out.println("testContains failed: Test Case 2: contains should return false for a book that is not in the bookshelf.");
            return false;
        }

        // Test case 3: Check for a book after it has been removed
        bookshelf.removeBook(book1);
        if (bookshelf.contains(book1)) {
            System.out.println("testContains failed: Test Case 3: contains should return false for a book that has been removed.");
            return false;
        }
        System.out.println("testContains passed");
        return true;
    }

    public static void main(String[] args) {
        boolean allPassed = true;
        boolean testResult;

        testResult = testBookshelfConstructor();
        System.out.println("testBookshelfConstructor: " + (testResult ? "Passed" : "Failed"));
        allPassed &= testResult;

        testResult = testAddBook();
        System.out.println("testAddBook: " + (testResult ? "Passed" : "Failed"));
        allPassed &= testResult;

        testResult = testRemoveBook();
        System.out.println("testRemoveBook: " + (testResult ? "Passed" : "Failed"));
        allPassed &= testResult;

        testResult = testGetTotalPages();
        System.out.println("testGetTotalPages: " + (testResult ? "Passed" : "Failed"));
        allPassed &= testResult;

        testResult = testSize();
        System.out.println("testSize: " + (testResult ? "Passed" : "Failed"));
        allPassed &= testResult;

        testResult = testClear();
        System.out.println("testClear: " + (testResult ? "Passed" : "Failed"));
        allPassed &= testResult;

        testResult = testContains();
        System.out.println("testContains: " + (testResult ? "Passed" : "Failed"));
        allPassed &= testResult;

        if (allPassed) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}