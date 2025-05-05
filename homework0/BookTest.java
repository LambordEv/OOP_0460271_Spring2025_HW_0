package homework0;

public class BookTest {

    public static boolean testBookConstructor() {
        System.out.println("Running testBookConstructor...");

        // Test case 1: Valid positive number of pages
        try {
            Book book1 = new Book(100);
            if (book1.getPages() != 100) {
                System.out.println("testBookConstructor failed: Test Case 1: Incorrect page count");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookConstructor failed: Test Case 1: Unexpected exception: " + e.getMessage());
            return false;
        }

        // Test case 2: Valid large number of pages
        try {
            Book book2 = new Book(Integer.MAX_VALUE);
            if (book2.getPages() != Integer.MAX_VALUE) {
                System.out.println("testBookConstructor failed: Test Case 2: Incorrect page count with max int");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookConstructor failed: Test Case 2: Unexpected exception: " + e.getMessage());
            return false;
        }

        // Test case 3: Zero pages
        try {
            new Book(0);
            System.out.println("testBookConstructor failed: Test Case 3: Expected exception for zero pages");
            return false;
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("pages must be greater than 0")) {
                System.out.println("testBookConstructor failed: Test Case 3: Incorrect exception message: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookConstructor failed: Test Case 3: Wrong exception type: " + e.getClass().getName());
            return false;
        }

        // Test case 4: Negative pages
        try {
            new Book(-50);
            System.out.println("testBookConstructor failed: Test Case 4: Expected exception for negative pages");
            return false;
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("pages must be greater than 0")) {
                System.out.println("testBookConstructor failed: Test Case 4: Incorrect exception message: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookConstructor failed: Test Case 4: Wrong exception type: " + e.getClass().getName());
            return false;
        }

        System.out.println("testBookConstructor passed");
        return true;
    }

    public static boolean testBookSetPages() {
        System.out.println("Running testBookSetPages...");
        // Arrange: Create a Book object
        try {
            Book book = new Book(200);
        } catch (Exception e) {
            System.out.println("testBookSetPages failed: Setup failed: " + e.getMessage());
            return false;
        }
        Book book = new Book(200);

        // Test case 1: Set a valid number of pages
        try {
            book.setPages(300);
            if (book.getPages() != 300) {
                System.out.println("testBookSetPages failed: Test Case 1: Incorrect page count after setPages");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookSetPages failed: Test Case 1: Unexpected exception: " + e.getMessage());
            return false;
        }

        // Test case 2: Set another valid number
        try {
            book.setPages(1);
            if (book.getPages() != 1) {
                System.out.println("testBookSetPages failed: Test Case 2: Incorrect page count after setPages");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookSetPages failed: Test Case 2: Unexpected exception: " + e.getMessage());
            return false;
        }

        // Test case 3: Zero pages
        try {
            book.setPages(0);
            System.out.println("testBookSetPages failed: Test Case 3: Expected exception for zero pages");
            return false;
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("pages must be greater than 0")) {
                System.out.println("testBookSetPages failed: Test Case 3: Incorrect exception message: " + e.getMessage());
                return false;
            }
            if (book.getPages() != 1) { // check that the value didn't change
                System.out.println("testBookSetPages failed: Test Case 3: value changed after exception");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookSetPages failed: Test Case 3: Wrong exception type: " + e.getClass().getName());
            return false;
        }

        // Test case 4: Negative pages
        try {
            book.setPages(-100);
            System.out.println("testBookSetPages failed: Test Case 4: Expected exception for negative pages");
            return false;
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("pages must be greater than 0")) {
                System.out.println("testBookSetPages failed: Test Case 4: Incorrect exception message: " + e.getMessage());
                return false;
            }
            if (book.getPages() != 1) { // check that the value didn't change
                System.out.println("testBookSetPages failed: Test Case 4: value changed after exception");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookSetPages failed: Test Case 4: Wrong exception type: " + e.getClass().getName());
            return false;
        }
        System.out.println("testBookSetPages passed");
        return true;
    }

    public static boolean testBookGetPages() {
        System.out.println("Running testBookGetPages...");
        // Test case 1: Valid positive number of pages
        try {
            Book book1 = new Book(42);
            if (book1.getPages() != 42) {
                System.out.println("testBookGetPages failed: Test Case 1: Incorrect page count");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookGetPages failed: Test Case 1: Unexpected exception: " + e.getMessage());
            return false;
        }

        // Test case 2: Another valid positive number of pages
        try {
            Book book2 = new Book(999);
            if (book2.getPages() != 999) {
                System.out.println("testBookGetPages failed: Test Case 2: Incorrect page count");
                return false;
            }
        } catch (Exception e) {
            System.out.println("testBookGetPages failed: Test Case 2: Unexpected exception: " + e.getMessage());
            return false;
        }
        System.out.println("testBookGetPages passed");
        return true;
    }

    public static void main(String[] args) {
        boolean allPassed = true;
        boolean testResult;

        testResult = testBookConstructor();
        System.out.println("testBookConstructor: " + (testResult ? "Passed" : "Failed"));
        allPassed &= testResult;

        testResult = testBookSetPages();
        System.out.println("testBookSetPages: " + (testResult ? "Passed" : "Failed"));
        allPassed &= testResult;

        testResult = testBookGetPages();
        System.out.println("testBookGetPages: " + (testResult ? "Passed" : "Failed"));
        allPassed &= testResult;

        if (allPassed) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}