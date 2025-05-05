package homework0;

public class TestBook {

    public boolean testConstructorValidPages() {
        boolean testResult = false;
        // Test case 1: Valid positive number of pages
        Book book1 = new Book(100);
        testResult = (100 == book1.getPages());
        if (!testResult) {
            System.out.println("Constructor should set pages correctly for positive input");
        }

        return testResult;
    }

    public boolean testConstructorInvalidPages() {
        boolean testResult = false;

        // Test case 1: Zero pages
        try {
            Book book = new Book(0);
            System.out.println("Constructor should throw an exception for zero pages");
            testResult = false;
        } catch (IllegalArgumentException e) {
            testResult = true;
        }

        // Test case 2: Negative pages
        try {
            Book book = new Book(-10);
            System.out.println("Constructor should throw an exception for a negative input");
            testResult = false;
        } catch (IllegalArgumentException e) {
            testResult = true;
        }

        return testResult;
    }

    public boolean testSetPagesValidInput() {
        boolean testResult = false;

        // Arrange: Create a Book object
        Book book = new Book(200);
        testResult = (200 == book.getPages());
        if(!testResult) {
            System.out.println("Constructor should set pages correctly for positive input");
        }

        // Act: Set a valid number of pages
        book.setPages(300);

        // Assert: Verify that the pages were set correctly
        testResult = (300 == book.getPages());
        if(!testResult) {
            System.out.println("setPages should update the page count for a positive value");
        }

        return testResult;
    }

    public boolean testSetPagesInvalidInput() {
        boolean testResult = false;

        // Arrange: Create a Book object
        Book book = new Book(200);
        testResult = (200 == book.getPages());
        if(!testResult) {
            System.out.println("Constructor should set pages correctly for positive input");
        }

        try {
            book.setPages(-1);
            System.out.println("setPages should throw an exception for a negative value");
            testResult = false;
        } catch (IllegalArgumentException e) {
            testResult = testResult && true;
        }

        try {
            book.setPages(0);
            System.out.println("setPages should throw an exception for zero value");
            testResult = false;
        } catch (IllegalArgumentException e) {
            testResult = testResult && true;
        }

        // Assert: The page count should remain unchanged after attempting to set invalid values.
        if(!(200 == book.getPages())){
           System.out.println("Page count should not change after invalid input");
           testResult = false;
        }

        return testResult;
    }

    public boolean testGetPages() {
        boolean testResult = false;

        // Arrange: Create a Book object with a specific number of pages.
        Book book = new Book(42);

        // Act: Get the number of pages.
        int pages = book.getPages();

        // Assert: Verify that the returned value matches the initial value.
        testResult = (42 == pages);
        if(!testResult) {
            System.out.println("getPages should return the correct number of pages");
        }

        // Arrange: Create another book with different pages
        Book anotherBook = new Book(999);
        if(!(999 == anotherBook.getPages())) {
            System.out.println("getPages should work for different Book instances");
            testResult = false;
        }

        return testResult;
    }

    public static void main(String[] args) {
        TestBook test = new TestBook();
        if (!test.testConstructorValidPages()) {
            System.out.println("constructorTestFailed");
        }

        if (!test.testConstructorInvalidPages()) {
            System.out.println("testConstructorInvalidPages");
        }

        if (!test.testSetPagesValidInput()) {
            System.out.println("testSetPagesValidInput");
        }

        if (!test.testSetPagesInvalidInput()) {
            System.out.println("testSetPagesInvalidInput");
        }

        if (!test.testGetPages()) {
            System.out.println("testGetPages");
        }
    }
}
