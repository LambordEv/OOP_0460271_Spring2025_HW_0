package homework0;

public class LibraryTest {

    public static boolean testLibraryConstructor() {
        System.out.println("Running testLibraryConstructor...");
        // Test case 1: Valid maxPages
        try {
            Library library = new Library(1000);
            if (library.getTotalPages() != 0) {
                System.out.println("testLibraryConstructor failed: Test Case 1: Initial total pages should be 0.");
                return false;
            }
            if (library.size() != 0) {
                System.out.println("testLibraryConstructor failed: Test Case 1: Initial size should be 0.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testLibraryConstructor failed: Test Case 1: Unexpected exception: " + e.getMessage());
            return false;
        }

        // Test case 2: Another valid maxPages
        try {
            Library library = new Library(500);
            if (library.getTotalPages() != 0) {
                System.out.println("testLibraryConstructor failed: Test Case 2: Initial total pages should be 0.");
                return false;
            }
            if (library.size() != 0) {
                System.out.println("testLibraryConstructor failed: Test Case 2: Initial size should be 0.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testLibraryConstructor failed: Test Case 2: Unexpected exception: " + e.getMessage());
            return false;
        }

        //test case 3: zero max pages
        try{
            Library library = new Library(0);
            if(library.getTotalPages() != 0){
                System.out.println("testLibraryConstructor failed: Test Case 3: Initial total pages should be 0.");
                return false;
            }
            if(library.size() != 0){
                System.out.println("testLibraryConstructor failed: Test Case 3: initial size should be 0");
                return false;
            }
        } catch(Exception e){
            System.out.println("testLibraryConstructor failed: Test Case 3: Unexpected exception: " + e.getMessage());
            return false;
        }
        System.out.println("testLibraryConstructor passed");
        return true;
    }

    public static boolean testAddBook() {
        System.out.println("Running testAddBook...");
        Library library = new Library(300);
        Book book1 = new Book(100);
        Book book2 = new Book(200);
        Book book3 = new Book(50);

        // Test case 1: Add a book within capacity
        if (library.addBook(book1) != true) {
            System.out.println("testAddBook failed: Test Case 1: Should return true when adding within capacity.");
            return false;
        }
        if (library.getTotalPages() != 100) {
            System.out.println("testAddBook failed: Test Case 1: Total pages should be 100 after adding book1.");
            return false;
        }
        if (library.size() != 1) {
            System.out.println("testAddBook failed: Test Case 1: Size should be 1 after adding book1.");
            return false;
        }
        if (!library.contains(book1)) {
            System.out.println("testAddBook failed: Test Case 1: Library should contain book1 after adding it.");
            return false;
        }

        // Test case 2: Add another book within capacity
        if (library.addBook(book2) != true) {
            System.out.println("testAddBook failed: Test Case 2: Should return true when adding another book within capacity.");
            return false;
        }
        if (library.getTotalPages() != 300) {
            System.out.println("testAddBook failed: Test Case 2: Total pages should be 300 after adding book2.");
            return false;
        }
        if (library.size() != 2) {
            System.out.println("testAddBook failed: Test Case 2: Size should be 2 after adding book2.");
            return false;
        }
        if (!library.contains(book2)) {
            System.out.println("testAddBook failed: Test Case 2: Library should contain book2 after adding it.");
            return false;
        }

        // Test case 3: Add a book exceeding capacity
        if (library.addBook(book3) != false) {
            System.out.println("testAddBook failed: Test Case 3: Should return false when adding a book exceeding capacity.");
            return false;
        }
        if (library.getTotalPages() != 300) {
            System.out.println("testAddBook failed: Test Case 3: Total pages should remain 300 after failing to add book3.");
            return false;
        }
        if (library.size() != 2) {
            System.out.println("testAddBook failed: Test Case 3: Size should remain 2 after failing to add book3.");
            return false;
        }
        if (library.contains(book3)) {
            System.out.println("testAddBook failed: Test Case 3: Library should not contain book3 after failing to add it.");
            return false;
        }

        // Test case 4: Add a book with exact capacity
        Library library2 = new Library(100);
        Book book4 = new Book(100);
        if(library2.addBook(book4) != true){
            System.out.println("testAddBook failed: Test Case 4: Should return true when adding a book with exact capacity");
            return false;
        }
        if(library2.getTotalPages() != 100){
            System.out.println("testAddBook failed: Test Case 4: total pages should be 100");
            return false;
        }
        if(library2.size() != 1){
            System.out.println("testAddBook failed: Test Case 4: size should be 1");
            return false;
        }
        if(!library2.contains(book4)){
            System.out.println("testAddBook failed: Test Case 4: library should contain the book");
            return false;
        }

        // Test case 5: Add a book exceeding capacity after adding a book with exact capacity
        if(library2.addBook(book1) != false){
            System.out.println("testAddBook failed: Test Case 5: Should return false when adding a book exceeding capacity after adding a book with exact capacity");
            return false;
        }
        if(library2.getTotalPages() != 100){
            System.out.println("testAddBook failed: Test Case 5: total pages should be 100");
            return false;
        }
        if(library2.size() != 1){
            System.out.println("testAddBook failed: Test Case 5: size should be 1");
            return false;
        }

        System.out.println("testAddBook passed");
        return true;
    }

    public static boolean testRemoveBook() {
        System.out.println("Running testRemoveBook...");
        Library library = new Library(300);
        Book book1 = new Book(100);
        Book book2 = new Book(200);
        library.addBook(book1);
        library.addBook(book2);

        // Test case 1: Remove an existing book
        if (library.removeBook(book1) != true) {
            System.out.println("testRemoveBook failed: Test Case 1: Should return true when removing an existing book.");
            return false;
        }
        if (library.getTotalPages() != 200) {
            System.out.println("testRemoveBook failed: Test Case 1: Total pages should be 200 after removing book1.");
            return false;
        }
        if (library.size() != 1) {
            System.out.println("testRemoveBook failed: Test Case 1: Size should be 1 after removing book1.");
            return false;
        }
        if (library.contains(book1)) {
            System.out.println("testRemoveBook failed: Test Case 1: Library should not contain book1 after removing it.");
            return false;
        }

        // Test case 2: Remove a non-existing book
        if (library.removeBook(book1) != false) {
            System.out.println("testRemoveBook failed: Test Case 2: Should return false when removing a non-existing book.");
            return false;
        }
        if (library.getTotalPages() != 200) {
            System.out.println("testRemoveBook failed: Test Case 2: Total pages should remain 200 after attempting to remove non existing book.");
            return false;
        }
        if (library.size() != 1) {
            System.out.println("testRemoveBook failed: Test Case 2: Size should remain 1 after attempting to remove non-existing book.");
            return false;
        }

        // Test case 3: Remove the last book
        if (library.removeBook(book2) != true) {
            System.out.println("testRemoveBook failed: Test Case 3: Should return true when removing the last book.");
            return false;
        }
        if (library.getTotalPages() != 0) {
            System.out.println("testRemoveBook failed: Test Case 3: Total pages should be 0 after removing the last book.");
            return false;
        }
        if (library.size() != 0) {
            System.out.println("testRemoveBook failed: Test Case 3: Size should be 0 after removing the last book.");
            return false;
        }
        if (library.contains(book2)) {
            System.out.println("testRemoveBook failed: Test Case 3: Library should not contain book2 after removing it.");
            return false;
        }

        // Test case 4: Remove a book from an empty library
        if(library.removeBook(book2) != false){
            System.out.println("testRemoveBook failed: Test Case 4: Should return false when removing from an empty library");
            return false;
        }
        if(library.getTotalPages() != 0){
            System.out.println("testRemoveBook failed: Test Case 4: Total pages should remain 0 after attempting to remove from empty library");
            return false;
        }
        if(library.size() != 0){
            System.out.println("testRemoveBook failed: Test case 4: size should remain 0 after attempting to remove from empty library");
            return false;
        }

        System.out.println("testRemoveBook passed");
        return true;
    }

    public static boolean testGetTotalPages() {
        System.out.println("Running testGetTotalPages...");
        Library library = new Library(300);
        Book book1 = new Book(100);
        Book book2 = new Book(200);
        Book book3 = new Book(50);

        // Test case 1: Empty library
        if (library.getTotalPages() != 0) {
            System.out.println("testGetTotalPages failed: Test Case 1: Empty library should have 0 pages.");
            return false;
        }

        // Test case 2: Add one book
        library.addBook(book1);
        if (library.getTotalPages() != 100) {
            System.out.println("testGetTotalPages failed: Test Case 2: Library with one book should have 100 pages.");
            return false;
        }

        // Test case 3: Add multiple books
        library.addBook(book2);
        ;
        if (library.addBook(book3) != false) {
            System.out.println("testGetTotalPages failed: Test Case 3: insertion of book3 is illegal, " +
                    "it will exceed the 300 limit that was set.");
            return false;
        }
        System.out.println("testGetTotalPages passed");
        return true;
    }

    public static boolean testSize() {
        System.out.println("Running testSize...");
        Library library = new Library(300);
        Book book1 = new Book(100);
        Book book2 = new Book(200);

        // Test case 1: Empty library
        if (library.size() != 0) {
            System.out.println("testSize failed: Test Case 1: Empty library should have size 0.");
            return false;
        }

        // Test case 2: Add one book
        library.addBook(book1);
        if (library.size() != 1) {
            System.out.println("testSize failed: Test Case 2: Library with one book should have size 1.");
            return false;
        }

        // Test case 3: Add two books
        library.addBook(book2);
        if (library.size() != 2) {
            System.out.println("testSize failed: Test Case 3: Library with two books should have size 2.");
            return false;
        }

        // Test case 4: Remove a book
        library.removeBook(book1);
        if (library.size() != 1) {
            System.out.println("testSize failed: Test Case 4: Library after removing one book should have size 1.");
            return false;
        }
        System.out.println("testSize passed");
        return true;
    }

    public static boolean testClear() {
        System.out.println("Running testClear...");
        Library library = new Library(300);
        Book book1 = new Book(100);
        Book book2 = new Book(200);
        library.addBook(book1);
        library.addBook(book2);

        // Test case 1: Clear a non-empty library
        library.clear();
        if (library.size() != 0) {
            System.out.println("testClear failed: Test Case 1: Clearing a non-empty library should result in size 0.");
            return false;
        }
        if (library.getTotalPages() != 0)
        {
            System.out.println("testClear failed: Test Case 1: Clearing a non-empty library should result in 0 total pages.");
            return false;
        }

        // Test case 2: Clear an empty library
        library.clear();
        if (library.size() != 0) {
            System.out.println("testClear failed: Test Case 2: Clearing an empty library should result in size 0.");
            return false;
        }
        if (library.getTotalPages() != 0)
        {
            System.out.println("testClear failed: Test Case 2: Clearing an empty library should result in 0 total pages.");
            return false;
        }
        System.out.println("testClear passed");
        return true;
    }

    public static boolean testContains() {
        System.out.println("Running testContains...");
        Library library = new Library(300);
        Book book1 = new Book(100);
        Book book2 = new Book(200);
        library.addBook(book1);

        // Test case 1: Check for a book that is in the library
        if (!library.contains(book1)) {
            System.out.println("testContains failed: Test Case 1: contains should return true for a book in the library.");
            return false;
        }

        // Test case 2: Check for a book that is not in the library
        if (library.contains(book2)) {
            System.out.println("testContains failed: Test Case 2: contains should return false for a book not in the library.");
            return false;
        }

        // Test case 3: Check for a book after it has been removed
        library.removeBook(book1);
        if (library.contains(book1)) {
            System.out.println("testContains failed: Test Case 3: contains should return false for a removed book.");
            return false;
        }
        System.out.println("testContains passed");
        return true;
    }

    public static void main(String[] args) {
        boolean allPassed = true;
        boolean testResult;

        testResult = testLibraryConstructor();
        System.out.println("testLibraryConstructor: " + (testResult ? "Passed" : "Failed"));
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