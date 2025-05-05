package homework0;
import java.util.ArrayList;
/**
 * A container that can be used to store Books. A given Book may only
 * appear in a Bookshelf once.
 */
public class Bookshelf2 {
    private ArrayList<Book> mShelfContains;
    private int mTotalPagesAmount;
    /**
     * @effects Creates a new empty Bookshelf.
     */
    public Bookshelf2() {
        this.mShelfContains = new ArrayList<Book>();
    }

    /**
     * @modifies this
     * @effects Adds book to the Bookshelf.
     * @return true if the book was successfully added,
     *         i.e. the book was not already in the Bookshelf; false otherwise.
     */
    public boolean addBook(Book book) {
        boolean result = !this.mShelfContains.contains(book);

        if (result) {
            this.mShelfContains.add(book);
            this.mTotalPagesAmount += book.getPages();
        }

        return result;
    }

    /**
     * @modifies this
     * @effects Removes book from the Bookshelf.
     * @return true if the book was successfully removed,
     *         i.e. the book was in the Bookshelf; false otherwise.
     */
    public boolean removeBook(Book book) {
        boolean result = this.mShelfContains.contains(book);

        if (result) {
            this.mShelfContains.remove(book);
            this.mTotalPagesAmount -= book.getPages();
        }

        return result;
    }

    /**
     * @return the total number of pages in all the books in the Bookshelf.
     */
    public int getTotalPages() {
        return this.mTotalPagesAmount;
    }

    /**
     * @return the number of books in the Bookshelf.
     */
    public int size() {
        return this.mShelfContains.size();
    }

    /**
     * @modifies this
     * @effects Empties the Bookshelf, i.e., removes all books.
     */
    public void clear() {
        mShelfContains.clear();
    }

    /**
     * @return true if this Bookshelf contains the book; false otherwise.
     */
    public boolean contains(Book book) {
        return mShelfContains.contains(book);
    }
}
