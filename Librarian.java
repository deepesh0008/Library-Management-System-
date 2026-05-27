public class Librarian extends Person {
    public Librarian(int id, String name) {
        super(id, name);
    }

    public void addBookToLibrary(Library library, Book book) {
        library.addBook(book);
    }

    public void addStudentToLibrary(Library library, Student student) {
        library.addStudent(student);
    }

    public void issueBook(Library library, int bookId, int studentId) throws Exception {
        library.issueBook(bookId, studentId);
    }

    public void acceptReturnedBook(Library library, int bookId, int studentId) throws Exception {
        library.returnBook(bookId, studentId);
    }

    @Override
    public void displayDetails() {
        System.out.println("Librarian ID: " + getId());
        System.out.println("Name: " + getName());
    }
}
