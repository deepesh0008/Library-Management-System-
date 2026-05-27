import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends Person {
    private static final int MAX_BORROWED_BOOKS = 3;
    private String department;
    private final List<Book> borrowedBooks;

    public Student(int id, String name, String department) {
        super(id, name);
        this.department = department;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    public void borrowBook(Book book) throws BorrowLimitExceededException, BookAlreadyIssuedException {
        if (borrowedBooks.size() >= MAX_BORROWED_BOOKS) {
            throw new BorrowLimitExceededException("Student " + getName() + " has already borrowed the maximum number of books.");
        }
        if (!book.isAvailable()) {
            throw new BookAlreadyIssuedException("Book " + book.getTitle() + " is already issued.");
        }
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    public void returnBook(Book book) throws InvalidReturnException {
        if (!borrowedBooks.remove(book)) {
            throw new InvalidReturnException("Book " + book.getTitle() + " was not borrowed by student " + getName() + ".");
        }
        book.setAvailable(true);
    }

    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + department);
        System.out.println("Borrowed books: " + borrowedBooks.size());
        for (Book book : borrowedBooks) {
            System.out.println("  - " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}
