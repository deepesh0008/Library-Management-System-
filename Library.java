import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Library implements LibraryOperations {
    private final Map<Integer, Book> books = new HashMap<>();
    private final Map<Integer, Student> students = new HashMap<>();

    public void addBook(Book book) {
        if (books.containsKey(book.getId())) {
            System.out.println("Book with id " + book.getId() + " already exists. Skipping.");
            return;
        }
        books.put(book.getId(), book);
    }

    public void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            System.out.println("Student with id " + student.getId() + " already exists. Skipping.");
            return;
        }
        students.put(student.getId(), student);
    }

    public Book findBookById(int bookId) throws BookNotFoundException {
        Book book = books.get(bookId);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        return book;
    }

    public Student findStudentById(int studentId) throws StudentNotFoundException {
        Student student = students.get(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
        }
        return student;
    }

    public void viewAllBooks() {
        System.out.println("Library books:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void viewStudentDetails(int studentId) throws StudentNotFoundException {
        Student student = findStudentById(studentId);
        student.displayDetails();
    }

    @Override
    public void issueBook(int bookId, int studentId) throws Exception {
        Book book = findBookById(bookId);
        Student student = findStudentById(studentId);
        student.borrowBook(book);
        System.out.println("Issued book '" + book.getTitle() + "' to student " + student.getName() + ".");
    }

    @Override
    public void returnBook(int bookId, int studentId) throws Exception {
        Book book = findBookById(bookId);
        Student student = findStudentById(studentId);
        student.returnBook(book);
        System.out.println("Returned book '" + book.getTitle() + "' from student " + student.getName() + ".");
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }
}
